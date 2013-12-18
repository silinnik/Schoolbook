package controllers
import play.api.mvc._
import play.api.Routes


/**
 * Date: 12/17/13
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
        GroupController.processRemoveGroups
      )
    ).as("text/javascript")

  }

}
