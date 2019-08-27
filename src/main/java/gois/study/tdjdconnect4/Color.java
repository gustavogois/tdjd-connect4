package gois.study.tdjdconnect4;

public enum Color {
    RED('R'), GREEN('G'), EMPTY(' ');

    private final char value;

    Color(char value) { this.value = value; }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
