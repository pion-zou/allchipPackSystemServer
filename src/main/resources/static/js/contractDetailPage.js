$(document).ready(function () {
    $('#btn-print').on('click', function (event) {
      event.preventDefault(); // To prevent following the link (optional)
      printQRCode()
  })
   $('#btn-remove').on('click', function (event) {
         removeGoods();
    })
  fire_ajax_submit()

});
var contract_number;
function printQRCode(){

    $.ajax({
        type: "GET",
        url: "/printQRCode?number=" + contract_number,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function(data){
var json = "<pre>"
                                         + data.msg + "</pre>";
                                     $('#feedback').html(json);
            console.log("SUCCESS : ", data);
        },
        error: function(e){
         var json = "<pre>"
                                                         + e.responseText + "</pre>";
                                                     $('#feedback').html(json);
            console.log("ERROR: " , e)
        }

    })
}

function removeGoods(){
    $.ajax({
        type: "GET",
        url: "removeGoods?number=" + contract_number,
        dataType: 'json',
        success: function(data){
             console.log("SUCCESS : ", data);
             var json = "<pre>"
                                         + data.msg + ", 刷新界面</pre>";
                                     $('#feedback').html(json);

        },
        error: function(e){
        var json = "<pre>"
                                                 + e.responseText + "</pre>";
                                             $('#feedback').html(json);
             console.log("ERROR: " , e)

        }
    })
}

function fire_ajax_submit() {
    var request = {}
    request["id"] = $("#contract_id").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/getContractDetail",
        data: JSON.stringify(request),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "";
            if (data.status == 1) {
                contract_number  = data.data.number;
                    var trTemp = $("<tr></tr>");
                    trTemp.append("<td>"+data.data.id + "</td>")
                    trTemp.append("<td>"+data.data.number + "</td>")
                    trTemp.append("<td>"+data.data.creator + "</td>")
                    trTemp.append("<td>"+data.data.remark + "</td>")
                    trTemp.append("<td>"+data.data.create_time + "</td>")
                    trTemp.append("<td>"+data.data.state + "</td>")
                    trTemp.append("<td>"+data.data.update_time + "</td>")
                    trTemp.append("<td>"+data.data.editor + "</td>")
                    trTemp.append("<td>"+data.data.publish_time + "</td>")
                    trTemp.appendTo("#contract_list");
                    for(var index = 0 ; index < data.data.goodList.length ; index++){
                        var trGood = $("<tr></tr>");
                                            trGood.append("<td>"+data.data.goodList[index].id + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].item_index + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].type + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].count + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].package_count + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].manufacturer + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].packageName + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].unit_price + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].total_price + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].year + "</td>")
                                            trGood.append("<td>"+data.data.goodList[index].package_time + "</td>")
                                            trGood.append("<td>"+ "编辑" + "</td>")
                                            trGood.appendTo("#good_list");
                    }
                $('#feedback').html(data.responseText);
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



