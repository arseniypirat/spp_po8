import java.util.ArrayList;
import java.util.Objects;

class CharacterSet {
    private ArrayList<Character> set;

    public CharacterSet() {
        set = new ArrayList<>();
    }

    public CharacterSet(Character... characters) {
        set = new ArrayList<>();
        for (Character c : characters) {
            add(c);
        }
    }

    public void add(Character c) {
        if (!set.contains(c)) {
            set.add(c);
        }
    }

    public void remove(Character c) {
        set.remove(c);
    }

    public boolean contains(Character c) {
        return set.contains(c);
    }

    public CharacterSet intersection(CharacterSet other) {
        CharacterSet result = new CharacterSet();
        for (Character c : set) {
            if (other.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i != set.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CharacterSet that = (CharacterSet) o;
        return Objects.equals(set, that.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}

class Main {
    public static void main(String[] args) {
        // Создание пустого множества
        CharacterSet set1 = new CharacterSet();
        System.out.println("Пустое множество: " + set1);

        // Создание множества с элементами
        CharacterSet set2 = new CharacterSet('a', 'b', 'c');
        System.out.println("Множество с элементами: " + set2);

        // Добавление элемента
        set2.add('d');
        System.out.println("После добавления 'd': " + set2);

        // Удаление элемента
        set2.remove('b');
        System.out.println("После удаления 'b': " + set2);

        // Проверка принадлежности элемента
        System.out.println("Содержит 'a'? " + set2.contains('a'));
        System.out.println("Содержит 'b'? " + set2.contains('b'));

        // Пересечение множеств
        CharacterSet set3 = new CharacterSet('c', 'd', 'e');
        CharacterSet intersection = set2.intersection(set3);
        System.out.println("Пересечение " + set2 + " и " + set3 + ": " + intersection);

        // Сравнение множеств
        CharacterSet set4 = new CharacterSet('a', 'c', 'd');
        System.out.println("set2 equals set4? " + set2.equals(set4));
    }
}
