package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.repositories.{GroupRepository, UserRepository}
import models._
import security.Authenticator
import scala.Some
import scala.collection.JavaConversions._
/**
 * Date: 12/15/13
*/
object GroupData {

       val groupCreateForm = Form(
          mapping(
            "name" -> nonEmptyText(6, 32) .verifying(
              "User with this login already exists!", groupName => GroupRepository.byName(groupName) == null
            ),
            "studentIndicies" -> text
          )
          {(name,indices) => new Group(null,name,UserRepository.byStudentIds(cutIndicesFromString(indices)))}
          {group => Some(group.getName,group.getStudents.map(_.getStudent_id).mkString(","))}
        )

        val groupEditForm = Form(
          mapping(
            "id" -> number,
            "name" -> nonEmptyText(6, 32) .verifying(
              "User with this login already exists!", groupName => GroupRepository.byName(groupName) == null
            ),
            "studentIndicies" -> text
          )
          {
            (id,name,indices) => {
                val group = GroupRepository.byId(id).get
                group.setStudents(UserRepository.byStudentIds(cutIndicesFromString(indices)))
                group setName name
                group
            }
          }
          {group=> Some(group.getGroup_id,group.getName,group.getStudents.map(_.getStudent_id).mkString(" "))}
        )

        private def cutIndicesFromString(str : String) = {
          str.replaceAll("[^0-9]+"," ").split(" ").map(_.toInt).map(i=>i:java.lang.Integer).toList
        }

}
