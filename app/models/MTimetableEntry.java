package models;

import models.repositories.MGroupsRepository;
import models.repositories.MSubjectsRepository;
import models.repositories.MUsersRepository;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Date: 12/24/13
 */

@Entity
public class MTimetableEntry extends BaseModel{


    public MTimetableEntry() {
    }



    public MTimetableEntry(int year, int week, int day_in_week, int number) {
        this.time = getTimeFromYearWeekDayNum(year, week, day_in_week, number);
    }

    public MTimetableEntry(int year, int week, int day_in_week, int number, MGroup group,MTeacher teacher,MSubject subject){
        this.time = getTimeFromYearWeekDayNum(year, week, day_in_week, number);
        this.setGroup(group);
        this.setTeacher(teacher);
        this.setSubject(subject);

    }

    public MTimetableEntry(int year, int week, int day_in_week, int number, int groupId,int teacherId,int subjectId){
        this.time = getTimeFromYearWeekDayNum(year, week, day_in_week, number);
        this.setGroup(MGroupsRepository.byId(groupId));
        this.setTeacher((MTeacher)MUsersRepository.findUserByIndex(teacherId).get());
        this.setSubject(MSubjectsRepository.byId(subjectId));

    }

    @Transient
    private Calendar calendar = Calendar.getInstance();

    private Long time;

    @ManyToOne
    private MGroup group;

    @ManyToOne
    private MTeacher teacher;

    @ManyToOne
    private MSubject subject;

    public int getDay(){
        calendar.setTimeInMillis(getTime());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getYear(){
        calendar.setTimeInMillis(getTime());
        return calendar.get(Calendar.YEAR);
    }

    public int getNumber(){
        calendar.setTimeInMillis(getTime());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getWeek(){
        calendar.setTimeInMillis(getTime());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public MGroup getGroup() {
        return group;
    }

    public void setGroup(MGroup group) {
        this.group = group;
    }

    public MTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MTeacher teacher) {
        this.teacher = teacher;
    }

    public MSubject getSubject() {
        return subject;
    }

    public void setSubject(MSubject subject) {
        this.subject = subject;
    }

    public Calendar getCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getTime());
        return cal;
    }

    @Override
    public String toString() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getTime());
        String res = super.toString()+"\n";    //To change body of overridden methods use File | Settings | File Templates.

        res+="Number: " +cal.get(Calendar.HOUR_OF_DAY)+"\n";
        res+="Day: "    +cal.get(Calendar.DAY_OF_WEEK)+"\n";
        res+="Week: "   +cal.get(Calendar.WEEK_OF_YEAR)+"\n";
        res+="Year: "   +cal.get(Calendar.YEAR)+"\n";

        res+=cal.getTime().toString();
        return res;
    }

   public static long getTimeFromYearWeekDayNum(int y, int w, int d, int n){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,y);
        calendar.set(Calendar.WEEK_OF_YEAR,w);
        calendar.set(Calendar.DAY_OF_WEEK,d);
        calendar.set(Calendar.HOUR_OF_DAY,n);

        return calendar.getTimeInMillis();
    }
}
