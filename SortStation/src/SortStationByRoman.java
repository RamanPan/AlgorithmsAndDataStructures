import structures.StackByRoman;

public class SortStationByRoman {
    private static final String FUNCTIONS = "cossin";
    private static final String OPERATORS = "+-*/^()";
    private static int countOpenBracket = 0;

    private SortStationByRoman() {
    }

    private static final StackByRoman<String> stackOperations = new StackByRoman<>();

    private static Priority getPriority(String token) {
        return switch (token) {
            case "+", "-" -> Priority.LOW;
            case "*", "/" -> Priority.MEDIUM;
            case "^" -> Priority.HIGH;
            default -> Priority.NONE;
        };
    }

    public static String doSorting(String statement) {
        StringBuilder result = new StringBuilder();
        String[] tokens = statement.split(" ");
        for (String token : tokens) {
            if (token.matches("[0-9]+")) result.append(token).append(" ");
            else if (OPERATORS.contains(token)) {
                if (token.equals("(")) {
                    countOpenBracket++;
                    stackOperations.push(token);
                } else if (token.equals(")")) {
                    while (!stackOperations.getTopElement().equals("(")) {
                        result.append(stackOperations.pop()).append(" ");
                    }
                    stackOperations.pop();
                    if (stackOperations.getTopElement() != null && FUNCTIONS.contains(stackOperations.getTopElement()))
                        result.append(stackOperations.pop()).append(" ");
                    countOpenBracket--;
                } else if (!stackOperations.isEmpty() && getPriority(token).equals(getPriority(stackOperations.getTopElement()))) {
                    result.append(stackOperations.pop()).append(" ");
                    stackOperations.push(token);
                } else stackOperations.push(token);
            } else if (FUNCTIONS.contains(token)) stackOperations.push(token);

        }
        while (!stackOperations.isEmpty()) result.append(stackOperations.pop()).append(" ");
        return result.toString();
    }

}
