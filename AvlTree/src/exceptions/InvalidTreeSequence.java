package exceptions;

public class InvalidTreeSequence extends Exception {
    public InvalidTreeSequence() {
        super("Provided invalid binary tree sequence");
    }
}
