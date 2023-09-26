import java.util.List;
public class InputValidation {

    private static final double MIN_AMOUNT = 0;
    private static final double MAX_AMOUNT = 1000;
    private static final List<String> VALID_CATEGORIES = List.of("food", "travel", "bills", "entertainment","other");

    public boolean validateAmount(double amount) {
        return (amount >= MIN_AMOUNT) && (amount <= MAX_AMOUNT);
    }

    public boolean validateCategory(String category){
        return VALID_CATEGORIES.contains(category);
    }
}
