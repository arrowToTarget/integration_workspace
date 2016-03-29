$(function(){
    var isUpdate= $('[name=isUpdate]').val();
    if(isUpdate == 'true'){
        $('.update').click(function(){
            var jdbcUrl = $('[name=jdbcUrl]').val();
            var name = $('[name=name]').val();
            var user = $('[name=user]').val();
            var index = parent.layer.getFrameIndex(window.name);
            var url   ="http://localhost:8081/config/update?jdbcUrl="+jdbcUrl+'&name='+name+'&user='+user;
            $.ajax({
                url:url,
                'dataType':'html',
                type:'get',
                success:function(data){
                    parent.location.reload();
                    parent.layer.close(index);
                }
            });

        });
    }else{
        $('[name=name]').attr('readonly',false);
        $('[class=update]').attr('value','add');
        $('.update').click(function(){
            var jdbcUrl = $('[name=jdbcUrl]').val();
            var name = $('[name=name]').val();
            var user = $('[name=user]').val();
            var index = parent.layer.getFrameIndex(window.name);
            var url   ="http://localhost:8081/config/add?jdbcUrl="+jdbcUrl+'&name='+name+'&user='+user;
            $.ajax({
                url:url,
                'dataType':'html',
                type:'get',
                success:function(data){
                    parent.location.reload();
                    parent.layer.close(index);
                }
            });

        });
    }

});