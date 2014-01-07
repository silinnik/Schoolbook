package testdata

import models._

import repositories.MUsersRepository
import utils.DateFactory.Date
import java.util.Calendar

/**
 * Date: 12/15/13
 */
object TestDataProvider {

  def InitializeDatabaseWithDefaultValues() {
    val password = "$2a$10$gB7PcgNsO9mvFd1YHHCifOTj.xMt9qKNKzrwRaOakiLbjop3d3m0y"

    //READY
    val student1 = MUsersRepository.produceNewUser("akeed", "Alice", "Keeden", password, "STUDENT").asInstanceOf[MStudent]
    val student2 = MUsersRepository.produceNewUser("mcern", "Marketa", "Cerna", password, "STUDENT").asInstanceOf[MStudent]
    val student3 = MUsersRepository.produceNewUser("rkita", "Ray", "Kitao", password, "STUDENT").asInstanceOf[MStudent]
    val student4 = MUsersRepository.produceNewUser("mbelm", "Michael", "Belman", password, "STUDENT").asInstanceOf[MStudent]
    val student5 = MUsersRepository.produceNewUser("kmora", "Katka", "Moravcova", password, "STUDENT").asInstanceOf[MStudent]
    val student6 = MUsersRepository.produceNewUser("fstei", "Franz", "Steiner", password, "STUDENT").asInstanceOf[MStudent]
    val student7 = MUsersRepository.produceNewUser("mnova", "Marek", "Novak", password, "STUDENT").asInstanceOf[MStudent]
    val student8 = MUsersRepository.produceNewUser("lgaul", "Loui", "Gaulle", password, "STUDENT").asInstanceOf[MStudent]
    val student9 = MUsersRepository.produceNewUser("xzhao", "Xin", "Zhao", password, "STUDENT").asInstanceOf[MStudent]
    val student10 = MUsersRepository.produceNewUser("lmati", "Laura", "Matias", password, "STUDENT").asInstanceOf[MStudent]
    val student11 = MUsersRepository.produceNewUser("pphil", "Peter", "Phillips", password, "STUDENT").asInstanceOf[MStudent]
    val student12 = MUsersRepository.produceNewUser("njenn", "Natalie", "Jennice", password, "STUDENT").asInstanceOf[MStudent]
    val student13 = MUsersRepository.produceNewUser("dmale", "Dmitry", "Maleev", password, "STUDENT").asInstanceOf[MStudent]
    val student14 = MUsersRepository.produceNewUser("smoja", "Saida", "Mojara", password, "STUDENT").asInstanceOf[MStudent]
    val student15 = MUsersRepository.produceNewUser("dholl", "Daniel", "Hollway", password, "STUDENT").asInstanceOf[MStudent]

    val headmaster = MUsersRepository.produceNewUser("silinnik", "Nikita", "Silin", password, "HEADMASTER")

    //READY
    val subjectMath = new MSubject("Math")
    val subjectPhysics = new MSubject("Physics")
    val subjectChemistry = new MSubject("Chemistry")
    val subjectEnglish = new MSubject("English")

    subjectMath.save()
    subjectPhysics.save()
    subjectChemistry.save()
    subjectEnglish.save()

    //READY
    val teacher1 = MUsersRepository.produceNewUser("jcrai", "Jennifer", "Craig", password, "TEACHER").asInstanceOf[MTeacher]
    val teacher2 = MUsersRepository.produceNewUser("mhoop", "Matias", "Hoopen", password, "TEACHER").asInstanceOf[MTeacher]
    val teacher3 = MUsersRepository.produceNewUser("wwhit", "Walter", "White", password, "TEACHER").asInstanceOf[MTeacher]
    val teacher4 = MUsersRepository.produceNewUser("khalu", "Katarina", "Haluskova", password, "TEACHER").asInstanceOf[MTeacher]

    teacher1.save()
    teacher2.save()
    teacher3.save()
    teacher4.save()

    val Headmaster = MUsersRepository.produceNewUser("headmaster", "Johnny", "Walker", password, "HEADMASTER")
    Headmaster.save()

    //READY
    val groupA = new MGroup("A")
    val groupB = new MGroup("B")
    val groupC = new MGroup("C")

    groupA.save()
    groupB.save()
    groupC.save()

    groupA.addStudent(student1)
    groupA.addStudent(student2)
    groupA.addStudent(student3)
    groupA.addStudent(student4)
    groupA.addStudent(student5)

    groupA.update()

    groupB.addStudent(student6)
    groupB.addStudent(student7)
    groupB.addStudent(student8)
    groupB.addStudent(student9)
    groupB.addStudent(student10)

    groupB.update()

    groupC.addStudent(student11)
    groupC.addStudent(student12)
    groupC.addStudent(student13)
    groupC.addStudent(student14)
    groupC.addStudent(student15)

    groupC.update()

    student1.save()
    student2.save()
    student3.save()
    student4.save()
    student5.save()
    student6.save()
    student7.save()
    student8.save()
    student9.save()
    student10.save()
    student11.save()
    student12.save()
    student13.save()
    student14.save()
    student15.save()



    val TimeentryMath1 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 1, groupA, teacher4, subjectMath)
    val TimeentryPhys1 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 2, groupA, teacher1, subjectPhysics)
    val TimeentryChem1 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 3, groupA, teacher3, subjectChemistry)
    val TimeentryEngl1 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 4, groupA, teacher2, subjectEnglish)
    val TimeentryMath2 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 2, groupB, teacher4, subjectMath)
    val TimeentryPhys2 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 1, groupB, teacher1, subjectPhysics)
    val TimeentryChem2 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 3, groupB, teacher3, subjectChemistry)
    val TimeentryEngl2 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 4, groupB, teacher2, subjectEnglish)
    val TimeentryMath3 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 3, groupC, teacher4, subjectMath)
    val TimeentryPhys3 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 2, groupC, teacher1, subjectPhysics)
    val TimeentryChem3 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 1, groupC, teacher3, subjectChemistry)
    val TimeentryEngl3 = new MTimetableEntry(2013, 36, Calendar.MONDAY, 4, groupC, teacher2, subjectEnglish)


    val TimeentryMath4 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 1, groupB, teacher4, subjectMath)
    val TimeentryPhys4 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 2, groupB, teacher1, subjectPhysics)
    val TimeentryChem4 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 3, groupB, teacher3, subjectChemistry)
    val TimeentryEngl4 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 4, groupB, teacher2, subjectEnglish)
    val TimeentryMath5 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 2, groupC, teacher4, subjectMath)
    val TimeentryPhys5 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 1, groupC, teacher1, subjectPhysics)
    val TimeentryChem5 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 3, groupC, teacher3, subjectChemistry)
    val TimeentryEngl5 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 4, groupC, teacher2, subjectEnglish)
    val TimeentryMath6 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 3, groupA, teacher4, subjectMath)
    val TimeentryPhys6 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 2, groupA, teacher1, subjectPhysics)
    val TimeentryChem6 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 1, groupA, teacher3, subjectChemistry)
    val TimeentryEngl6 = new MTimetableEntry(2013, 36, Calendar.TUESDAY, 4, groupA, teacher2, subjectEnglish)


    val TimeentryMath7 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 1, groupC, teacher4, subjectMath)
    val TimeentryPhys7 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 2, groupC, teacher1, subjectPhysics)
    val TimeentryChem7 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 3, groupC, teacher3, subjectChemistry)
    val TimeentryEngl7 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 4, groupC, teacher2, subjectEnglish)
    val TimeentryMath8 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 2, groupA, teacher4, subjectMath)
    val TimeentryPhys8 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 1, groupA, teacher1, subjectPhysics)
    val TimeentryChem8 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 3, groupA, teacher3, subjectChemistry)
    val TimeentryEngl8 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 4, groupA, teacher2, subjectEnglish)
    val TimeentryMath9 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 3, groupB, teacher4, subjectMath)
    val TimeentryPhys9 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 2, groupB, teacher1, subjectPhysics)
    val TimeentryChem9 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 1, groupB, teacher3, subjectChemistry)
    val TimeentryEngl9 = new MTimetableEntry(2013, 36, Calendar.WEDNESDAY, 4, groupB, teacher2, subjectEnglish)


    TimeentryMath1.save()
    TimeentryMath2.save()
    TimeentryMath3.save()
    TimeentryPhys1.save()
    TimeentryPhys2.save()
    TimeentryPhys3.save()
    TimeentryChem1.save()
    TimeentryChem2.save()
    TimeentryChem3.save()
    TimeentryEngl1.save()
    TimeentryEngl2.save()
    TimeentryEngl3.save()

    TimeentryMath4.save()
    TimeentryPhys4.save()
    TimeentryChem4.save()
    TimeentryEngl4.save()
    TimeentryMath5.save()
    TimeentryPhys5.save()
    TimeentryChem5.save()
    TimeentryEngl5.save()
    TimeentryMath6.save()
    TimeentryPhys6.save()
    TimeentryChem6.save()
    TimeentryEngl6.save()


    TimeentryMath7.save()
    TimeentryPhys7.save()
    TimeentryChem7.save()
    TimeentryEngl7.save()
    TimeentryMath8.save()
    TimeentryPhys8.save()
    TimeentryChem8.save()
    TimeentryEngl8.save()
    TimeentryMath9.save()
    TimeentryPhys9.save()
    TimeentryChem9.save()
    TimeentryEngl9.save()

    val Grade1 = new MGrade(student5, TimeentryMath1, 1, "Extra task")
    val Grade2 = new MGrade(student11, TimeentryPhys3, 2, "Extra task")
    val Grade3 = new MGrade(student15, TimeentryChem2, 3, "Extra task")
    val Grade4 = new MGrade(student3, TimeentryPhys1, 4, "Extra task")
    val Grade5 = new MGrade(student10, TimeentryEngl3, 5, "Extra task")


    Grade1.save()
    Grade2.save()
    Grade3.save()
    Grade4.save()
    Grade5.save()

    val Homework1 = new MHomework(TimeentryMath1, "Chinese Reminders Theorem")
    val Homework2 = new MHomework(TimeentryChem2, "Blue ctystals. Decorative blue crystals.")
    val Homework3 = new MHomework(TimeentryPhys3, "Newton lawlz")
    val Homework4 = new MHomework(TimeentryEngl3, "How have you spent your summer?")

    Homework1.save()
    Homework2.save()
    Homework3.save()
    Homework4.save()


    subjectMath.update()
    subjectPhysics.update()
    subjectChemistry.update()
    subjectEnglish.update()

    teacher1.update()
    teacher2.update()
    teacher3.update()
    teacher4.update()

    groupA.update()
    groupB.update()
    groupC.update()



    Grade1.update()
    Grade2.update()
    Grade3.update()
    Grade4.update()
    Grade5.update()

    Homework1.update()
    Homework2.update()
    Homework3.update()
    Homework4.update()

    TimeentryMath1.update()
    TimeentryMath2.update()
    TimeentryMath3.update()
    TimeentryPhys1.update()
    TimeentryPhys2.update()
    TimeentryPhys3.update()
    TimeentryChem1.update()
    TimeentryChem2.update()
    TimeentryChem3.update()
    TimeentryEngl1.update()
    TimeentryEngl2.update()
    TimeentryEngl3.update()
  }

}
