public class CherryTree extends Tree {
    CherryTree(int _age, boolean _fruiting){
        super(_age, _fruiting);
    }
    @Override
    public void printInfo(){
        System.out.println("Cherry tree\nage: "+age+"\nfruiting: "+fruiting);
        if(age>10 || !fruiting){
            System.out.println("needs a transplant!");
        }
    }
}
