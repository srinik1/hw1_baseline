import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Transaction class defines the transaction object and its properties
 */
public class Transaction {
  /**
   * The amount of the transaction
   */
  private double amount;
  /**
   * The category of the transaction
   */
  private String category;
  /**
   * The timestamp of the transaction
   */
  private String timestamp;
  /**
   * Creates a new Transaction object with the given amount and category.
   *
   * @param amount The amount of the transaction.
   * @param category The category of the transaction.
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }
  /**
   * Gets the amount of the transaction
   *
   * @return amount of the transaction
   */
  public double getAmount() {
    return amount;
  }
  /**
   * Sets the amount of the transaction.
   *
   * @param amount The new amount of the transaction.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }
  /**
   * Gets the category of the transaction.
   *
   * @return category The category of the transaction.
   */
  public String getCategory() {
    return category;
  }
  /**
   * Sets the category of the transaction.
   *
   * @param category The new category of the transaction.
   */
  public void setCategory(String category) {
    this.category = category; 
  }
  /**
   * Gets the timestamp of the transaction.
   *
   * @return timestamp The timestamp of the transaction.
   */
  public String getTimestamp() {
    return timestamp;
  }
  /**
   * Generates and returns the timestamp of the transaction in 'dd-MM-yyyy' format.
   *
   * @return the generated timestamp
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }
}