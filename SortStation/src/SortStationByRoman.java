import structures.ArrayListByRoman;

import java.lang.reflect.Array;

public class SortStationByRoman {
    private final String FUNCTIONS = "cos,sin";
    private final String OPERATORS = "+-*/^()";
    private final String SEPARATOR = ",";

    public Priority getPriority(String token) {
        return switch (token) {
            case "+", "-" -> Priority.LOW;
            case "*", "/" -> Priority.MEDIUM;
            case "^" -> Priority.HIGH;
            default -> Priority.NONE;
        };
    }

    public String doSorting(String statement) {
        StringBuilder result = new StringBuilder();
        String[] tokens = statement.split(" ");
        for (int i = 0; i < tokens.length; ++i) {
//            if (tokens[i].)
        }
        return result.toString();
    }

}
