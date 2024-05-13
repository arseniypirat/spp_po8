import java.util.ArrayList;
import java.util.List;

// Класс Person (Человек)
class Person {
    private String name;
    private int age;
    private int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// Класс Student (Студент)
class Student extends Person {
    private List<Course> coursesEnrolled;

    public Student(String name, int age, int id) {
        super(name, age, id);
        this.coursesEnrolled = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        coursesEnrolled.add(course);
    }

    public void study() {
        System.out.println(getName() + " is studying.");
    }
}

// Класс Teacher (Преподаватель)
class Teacher extends Person {
    private List<Course> coursesTeaching;

    public Teacher(String name, int age, int id) {
        super(name, age, id);
        this.coursesTeaching = new ArrayList<>();
    }

    public void teach(Course course) {
        coursesTeaching.add(course);
    }
}

// Класс Course (Курс)
class Course {
    private String name;
    private Teacher teacher;
    private List<Student> studentsEnrolled;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.studentsEnrolled = new ArrayList<>();
    }

    // Добавляем геттер для имени курса
    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        studentsEnrolled.add(student);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

// Класс Grade (Оценка)
class Grade {
    private Student student;
    private Course course;
    private int gradeValue;

    public Grade(Student student, Course course, int gradeValue) {
        this.student = student;
        this.course = course;
        this.gradeValue = gradeValue;
    }

    // Геттеры и сеттеры
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}

// Класс Archive (Архив)
class Archive {
    private List<Grade> grades;

    public Archive() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades(Student student) {
        List<Grade> studentGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getStudent().equals(student)) {
                studentGrades.add(grade);
            }
        }
        return studentGrades;
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создание преподавателя
        Teacher teacher = new Teacher("John Doe", 35, 1);

        // Создание студентов
        Student student1 = new Student("Alice Smith", 20, 1);
        Student student2 = new Student("Bob Johnson", 22, 2);

        // Создание курса и назначение преподавателя
        Course javaCourse = new Course("Java Programming", teacher);
        javaCourse.addStudent(student1);
        javaCourse.addStudent(student2);

        // Преподаватель ведет курс
        teacher.teach(javaCourse);

        // Студенты учатся
        student1.study();
        student2.study();

        // Выставление оценок
        Grade grade1 = new Grade(student1, javaCourse, 90);
        Grade grade2 = new Grade(student2, javaCourse, 85);

        // Сохранение оценок в архив
        Archive archive = new Archive();
        archive.addGrade(grade1);
        archive.addGrade(grade2);

        // Получение оценок студента
        List<Grade> student1Grades = archive.getGrades(student1);
        System.out.println("Grades for " + student1.getName() + ":");
        for (Grade grade : student1Grades) {
            System.out.println("Course: " + grade.getCourse().getName() + ", Grade: " + grade.getGradeValue());
        }
    }
}
