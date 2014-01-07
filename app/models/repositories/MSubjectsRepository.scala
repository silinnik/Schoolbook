package models.repositories

import models.MSubject

/**
 * Date: 1/5/14
 */
object MSubjectsRepository {
  def byId(i: Int): MSubject = {
    innerRepository.get(i).get
  }
  val innerRepository = new Repository(classOf[MSubject])


  def all() = {
    innerRepository.all()
  }

}
