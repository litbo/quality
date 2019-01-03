

function Jajax(arg){
    var dts = function(callback){
        $.ajax({
            url:arg.url,
            data:arg.data,
            success:callback
        })
    };
    dts(arg.success(data))
}