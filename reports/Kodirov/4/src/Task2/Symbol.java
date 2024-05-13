package Task2;

public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Symbol symbol1 = (Symbol) object;
        return symbol == symbol1.symbol;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), symbol);
    }

    public char toChar() {
        return symbol;
    }
}
