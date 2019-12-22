/*
function search() {
    var user_id = $("#user_id").val();
    var params = {
        id: user_id
    }
    ajaxPost(params);
}

function ajaxPost(params) {
    $.ajax({
        async: true,
        url: "getUserById",
        data: JSON.stringify(params),
        type: "POST",
        contentType: "application/json",
        sucess: function (response) {
            console.log(response);
            $("#user_id").value = response.id;
            $("#user_name").value = response.name;
            $("#user_sex").value = response.sex;
        }
    });
}
*/
