public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void startStudying(Course course) {
        System.out.println("Студент " + name + " начал изучать курс " + course.getName());
    }

    public void stopStudying(Course course) {
        System.out.println("Студент " + name + " закончил изучать курс " + course.getName());
    }
}
