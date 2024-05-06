import java.util.Arrays;

public class Set {

    private int size;
    private int[] elements;
    Set(int _size){
        size=_size;
        elements=new int[0];
    }
    Set(){
        size=5;
        elements=new int[0];
    }
    public void merge(Set set){
        int[] newElements = new int[elements.length+set.elements.length];
        size+=set.size;
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        System.arraycopy(set.elements, 0, newElements, elements.length, set.elements.length);
        elements=new int[newElements.length];
        elements=Arrays.stream(Arrays.stream(newElements).sorted().toArray()).distinct().toArray();
        size=elements.length;
    }
    @Override
    public String toString(){
        StringBuilder str= new StringBuilder();
        for(int element: elements){
            str.append(element).append("\n");
        }
        return str.toString();
    }
    public int contains(int value){
        for(int i=0;i<elements.length;i++){
            if(elements[i]==value){
                return i;
            }
        }
        return -1;
    }
    public void add(int value){
        if(elements.length==size){
            System.out.println("the set is completely filled!");
        }
        else{
            if(contains(value)==-1){
                int [] newElements = new int[elements.length+1];
                for(int i=0;i<elements.length;i++){
                    newElements[i]=elements[i];
                }
                newElements[elements.length]=value;
                elements=newElements;
            }
        }
    }
    public void erase(int value){
        int index=contains(value);
        if(index!=-1){
            int temp=elements[index];
            elements[index]=elements[elements.length-1];
            elements[elements.length-1]=temp;
            int [] newElements = new int[elements.length-1];
            for(int i=0;i<elements.length-1;i++){
                newElements[i]=elements[i];
            }
            elements=Arrays.stream(Arrays.stream(newElements).sorted().toArray()).distinct().toArray();
        }
        else{
            System.out.println("the set does not contain this element!");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            System.out.println("not same class!");
            return false;
        }

        Set set = (Set) obj;
        return size==set.size && Arrays.equals(elements, set.elements);
    }
}
