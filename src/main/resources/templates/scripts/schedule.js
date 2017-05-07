function a(id) {
    var url = "";
    $.ajax({
        type: "GET",
        url: url,
        data: {id: id},
        dataType: "json",
        success: function (data) {
            doSuccess(data);
        }
    });

}

function doSuccess(data) {
    $("#course").html("");
    $("#room").html("");
    $("#teacher").html("");
    $("#time").html("");
    $("#week").html("");
    $("#class").html("");
    $.mobile.changePage("#info");
}