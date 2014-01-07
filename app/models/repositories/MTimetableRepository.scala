package models.repositories

import models.{MGroup, MTimetableEntry}
import java.util.Calendar

/**
 * Date: 1/5/14
 */
object MTimetableRepository {

  val innerRepo = new Repository(classOf[MTimetableEntry])

  def findById(id : Long) = {
    innerRepo.find.byId(id)
  }

  def findByGroup(group: MGroup) = {

    innerRepo.find
      //.fetch("group","name")
      .where()
      .eq("group.id", group.getId)
      .findSet()

  }

  def findByGroupAndWeek(group: MGroup, year: Int, week: Int) = {

    val lowerBound = {
      val cal = Calendar.getInstance()
      cal.set(Calendar.YEAR, year)
      cal.set(Calendar.WEEK_OF_YEAR, week)
      cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      cal.set(Calendar.HOUR_OF_DAY, 0)
      cal.getTimeInMillis
    }

    val upperBound = {
      val cal = Calendar.getInstance()
      cal.set(Calendar.YEAR, year)
      cal.set(Calendar.WEEK_OF_YEAR, week)
      cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
      cal.set(Calendar.HOUR_OF_DAY, 0)
      cal.getTimeInMillis
    }

    innerRepo.find
      .where()
      .gt("time", lowerBound)
      .lt("time", upperBound)
      .eq("group.id", group.getId)
      .findSet()


  }


}
