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
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      if(validator.validateAmount(amount) && validator.validateCategory(category)){
        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      }else if(!validator.validateAmount(amount)){
        showErrorPopUp("Invalid Amount value. Please enter a value between 0 and 1000");
      }else{
        showErrorPopUp("Invalid Category value. Please enter a value from the following:  \"food\", \"travel\", \"bills\", \"entertainment\" and \"other\"");
      }
    });
    }
  private static void showErrorPopUp(String message) {
    JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
  }
}