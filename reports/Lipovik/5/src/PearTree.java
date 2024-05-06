public class PearTree extends Tree{
    PearTree(int _age, boolean _fruiting){
        super(_age, _fruiting);
    }
    @Override
    public void printInfo(){
        System.out.println("Pear tree\nage: "+age+"\nfruiting: "+fruiting);
        if(age>6 || !fruiting){
            System.out.println("needs a transplant!");
        }
    }
}
