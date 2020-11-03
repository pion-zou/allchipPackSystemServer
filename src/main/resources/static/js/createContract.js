$(document).ready(function (){
    $('#edit-contract').submit(function(event){
        event.preventDefault();
        createContract();
    })
})


function createContract(){
    var request = {}
    request['number'] = $('#number').val();
    request['state'] = $('#state').val();
    request['creator'] = $('#creator').val();
    request['publish_time'] = $('#publish_time').val();
    request['remark'] = $('#remark').val();
    $.ajax({
        url: 'createContract',
        type: 'POST',
        contentType:'application/json',
        data: JSON.stringify(request),
        dataType: 'json',
        success: function(response){
            console.log("success:" , response);
            $('#feedback').html("<pre>" + response.msg + "</pre>")
        },
        error: function(e){
            console.log("error:" , e);
            $('#feedback').html("<pre>" + e.message + "</pre>")
        }
    })
}