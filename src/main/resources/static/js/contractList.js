
function fire_ajax_submit() {
    var request = {}
    //search["email"] = $("#email").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/getContractList",
        data: JSON.stringify(request),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "";
            if (data.status == 1) {
                for (j = 0; j < data.data.length; j++) {
                    var trTemp = $("<tr></tr>");
                    trTemp.append("<td>"+data.data[j].id + "</td>")
                    trTemp.append("<td>"+data.data[j].number + "</td>")
                    trTemp.append("<td>"+data.data[j].creator + "</td>")
                    trTemp.append("<td>"+data.data[j].remark + "</td>")
                    trTemp.append("<td>"+data.data[j].create_time + "</td>")
                    trTemp.append("<td>"+data.data[j].state + "</td>")
                    trTemp.append("<td>"+data.data[j].update_time + "</td>")
                    trTemp.append("<td>"+data.data[j].editor + "</td>")
                    trTemp.append("<td>"+data.data[j].publish_time + "</td>")
                    trTemp.append("<td><a class=\"btn btn-primary \" href=\"editContractPage?id="+data.data[j].id + "\">编辑</a></td>")
                    trTemp.append("<td><a class=\"btn btn-default \" href=\"contractDetailPage?id="+data.data[j].id + "\">详情</a></td>")
                    trTemp.appendTo("#contract_list");
                }
                $('#feedback').html(json);
                console.log("SUCCESS : ", data);
            } else {
                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);
                console.log("SUCCESS : ", data);
            }

        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
        }
    });
}

fire_ajax_submit()