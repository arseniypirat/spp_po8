import java.util.Vector;

public class task2 {
    public static void main(String[] args) {
        Vector<Tree> trees= new Vector<>();
        trees.add(new AppleTree(5, true));
        trees.add(new CherryTree(8, false));
        trees.add(new PearTree(8, true));
        for(Tree tree: trees){
            tree.printInfo();
        }
    }
}
