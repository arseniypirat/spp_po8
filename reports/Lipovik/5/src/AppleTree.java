public class AppleTree extends Tree{
    AppleTree(int _age, boolean _fruiting){
        super(_age, _fruiting);
    }
    @Override
    public void printInfo(){
        System.out.println("Apple tree\nage: "+age+"\nfruiting: "+fruiting);
        if(age>8 || !fruiting){
            System.out.println("needs a transplant!");
        }
    }
}
