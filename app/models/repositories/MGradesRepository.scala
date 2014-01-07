package models.repositories

import models.MGrade

/**
 * Date: 1/6/14
 */
object MGradesRepository {

  val innerRepository = new Repository(classOf[MGrade])


  def findForTimetableId(id : Long) = {
    innerRepository.find
      .where()
        .eq("timetable_entry.id",id)
      .findSet()
  }


}
