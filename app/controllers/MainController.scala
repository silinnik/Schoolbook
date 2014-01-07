package controllers

import formsdata.LoginData
import play.api.mvc.Controller
import models._
import play.api.data.Forms._
import play.api.data.Form
import play.api.mvc._
import scala.collection.JavaConversions._
import com.avaje.ebean.Ebean
import repositories.{MTimetableRepository, MGroupsRepository, MUsersRepository, UserRepository}
import java.util.{TimeZone, GregorianCalendar, Calendar}

/**
 * This is a main controller
 */
object MainController extends Controller {

  /**
   * This action shows the main page
   */

  case class TestData(number: Int, msg: String)

  val TestForm = Form(mapping(
    "number" -> number,
    "msg" -> nonEmptyText(10, 15)
  )(TestData.apply)(TestData.unapply))


  def viewMainPage() = Action {
    implicit request =>

      //testdata.TestDataProvider.InitializeDatabaseWithDefaultValues()
      //Ok(views.html.Playground.render())

      val group = MGroupsRepository.innerRepository.find.byId(1)
      val timetableEntries = MTimetableRepository.findByGroupAndWeek(group,2013,36)

      Ok(
          views.html.timetableviews.GroupTimetableView(timetableEntries,group.getId,2013,36)
      )
  }

  def openModalWindow() = Action {
    implicit request =>

      Ok(views.html.TestModalWindow.render(MainController.TestForm))
  }

  def ajax_submitForm() = Action {
    implicit request =>
      TestForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.TestModalWindow.render(formWithErrors)),
        good => Ok("Submitted")
      )

  }

}
