/**
 * The InvalidAmountException class is a custom class for handling invalid amounts in the Expense Tracker App.
 */
public class InvalidAmountException extends Exception{
    /**
     * Constructs a new InvalidAmountException with the specified error message.
     * @param message A descriptive message explaining the reason for the exception.
     */
    public InvalidAmountException(String message){
        super(message);
    }
}
