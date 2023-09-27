import java.util.List;
import java.util.logging.Logger;
/**
 * The InterValidation class validates the user inputted data
 */
public class InputValidation {
    private static final Logger logger = Logger.getLogger(InputValidation.class.getName());
    /**
     * The minimum valid amount for the input amount.
     */
    private static final double MIN_AMOUNT = 0;
    /**
     * The maximum valid amount for the input amount.
     */
    private static final double MAX_AMOUNT = 1000;
    /**
     * The list of valid categories for the input category
     */
    private static final List<String> VALID_CATEGORIES = List.of("food", "travel", "bills", "entertainment","other");
    /**
     * Validates the amount present in the amount field
     * @param amount value present in amount field
     * @return true if input is valid and false if invalid
     */
    public boolean validateAmount(double amount) {
        logger.info("Checking if the amount is withing the accepted values ");
        return (amount >= MIN_AMOUNT) && (amount <= MAX_AMOUNT);
    }
    /**
     * Validates the string present in the category field
     * @param category value present in category field
     * @return true if input is valid and false if invalid
     */
    public boolean validateCategory(String category){
        logger.info("Checking if the categories are within the valid input strings ");
        return VALID_CATEGORIES.contains(category);
    }
}
