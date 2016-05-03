$(function(){


});
$(".add").click(function(){
    var person ='{"id":100,"name":"lewis","sex":"male"}';
    var url   ="/web/user/add";
    $.ajax({
        url:url,
        'dataType':'json',
        type:'post',
        data:person,
       headers:{
            "Content-Type":" application/json; charset=utf-8",
            "Accept":"application/json"
        },
        success:function(data){
            console.log(data);
        }
    });
});