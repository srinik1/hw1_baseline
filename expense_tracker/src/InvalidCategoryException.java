/**
 * The InvalidCategoruException class is a custom class for handling invalid categories in the Expense Tracker App.
 */
public class InvalidCategoryException extends Exception{
    /**
     * Constructs a new InvalidCategoryException with the specified error message.
     * @param message A descriptive message explaining the reason for the exception.
     */
    public InvalidCategoryException(String message){
        super(message);
    }
}
