import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    //Creating an input validation object for validation of fields
    InputValidation validator = new InputValidation();
    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      try {
        // Get transaction data from view
        double amount = view.getAmountField();
        String category = view.getCategoryField();

        // Create transaction object
        Transaction t = new Transaction(amount, category);

        validator.validateAmount(amount);
        validator.validateCategory(category);

        // Call controller to add transaction
        view.addTransaction(t);
      } catch (InvalidAmountException ex) {
        showErrorPopUp(ex.getMessage());
        throw new RuntimeException(ex);
      } catch (InvalidCategoryException ex) {
        showErrorPopUp(ex.getMessage());
        throw new RuntimeException(ex);
      }
    });
  }
  /**
   * Displays an error popup dialog with the eroor message.
   *
   * @param message The error message to be displayed in the popup.
   */
  private static void showErrorPopUp(String message) {
    JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
  }
}