import java.util.Arrays;
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
     * Validates the amount present in the amount field
     * @param amount value present in amount field
     * @throws InvalidAmountException If the provided amount is not within the accepted range (0 to 1000).
     */
    public void validateAmount(double amount) throws InvalidAmountException{
        logger.info("Checking if the amount is withing the accepted values ");
        if(amount < MIN_AMOUNT || amount > MAX_AMOUNT){
            throw new InvalidAmountException("Invalid amount value. Please enter an amount value in between 0 and 1000");
        }
    }
    /**
     * Validates the string present in the category field
     * @param category value present in category field
     * @throws InvalidCategoryException If the provided category is not within the accepted list of categories
     */
    public void validateCategory(String category) throws InvalidCategoryException{
        logger.info("Checking if the categories are within the valid input strings ");
        String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        boolean isValid = Arrays.asList(validCategories).contains(category);
        if(!isValid){
            throw new InvalidCategoryException("Invalid Category value, Please enter a category from the following: \"food\", \"travel\", \"bills\", \"entertainment\", and \"other\"");
        }
    }
}
