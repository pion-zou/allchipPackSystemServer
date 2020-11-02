$(document).ready(function () {
    $("#edit-contract").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        editContract();
    });
   $("#add-good").submit(function (event) {
           //stop submit the form, we will post it manually.
           event.preventDefault();
           addContractGood();
       });
});

function editContract(){
var request = {}
    request["state"] = $("#state").val();
        request["editor"] = $("#editor").val();
            request["publish_time"] = $("#publish_time").val();
                request["remark"] = $("#remark").val();
                request["id"] = $("#contract_id").val();
                request["number"] = $("#number").val();
                $.ajax({
                    url: 'editContract',
                    type: 'POST',
                    cache: false,
                    contentType: "application/json",
                    timeout: 60000,
                    data: JSON.stringify(request),
                    dataType: 'json',
                    success: function (response) {
                        if (response.status == "1") {
                            $('#feedback-edit').html("<pre class=\"bg-success\">" + response.msg + "</pre>");
                        }else if (response.status == "0") {
                            $('#feedback-edit').html("<pre class=\"bg-danger\">" + response.msg + "</pre>");
                        }
                        console.log("SUCCESS : ", response);
                        $("#btn-edit").prop("disabled", false);

                    },
                    error: function (e){
                        $('#feedback-edit').html("<pre class=\"bg-danger\">" + e.responseJSON.message + "</pre>");
                        console.log("ERROR : ", e);
                        $("#btn-edit").prop("disabled", false);

                    }
                })
}

function addContractGood(){
                var formData = new FormData();
                formData.append('file', $('#goods_file')[0].files[0]);
                formData.append('number', $('#number').val());
                $.ajax({
                    url: 'addContractGood',
                    type: 'POST',
                    cache: false,
                    processData: false,
                    contentType: false,
                    data: formData,
                    dataType: 'json',
                    success: function (response) {
                            if (response.status == "1") {
                            $('#feedback').html("<pre class=\"bg-success\">" + response.msg + "</pre>");
                        }else if (response.status == "0") {
                            $('#feedback').html("<pre class=\"bg-danger\">" + response.msg + "</pre>");
                        }                        console.log("SUCCESS :" , response)
                    },
                    error: function (e){
                        $('#feedback').html("<pre class=\"bg-danger\">" + e.responseJSON.message + "</pre>");
                        console.log("ERROR : ", e);
                    }
                })
}


function getContractDetail(){
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
                if(data.status == 1){
                   $("#state").val(data.data.state)
                   $("#editor").val(data.data.editor)
                   $("#publish_time").val(data.data.publish_time)
                   $("#remark").val(data.data.remark)
                   $("#number").val(data.data.number)
                }else{
                   $('#feedback').html(data.msg);
                }
            },
            error: function (e) {
                   $('#feedback').html(e.message);
            }
        });
}

getContractDetail()
