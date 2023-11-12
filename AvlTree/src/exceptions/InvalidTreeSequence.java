package exceptions;

public class InvalidTreeSequence extends Exception {
    public InvalidTreeSequence() {
        super("Введена неправильная последовательность для создания дерева");
    }
}
