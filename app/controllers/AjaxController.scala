package controllers

import play.api.mvc.{Action, Controller}

/**
 * Date: 12/16/13
*/
object AjaxController extends Controller{

  def processAjaxMessage(msg : String) = Action { request =>


    println("Got a message!")

    Ok(views.html.ajaxtest.render(msg))
  }

  def show = Action { request =>
    Ok(views.html.ajaxpage.render(request))
  }

}
