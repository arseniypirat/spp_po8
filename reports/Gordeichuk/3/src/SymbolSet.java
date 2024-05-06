import java.util.Arrays;

public class SymbolSet {
    private char[] elements;
    private int size;

    // Конструктор для создания пустого множества заданной мощности
    public SymbolSet(int capacity) {
        elements = new char[capacity];
        size = 0;
    }

    // Конструктор для создания множества с начальной инициализацией
    public SymbolSet(char[] initialElements) {
        elements = new char[initialElements.length];
        size = 0;
        for (char element : initialElements) {
            add(element);
        }
    }

    // Метод для добавления элемента в множество
    public void add(char element) {
        if (!contains(element)) {
            elements[size++] = element;
        }
    }

    // Метод для удаления элемента из множества
    public void remove(char element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                break;
            }
        }
    }

    // Метод для проверки, содержится ли элемент в множестве
    public boolean contains(char element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Метод для объединения двух множеств
    public SymbolSet union(SymbolSet otherSet) {
        SymbolSet result = new SymbolSet(this.size + otherSet.size);
        for (int i = 0; i < this.size; i++) {
            result.add(this.elements[i]);
        }
        for (int i = 0; i < otherSet.size; i++) {
            result.add(otherSet.elements[i]);
        }
        return result;
    }

    // Метод toString() для вывода множества на печать
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

    // Метод equals для сравнения множеств
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SymbolSet other = (SymbolSet) obj;
        return Arrays.equals(elements, other.elements) && size == other.size;
    }
}
