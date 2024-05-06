package Lab5;

import java.util.*;

public class task3 {
    public static void main(String[] args){
        Archive archive = new Archive();
        Student student1 = new Student("Бубен Станислав Олеговочи","ПО-8");
        Student student2 = new Student("Бувин Дмитрий Александрович","ПО-8");
        Student student3 = new Student("Назаров Кирилл Викторович","ПО-8");

        Course course1 = new Course("Компьютерные системы и сети");
        Course course2 = new Course("Проектирование интернет систем");
        Teacher teacher = new Teacher("Гречаник Татьяна Викторовна");

        teacher.addCourse(course1);
        teacher.announceCourseRegistration(course1);
        student1.enrollInCourse(course1);
        student2.enrollInCourse(course1);
        student3.enrollInCourse(course1);
        teacher.evaluateTheStudent(archive,course1,student1,new Mark(5));
        teacher.evaluateTheStudent(archive,course1,student2,new Mark(5));
        teacher.evaluateTheStudent(archive,course1,student3,new Mark(4));
        teacher.removeCourse(course1);

        System.out.println();

        teacher.addCourse(course2);
        teacher.announceCourseRegistration(course2);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course2);
        student3.enrollInCourse(course2);
        teacher.evaluateTheStudent(archive,course2,student1,new Mark(2));
        teacher.evaluateTheStudent(archive,course2,student2,new Mark(2));
        teacher.evaluateTheStudent(archive,course2,student3,new Mark(4));
        teacher.removeCourse(course2);

        archive.printArchive();
    }
}

abstract class Person{
    protected String name;
    Person(String name){
        this.name = name;
    }

   public void setName(String name){
        this.name = name;
   }
   public String getName(){
        return this.name;
   }
}

interface TeacherInterface{
    void addCourse(Course course);
    void announceCourseRegistration(Course course);
    void removeCourse(Course course);
    void evaluateTheStudent(Archive archive,Course course, Student student, Mark mark);
    ArrayList<Course> getCourses();
}

class Teacher extends Person implements TeacherInterface{

    private ArrayList<Course> courses;

    public Teacher(String name) {
        super(name);
        this.courses = new ArrayList<>();
    }
    @Override
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    @Override
    public void addCourse(Course course){
        course.setTeacher(this);
        this.courses.add(course);
    }
    @Override
    public void announceCourseRegistration(Course course) {
        System.out.println(this.name + " объявил(а) запись на курс " + course.getCourseName()+".");
        course.openRegistration();
    }
    @Override
    public void removeCourse(Course course){
        this.courses.remove(course);
        System.out.println(this.getName() + " завершил(а) курс  " + course.getCourseName() + ".");
        course.closeRegistration();
    }

    @Override
    public void evaluateTheStudent(Archive archive,Course course, Student student, Mark mark){
        System.out.println(this.name + " выставил(а) оценку " + mark.getMark() + " студенту " + student.getName() + " за курс " + course.getCourseName() + ".");
        student.removeCourse(course);
        archive.saveMark(course, student, mark);
    }
}

interface StudentInterface{
     void enrollInCourse(Course course);
     String getGroup();
     ArrayList<Course> getCourses();
     void setGroup(String group);
     void removeCourse(Course course);
}
class Student extends Person implements StudentInterface{
    private String group;
    private ArrayList<Course> courses;

    public Student(String name, String group) {
        super(name);
        this.group = group;
        this.courses = new ArrayList<>();
    }
    @Override
    public void enrollInCourse(Course course) {
        if (course.isRegistrationOpen()) {
            course.addStudent(this);
            this.courses.add(course);
            System.out.println("Студент " + this.name +" группы " + this.group + " начал изучать курс " + course.getCourseName()+".");
        } else {
            System.out.println("Запись на курс " + course.getCourseName() + " закрыта.");
        }
    }

    @Override
    public String getGroup() {
        return this.group;
    }
    @Override
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    @Override
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void removeCourse(Course course){
        this.courses.remove(course);
        System.out.println("Студент группы "+this.getGroup() + " " + this.getName() + " завершил изучение курса " + course.getCourseName()+".");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.name + '\'' +
                ", group='" + this.group + '\'' +
                '}';
    }
}


interface CourseInterface {
    void openRegistration();
    void closeRegistration();
    boolean isRegistrationOpen();
    void addStudent(Student student);
    void setTeacher(Teacher teacher);
    String getTeacherName();
    List<Student> getStudents();
    String getCourseName();
}
class Course implements CourseInterface{
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;
    private boolean registrationOpen;
    public Course(String name){
        this.name = name;
        this.students = new ArrayList<>();
        this.registrationOpen = false;
    }
    @Override
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @Override
    public String getTeacherName() {
        return this.teacher.getName();
    }
    @Override
    public List<Student> getStudents() {
        return this.students;
    }
    @Override
    public String getCourseName() {
        return this.name;
    }
    @Override
    public void openRegistration() {
        this.registrationOpen = true;
    }
    @Override
    public void closeRegistration() {
        this.registrationOpen = false;
    }
    @Override
    public boolean isRegistrationOpen() {
        return this.registrationOpen;
    }
    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }

}

interface ArchiveInterface{
     void saveMark(Course course, Student student, Mark mark);
     void printArchive();
}
class Archive implements ArchiveInterface{
    private static Map<Course, Map<Student, Mark>> gradesArchive;

    public Archive() {
        gradesArchive = new HashMap<>();
    }

    @Override
    public void saveMark(Course course, Student student, Mark mark) {
        Map<Student, Mark> courseGrades = gradesArchive.computeIfAbsent(course, m -> new HashMap<>());
        courseGrades.put(student, mark);
    }

    @Override
    public void printArchive(){
        StringBuilder result = new StringBuilder();
        for (Course course : gradesArchive.keySet()) {
            result.append("Course: ").append(course.getCourseName()).append(", Teacher: ").append(course.getTeacherName()).append("\n");
            Map<Student, Mark> courseGrades = gradesArchive.get(course);
            for (Student student : courseGrades.keySet()) {
                Mark grade = courseGrades.get(student);
                result.append("\t\tStudent: ").append(student.getName()).append(", Group: ").append(student.getGroup());
                result.append(", Mark: ").append(grade.getMark()).append("\n");
            }
        }
        System.out.println("\n"+result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Course course : gradesArchive.keySet()) {
            result.append("Course: ").append(course.getCourseName()).append(", Teacher: ").append(course.getTeacherName()).append("\n");
            Map<Student, Mark> courseGrades = gradesArchive.get(course);
            for (Student student : courseGrades.keySet()) {
                Mark grade = courseGrades.get(student);
                result.append("\tStudent: ").append(student.getName()).append(", Group: ").append(student.getGroup())
                        .append(", Mark: ").append(grade.getMark()).append("\n");
            }
        }
        return result.toString();
    }
}

class Mark {
    private int mark;

    public Mark(int mark) {
        this.mark = mark;
    }
    public int getMark() {
        return this.mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + this.mark +
                '}';
    }
}