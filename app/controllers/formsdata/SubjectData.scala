package controllers.formsdata

import play.api.data.Form
import play.api.data.Forms._
import scala.Some
import models.repositories.{SubjectRepository, UserRepository, GroupRepository}
import models.{Subject, Group}

/**
 * Date: 12/16/13
*/
object SubjectData {
  val subjectCreateForm = Form(
    mapping(
      "name" -> nonEmptyText(6, 32) .verifying(
        "Subject with this name already exists!", subjectName => SubjectRepository.byName(subjectName) == null
      )
    )
    {(name) => new Subject(name)}
    {subject => Some(subject.getName)}
  )

  val subjectEditForm = Form(
    mapping(
      "id" -> number,
      "name" -> nonEmptyText(6, 32) .verifying(
        "Subject with this name already exists!", subjectName => SubjectRepository.byName(subjectName) == null
      )
    )
    {
      (id,name) => {
        val subject = SubjectRepository.byId(id).get
        subject setName name
        subject
      }
    }
    {subject => Some(subject.getSubjectId,subject.getName)}
  )
}
