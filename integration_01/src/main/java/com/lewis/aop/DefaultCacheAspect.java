package com.lewis.aop;

import com.lewis.annotation.CacheAnnotations;
import com.lewis.service.ICacheService;
import com.lewis.vo.CacheVo;
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
                        List<?> listCache = cacheService.getListCache(cacheVo.getKey(), cacheVo.getElementType());
                        modelMap.addAttribute(cacheVo.getKey(), listCache);
                    }else{
                        Object cache = cacheService.getCache(cacheVo.getKey(), cacheVo.getValueType());
                        modelMap.addAttribute(cacheVo.getKey(),cache);
                    }
                }
            }
            if (modelMap.size() == 0) {
                proceed = joinPoint.proceed();
                setCacheAfterExecutionDB(cacheAnnotations, modelMap);
                return proceed;
            }
            return cacheAnnotations.returnAddress();
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
            cacheService.setCache(entry.getKey(), entry.getValue(), cacheAnnotations.expireTime());
            cacheKeyIndexList.add(new CacheVo(entry.getKey(),valueType,elementType));
        }
        //设置缓存索引
        cacheService.setCache(cacheAnnotations.name(), cacheKeyIndexList, cacheAnnotations.expireTime());
    }
}
