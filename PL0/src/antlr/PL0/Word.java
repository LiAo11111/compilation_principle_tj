package antlr.PL0;

public class Word {
    String name;
    String information;
    public Word(String name, String information) {
        this.name = name;
        this.information = information;
    }

    @Override
    public String toString() {
        return name + ", " + information;
    }
}
