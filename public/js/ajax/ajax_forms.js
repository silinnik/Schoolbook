

$(function(){


    $(document.body).on('click','form input[data-ajax-route]',function(e){
        e.preventDefault()
        $this = $(this)
        $form = $this.closest('form')

        $route = eval($this.attr('data-ajax-route'))


        $route.ajax({
             data : $form.serialize()
        }).success(function(data){
            $form.replaceWith(data)
        })

    })



})