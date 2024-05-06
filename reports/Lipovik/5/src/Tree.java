abstract class Tree {
    static int counter=1;
    protected int number;
    protected int age;
    protected boolean fruiting;
    Tree(int _age, boolean _fruiting){
        number=counter++;
        age=_age;
        fruiting=_fruiting;
    }
    public int getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }

    public boolean isFruiting() {
        return fruiting;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFruiting(boolean fruiting) {
        this.fruiting = fruiting;
    }
    public abstract void printInfo();
}
