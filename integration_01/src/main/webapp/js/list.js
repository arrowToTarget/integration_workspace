$(function(){
    $('.update').click(function(){
        var trEle = $(this).parent().parent();
        var tdEles = trEle.children();
        var jdbcUrlTd = tdEles[0];
        var nameEleTd = tdEles[1];
        var userEleTd = tdEles[2];
        var jdbcUrl = jdbcUrlTd.innerHTML;
        var name = nameEleTd.innerHTML;
        var user = userEleTd.innerHTML;
        var url ='http://localhost:8081/config/toUpdate?jdbcUrl='+jdbcUrl+'&name='+name+'&user='+user+'&isUpdate='+true;
        layer.open({
            type: 2,
            area: ['700px', '530px'],
            offset: ['270px', '600px'],
            fix: false, //不固定
            maxmin: true,
            content: url
        });
    });

    $('.search').click(function(){
        var searchName = $('#searchName').val();
        var ctx = $('#ctx').val();
        var url ='http://localhost:8081'+ctx+'/user/all?name='+searchName;
        window.location.href=url;
    });

    $('tr').mouseleave(function(){
        $(this).css('background-color','#ffffff')
    });
    $('tr').mouseenter(function(){
        $(this).css('background-color','#009f95');
    });

    $('.add').click(function(){
        var url ='http://localhost:8081/config/toUpdate?isUpdate='+false;
        layer.open({
            type: 2,
            area: ['700px', '530px'],
            offset: ['270px', '600px'],
            fix: false, //不固定
            maxmin: true,
            content: url
        });
    });

    $('.delete').click(function(){
        var trEle = $(this).parent().parent();
        var tdEles = trEle.children();
        var nameEleTd = tdEles[1];
        var name = nameEleTd.innerHTML;
        var url ='http://localhost:8081/config/delete?name='+name;
        window.location.href = url;
    });

});