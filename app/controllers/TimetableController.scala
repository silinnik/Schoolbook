package controllers
import play.api.mvc._
import models.repositories.TimetableEntryRepository
import scala.collection.JavaConversions._
import java.util.{GregorianCalendar, Calendar}
import java.sql.Date

/**
 * Date: 12/14/13
*/
object TimetableController extends Controller {

  def showTimetableForGroup(groupId: Int,year :Int, week: Int) = Action { request =>
    val timetableEntries = TimetableEntryRepository.all().filter(_.isAt(year,week))
    println(timetableEntries.size)
    for(tr <- TimetableEntryRepository.all()){
      //println("Year: "+tr.getTime.getYear + " Day: " + tr.getDayOfTheWeek + " Number: " + tr.getNumber + " Group : " + tr.getGroup )
    }
    Ok(views.html.timetableviews.viewgrouptimetable.render(timetableEntries,request))
  }

}
