import java.util.List;
import java.util.logging.Logger;
public class InputValidation {

    private static final Logger logger = Logger.getLogger(InputValidation.class.getName());

    private static final double MIN_AMOUNT = 0;
    private static final double MAX_AMOUNT = 1000;
    private static final List<String> VALID_CATEGORIES = List.of("food", "travel", "bills", "entertainment","other");

    public boolean validateAmount(double amount) {
        logger.info("Checking if the amount is withing the accepted values ");
        return (amount >= MIN_AMOUNT) && (amount <= MAX_AMOUNT);
    }

    public boolean validateCategory(String category){
        logger.info("Checking if the categories are within the valid input strings ");
        return VALID_CATEGORIES.contains(category);
    }
}
