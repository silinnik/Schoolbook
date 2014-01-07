package models.repositories

import models.MGroup

/**
 * Date: 12/26/13
*/
object MGroupsRepository {



  val innerRepository = new Repository(classOf[MGroup])


  def byId(id: Int): MGroup = {
    innerRepository.get(id).get
  }




}
