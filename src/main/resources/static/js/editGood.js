$(document).ready(function () {
        $("#edit-good").submit(function (event) {
                //stop submit the form, we will post it manually.
                event.preventDefault();
                editGood();
            });
});

var number;
var item_index;

function editGood(){
    var request = {}
    request["id"] = $("#id-good").val();
    request["number"] = number;
    request["item_index"] = item_index;
    request["type"] = $("#type").val();
    request["unit_price"] = $("#unit-price").val();
    request["total_price"] = $("#total-price").val();
    request["package_count"] = $("#package-count").val();
    request["count"] = $("#count").val();
    request["manufacturer"] = $("#manufacturer").val();
    request["package"] = $("#package").val();
    request["package_time"] = $("#package-time").val();
    request["year"] = $("#year").val();
    $.ajax({
        type:"POST",
        contentType: "application/json",
        url:"editGood",
        dataType:'json',
        data: JSON.stringify(request),
        success: function(data){
            $('#feedback').html("<pre>" + data.msg + "</pre>");
            console.log("SUCCESS:" , data);
        },
        error: function(e){
            console.log("ERROR:" , e);
            $('#feedback').html("<pre>" + e.message + "</pre>");

        }

    })
}

function getGoodDetail(){
    $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/getGoodDetail?id="+$("#id-good").val(),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {
                if(data.status == 1){
                   number = data.data.number
                   item_index = data.data.item_index
                   $("#id-contract").text(data.data.number)
                   $('#type').val(data.data.type)
                   $('#count').val(data.data.count)
                   $('#package-count').val(data.data.package_count)
                   $('#manufacturer').val(data.data.manufacturer)
                   $('#package').val(data.data.packageName)
                   $('#unit-price').val(data.data.unit_price)
                   $('#total-price').val(data.data.total_price)
                   $('#year').val(data.data.year)
                   $('#package-time').val(data.data.package_time)
                }else{
                   $('#feedback').html("<pre>" + data.msg + "</pre>");
                }
            },
            error: function (e) {
                $('#feedback').html("<pre>" + e.message + "</pre>");
            }
        });
}

getGoodDetail()
