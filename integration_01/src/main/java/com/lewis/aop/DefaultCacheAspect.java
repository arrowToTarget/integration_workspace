package com.lewis.aop;

import com.lewis.annotation.CacheAnnotations;
import com.lewis.service.ICacheService;
import com.lewis.util.StringUtils;
import com.lewis.vo.CacheVo;
import com.lewis.vo.ResponseVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.support.BindingAwareModelMap;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by zhangminghua on 2016/3/29.
 */
@Aspect
@Component
public class DefaultCacheAspect {

    @Resource
    private ICacheService cacheService;

    @Around(value = "@annotation(cacheAnnotations)", argNames = "joinPoint,cacheAnnotations")
    public Object defaultCahceMethod(ProceedingJoinPoint joinPoint, CacheAnnotations cacheAnnotations) throws Throwable {
        Object[] args = joinPoint.getArgs();
        BindingAwareModelMap modelMap = null;
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                if (arg != null && arg instanceof BindingAwareModelMap) {
                    modelMap = (BindingAwareModelMap) arg;
                }
            }
        }
        Object proceed = null;
        //一般使用model向页面传递数据
        if (modelMap != null) {
            //获取缓存索引
            List<CacheVo> cachekeyIndexList = cacheService.getListCache(cacheAnnotations.name(), CacheVo.class);
            if (cachekeyIndexList != null && cachekeyIndexList.size() > 0) {
                for (CacheVo cacheVo : cachekeyIndexList) {
                    if (cacheVo.getValueType() == List.class) {
                        List<?> listValueAll = cacheService.getListValueAll(cacheVo.getKey(), cacheVo.getElementType());
                        modelMap.addAttribute(cacheVo.getKey(), listValueAll);
                    }else if (cacheVo.getValueType() == null){
                        Object cache = cacheService.getCache(cacheVo.getKey(), cacheVo.getElementType());
                        if (cache != null) {
                            modelMap.addAttribute(cacheVo.getKey(),cache);
                        }
                    }else{
                        Object cache = cacheService.getCache(cacheVo.getKey(), cacheVo.getValueType());
                        if (cache != null) {
                            modelMap.addAttribute(cacheVo.getKey(),cache);
                        }
                    }
                }
            }
            if (modelMap.size() == 0) {
                proceed = joinPoint.proceed();
                Object target = joinPoint.getTarget();
                System.out.println("target = "+target);
                setCacheAfterExecutionDB(cacheAnnotations, modelMap);
                return proceed;
            }
            if (StringUtils.isNotEmpty(cacheAnnotations.returnAddress())) {
                return cacheAnnotations.returnAddress();
            }
        }else{
            //不用modelMap向页面返回东西，而是直接返回对象
            Object cache = cacheService.getCache(cacheAnnotations.name(), cacheAnnotations.returnObjectType());
            if (cache != null) {
                return cache;
            }else{
                Object result = joinPoint.proceed();
                System.out.println("target className ="+result.getClass().getName());
                System.out.println("target class ="+result.getClass());
                cacheService.setCache(cacheAnnotations.name(),result,cacheAnnotations.expireTime());
                return result;
            }
        }
        return proceed;
    }

    private void setCacheAfterExecutionDB(CacheAnnotations cacheAnnotations, BindingAwareModelMap modelMap) {
        Iterator<Map.Entry<String, Object>> it = modelMap.entrySet().iterator();
        //缓存索引列表 相当于一级索引
        List<CacheVo> cacheKeyIndexList = new LinkedList<CacheVo>();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            Object value = entry.getValue();
            Class<?> valueType = null;
            Class<?> elementType = null;
            if (value instanceof List) {
                valueType = List.class;
                List listValue = (List) value;
                for (Object element : listValue) {
                    elementType = element.getClass();
                    break;
                }
            } else {
                elementType = value.getClass();
            }
            if (valueType == List.class) {
                List listValue = (List) entry.getValue();
                cacheService.lpush(entry.getKey(),cacheAnnotations.expireTime(),listValue);
            }else{
                cacheService.setCache(entry.getKey(), entry.getValue(), cacheAnnotations.expireTime());
            }
            cacheKeyIndexList.add(new CacheVo(entry.getKey(),valueType,elementType));
        }
        //设置缓存索引
        cacheService.setCache(cacheAnnotations.name(), cacheKeyIndexList, cacheAnnotations.expireTime());
    }
}
