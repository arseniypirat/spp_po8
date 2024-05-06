package Lab4;

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
        teacher.evaluateTheStudent(course1,student1,new Mark(5));
        teacher.evaluateTheStudent(course1,student2,new Mark(5));
        teacher.evaluateTheStudent(course1,student3,new Mark(4));
        teacher.removeCourse(course1);

        System.out.println();

        teacher.addCourse(course2);
        teacher.announceCourseRegistration(course2);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course2);
        student3.enrollInCourse(course2);
        teacher.evaluateTheStudent(course2,student1,new Mark(2));
        teacher.evaluateTheStudent(course2,student2,new Mark(2));
        teacher.evaluateTheStudent(course2,student3,new Mark(4));
        teacher.removeCourse(course2);

        archive.printArchive();
    }
}

class Teacher{
    private String name;
    ArrayList<Course> courses;

    public Teacher(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        course.setTeacher(this);
        this.courses.add(course);
    }

    public void announceCourseRegistration(Course course) {
        System.out.println(this.name + " объявил(а) запись на курс " + course.getName()+".");
        course.openRegistration();
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
        System.out.println(this.getName() + " завершил(а) курс  " + course.getName() + ".");
        course.closeRegistration();
    }

    public void evaluateTheStudent(Course course, Student student, Mark mark){
        System.out.println(this.name + " выставил(а) оценку " + mark.getMark() + " студенту " + student.getName() + " за курс " + course.getName() + ".");
        student.removeCourse(course);
        Archive.saveMark(course, student, mark);
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
}

class Student{
    private String name;
    private String group;
    private ArrayList<Course> courses;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (course.isRegistrationOpen()) {
            course.addStudent(this);
            this.courses.add(course);
            System.out.println("Студент " + this.name +" группы " + this.group + " начал изучать курс " + course.getName()+".");
        } else {
            System.out.println("Запись на курс " + course.getName() + " закрыта.");
        }
    }
    public String getName() {
        return this.name;
    }
    public String getGroup() {
        return this.group;
    }
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
        System.out.println("Студент группы "+this.getGroup() + " " + this.getName() + " завершил изучение курса " + course.getName()+".");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.name + '\'' +
                ", group='" + this.group + '\'' +
                '}';
    }
}

class Course{
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;
    private boolean registrationOpen;
    public Course(String name){
        this.name = name;
        this.students = new ArrayList<>();
        this.registrationOpen = false;
    }
    public void openRegistration() {
        this.registrationOpen = true;
    }

    public void closeRegistration() {
        this.registrationOpen = false;
    }

    public boolean isRegistrationOpen() {
        return this.registrationOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherName() {
        return this.teacher.getName();
    }

    public List<Student> getStudents() {
        return this.students;
    }
    public String getName() {
        return this.name;
    }

}
class Archive {
    private static Map<Course, Map<Student, Mark>> gradesArchive;

    public Archive() {
        gradesArchive = new HashMap<>();
    }
    public static void saveMark(Course course, Student student, Mark mark) {
        Map<Student, Mark> courseGrades = gradesArchive.computeIfAbsent(course, m -> new HashMap<>());
        courseGrades.put(student, mark);
    }

    public void printArchive(){
        StringBuilder result = new StringBuilder();
        for (Course course : gradesArchive.keySet()) {
            result.append("Course: ").append(course.getName()).append(", Teacher: ").append(course.getTeacherName()).append("\n");
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
            result.append("Course: ").append(course.getName()).append(", Teacher: ").append(course.getTeacherName()).append("\n");
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