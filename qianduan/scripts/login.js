//先获得openid
function getOpenId() {
    var id = $("#sid").val();
    var appid = "wx453f3c048acffc6e";
    var url = "https://open.weixin.qq.com/connect/oauth2/authorize?"+
        "appid="+appid+"&"+
        "redirect_uri=http%3A%2F%2Flab.songt.me%2fbind&"+
        "response_type=code&scope=snsapi_base&"+
        "state="+id+"#wechat_redirect";

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(data){
            localStorage.openId = data;
            login(data);
        },
        error: function () {
            $.mobile.changePage("#error");
        }
    });
}

function login(openId) {
    var type = "";
    if ($("input[name='rdoA']:checked").val() == 1){
        type = "student";
    }else {
        type = "teacher";
    }

    var id = $("#sid").val();
    var pass = $("#password").val();
    var url = "http://lab.songt.me/api/bind/"+type+"?"+type+"Id="+id+"&password="+pass+"&openId="+openId;
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(json){
            $.mobile.changePage("#check");
        },
        error: function () {
            $.mobile.changePage("#error");
        }
    });
}