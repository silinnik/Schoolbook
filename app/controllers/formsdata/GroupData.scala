package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.repositories.{GroupRepository, UserRepository}
import models._
import security.Authenticator
import scala.Some
import scala.collection.JavaConversions._
import collection.{immutable, mutable}
import java.util

/**
 * Date: 12/15/13
*/
object GroupData {

       val groupCreateForm = Form(
          mapping(
            "name" -> nonEmptyText(6, 32) .verifying(
              "User with this login already exists!", groupName => GroupRepository.byName(groupName).isEmpty
            ),
            "indices" -> text
          )
          {(name,indices) => {
            val group = new Group(null,name,null)
            group.setStudents(indicesFromString(indices))
            group
            }
          }
          {group => Some(group.getName,group.getStudentIds)}
        )

       val groupEditForm = Form(
          mapping(
            "id" -> number,
            "name" -> nonEmptyText(6, 32) .verifying(
              "User with this login already exists!", groupName => GroupRepository.byName(groupName).isEmpty
            ),
            "indices" -> text
          )
          {
            (id,name,indices) => {
                val group = GroupRepository.byId(id).get
                group setName name
                group.setStudents(indicesFromString(indices))
                group
            }
          }
          {group=> Some(group.getGroup_id,group.getName,group.getStudentIds)}
        )

          private def studentsFromIndexString(str : String) : Set[Student] = {
            if(str!=""){ indicesFromString(str).map(i=>UserRepository.findById(i).get.asInstanceOf[Student]).toSet}
            else {new immutable.HashSet[Student]()}

          }

          private def indicesFromString(str : String) : List[java.lang.Integer] = {
            if(str!=""){ str.replaceAll("[^0-9]+"," ").split(" ").map(_.toInt).map(i=>i : java.lang.Integer).toList}
            else {List[java.lang.Integer]()}

          }

}
