package controllers
import play.api.mvc._
import play.api.Routes


/**
 * This class handles system tasks
*/
object SystemController extends Controller{

  def InitializeSystem = Action {
    testdata.TestDataProvider.InitializeDatabaseWithDefaultValues()
    Ok("Database initialized!")
  }

  def javascriptRoutes = Action { implicit request =>

    import routes.javascript._

    Ok(
      Routes.javascriptRouter("jsRoutes")(
        GroupController.processRemoveGroups,
        MainController.openModalWindow,
        MainController.ajax_submitForm,
        TimetableController.ajax_GroupTimetableEntryFormSubmit,
        TimetableController.ajax_GroupTimetableEntryFormRequest,
        TimetableController.ajax_TimetableGradesRequest,
        TimetableController.ajax_TimetableGradesSubmit

      )
    ).as("text/javascript")

  }

}
