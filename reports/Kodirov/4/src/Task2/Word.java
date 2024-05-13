package Task2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

public class Word {
    private ArrayList<Symbol> symbols;

    public Word(Symbol[] symbols) {
        this.symbols = new ArrayList<>();
        for (Symbol symbol : symbols) {
            if (symbol.getSymbol() != ' ') {
                this.symbols.add(symbol);
            }
        }
    }

    public Symbol[] getSymbols() {
        return (Symbol[]) symbols.toArray(Symbol[]::new);
    }

    public void setSymbols(Symbol[] symbols) {
        this.symbols.clear();
        for (Symbol symbol : symbols) {
            if (symbol.getSymbol() == ' ') {
                continue;
            }
            if (this.symbols != null) {
                this.symbols.add(symbol);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(symbols, word.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbols);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Symbol symbol : symbols) {
            builder.append(symbol.toChar());
        }
        return builder.toString();
    }

    public Symbol symbolAt(int index) throws Exception {
        if (index < 0 || index > symbols.size()) {
            throw new Exception("Неверный индекс!");
        }
        return symbols.get(index);
    }
}
