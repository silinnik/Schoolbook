/**
 * Handles modals delivered as objects.
 */


function showModal(data){

    $data = $(data)
    ts = new Date().getTime()
    $data.attr('id',ts)
    $data.appendTo(document.body)
    $('#'+ts).modal();

}

$(function(){

    $(document.body).on('click','[data-dismiss="modal"]',function(){
        $this = $(this)
        setTimeout(function(){
            $this.closest('.remove-on-close').remove()
        },500)
    })
})