package testdata

import models._
import java.sql.Date

/**
 * Date: 12/15/13
*/
object TestDataProvider {

  def InitializeDatabaseWithDefaultValues() {
    val password = "$2a$10$gB7PcgNsO9mvFd1YHHCifOTj.xMt9qKNKzrwRaOakiLbjop3d3m0y"

    //READY
    val student1 = new Student("akeed","Alice","Keeden",password)
    val student2 = new Student("mcern","Marketa","Cerna",password)
    val student3 = new Student("rkita","Ray","Kitao",password)
    val student4 = new Student("mbelm","Michael","Belman",password)
    val student5 = new Student("kmora","Katka","Moravcova",password)
    val student6 = new Student("fstei","Franz","Steiner",password)
    val student7 = new Student("mnova","Marek","Novak",password)
    val student8 = new Student("lgaul","Loui","Gaulle",password)
    val student9 = new Student("xzhao","Xin","Zhao",password)
    val student10 = new Student("lmati","Laura","Matias",password)
    val student11 = new Student("pphil","Peter","Phillips",password)
    val student12 = new Student("njenn","Natalie","Jennice",password)
    val student13 = new Student("dmale","Dmitry","Maleev",password)
    val student14 = new Student("smoja","Saida","Mojara",password)
    val student15 = new Student("dholl","Daniel","Hollway",password)

    val headmaster = new Student("silinnik","Nikita","Silin",password)

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

    //READY
    val subjectMath = new Subject("Math")
    val subjectPhysics = new Subject("Physics")
    val subjectChemistry = new Subject("Chemistry")
    val subjectEnglish = new Subject("English")

    subjectMath.save()
    subjectPhysics.save()
    subjectChemistry.save()
    subjectEnglish.save()

    //READY
    val teacher1 = new Teacher("jcrai","Jennifer","Craig",password)
    val teacher2 = new Teacher("mhoop","Matias","Hoopen",password)
    val teacher3 = new Teacher("wwhit","Walter","White",password)
    val teacher4 = new Teacher("khalu","Katarina","Haluskova",password)

    teacher1.save()
    teacher2.save()
    teacher3.save()
    teacher4.save()

    //READY
    val groupA = new Group(null,"A",null)
    val groupB = new Group(null,"B",null)
    val groupC = new Group(null,"C",null)

    groupA.save()
    groupB.save()
    groupC.save()

    val TimeentryMath1 = new TimetableEntry(new Date(2013,9,2),1,groupA,teacher4,subjectMath,null,null)
    val TimeentryMath2 = new TimetableEntry(new Date(2013,10,2),1,groupB,teacher4,subjectMath,null,null)
    val TimeentryMath3 = new TimetableEntry(new Date(2013,9,2),3,groupC,teacher4,subjectMath,null,null)
    val TimeentryPhys1 = new TimetableEntry(new Date(2013,9,2),4,groupA,teacher1,subjectPhysics,null,null)
    val TimeentryPhys2 = new TimetableEntry(new Date(2013,9,2),6,groupB,teacher1,subjectPhysics,null,null)
    val TimeentryPhys3 = new TimetableEntry(new Date(2013,11,2),4,groupC,teacher1,subjectPhysics,null,null)
    val TimeentryChem1 = new TimetableEntry(new Date(2013,12,2),1,groupA,teacher3,subjectChemistry,null,null)
    val TimeentryChem2 = new TimetableEntry(new Date(2013,13,2),2,groupB,teacher3,subjectChemistry,null,null)
    val TimeentryChem3 = new TimetableEntry(new Date(2013,9,2),2,groupC,teacher3,subjectChemistry,null,null)
    val TimeentryEngl1 = new TimetableEntry(new Date(2013,12,2),2,groupA,teacher2,subjectEnglish,null,null)
    val TimeentryEngl2 = new TimetableEntry(new Date(2013,10,2),3,groupB,teacher2,subjectEnglish,null,null)
    val TimeentryEngl3 = new TimetableEntry(new Date(2013,9,2),5,groupC,teacher2,subjectEnglish,null,null)


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

    groupA.getStudents.add(student1)
    groupA.getStudents.add(student2)
    groupA.getStudents.add(student3)
    groupA.getStudents.add(student4)
    groupA.getStudents.add(student5)

    groupB.getStudents.add(student6)
    groupB.getStudents.add(student7)
    groupB.getStudents.add(student8)
    groupB.getStudents.add(student9)
    groupB.getStudents.add(student10)

    groupC.getStudents.add(student11)
    groupC.getStudents.add(student12)
    groupC.getStudents.add(student13)
    groupC.getStudents.add(student14)
    groupC.getStudents.add(student15)


    groupA.getTimetable_entries.add(TimeentryChem1)
    groupA.getTimetable_entries.add(TimeentryPhys1)
    groupA.getTimetable_entries.add(TimeentryMath1)
    groupA.getTimetable_entries.add(TimeentryEngl1)
    groupB.getTimetable_entries.add(TimeentryChem2)
    groupB.getTimetable_entries.add(TimeentryPhys2)
    groupB.getTimetable_entries.add(TimeentryMath2)
    groupB.getTimetable_entries.add(TimeentryEngl2)
    groupC.getTimetable_entries.add(TimeentryChem3)
    groupC.getTimetable_entries.add(TimeentryPhys3)
    groupC.getTimetable_entries.add(TimeentryMath3)
    groupC.getTimetable_entries.add(TimeentryEngl3)

    val Grade1 = new Grade(student5,TimeentryMath1,1,"Extra task")
    val Grade2 = new Grade(student11,TimeentryPhys3,2,"Extra task")
    val Grade3 = new Grade(student15,TimeentryChem2,3,"Extra task")
    val Grade4 = new Grade(student3,TimeentryPhys1,4,"Extra task")
    val Grade5 = new Grade(student10,TimeentryEngl3,5,"Extra task")


    Grade1.save()
    Grade2.save()
    Grade3.save()
    Grade4.save()
    Grade5.save()

    val Homework1 = new Homework(TimeentryMath1,"Chinese Reminders Theorem")
    val Homework2 = new Homework(TimeentryChem2,"Blue ctystals. Decorative blue crystals.")
    val Homework3 = new Homework(TimeentryPhys3,"Newton lawlz")
    val Homework4 = new Homework(TimeentryEngl3,"How have you spent your summer?")

    Homework1.save()
    Homework2.save()
    Homework3.save()
    Homework4.save()

    TimeentryMath1.setHomework(Homework1)
    TimeentryMath2.setHomework(Homework1)
    TimeentryMath3.setHomework(Homework1)
    TimeentryChem1.setHomework(Homework2)
    TimeentryChem2.setHomework(Homework2)
    TimeentryChem3.setHomework(Homework2)
    TimeentryPhys1.setHomework(Homework3)
    TimeentryPhys2.setHomework(Homework3)
    TimeentryPhys3.setHomework(Homework3)
    TimeentryChem2.getGrades.add(Grade3)
    TimeentryMath1.getGrades.add(Grade1)
    TimeentryPhys1.getGrades.add(Grade4)
    TimeentryPhys3.getGrades.add(Grade2)
    TimeentryEngl3.getGrades.add(Grade5)

    student1.update()
    student2.update()
    student3.update()
    student4.update()
    student5.update()
    student6.update()
    student7.update()
    student8.update()
    student9.update()
    student10.update()
    student11.update()
    student12.update()
    student13.update()
    student14.update()
    student15.update()

    subjectMath.update()
    subjectPhysics.update()
    subjectChemistry.update()
    subjectEnglish.update()

    teacher1.save()
    teacher2.save()
    teacher3.save()
    teacher4.save()

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
