import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The ExpenseTrackerView class used to set up the UI for the Expense Tracker App
 */
public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();
  /**
   * Gets the transactions table.
   *
   * @return The JTable displaying transaction data.
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }
  /**
   * Gets the value inputted in the amount field
   *
   * @return The double value representing the amount data.
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }
  /**
   * Sets the Amount field
   *
   * @param amountField The JTextField to set as the amount field.
   */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }
  /**
   * Gets the Category field
   *
   * @return the category string
   */
  public String getCategoryField() {
    return categoryField.getText();
  }
  /**
   * Sets the Category field
   *
   * @param categoryField The JTextField to set as the category field.
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }
  /**
   * Gets the "Add Transaction" button.
   *
   * @return The JButton for adding transactions.
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
  /**
   * Gets the default table model used for displaying transaction data.
   *
   * @return The DefaultTableModel.
   */
  public DefaultTableModel getTableModel() {
    return model;
  }
  /**
   * Creates an instance of the ExpenseTrackerView class with the specified table model.
   *
   * @param model The DefaultTableModel to use for the transactions table.
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }
  /**
   * Refreshes the transactions table with the updated data.
   *
   * @param transactions The list of Transaction objects to be displayed.
   */
  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }
  /**
   * Refreshes the view with the latest transaction data.
   */
  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }
  /**
   * Retrieves the list of Transaction objects.
   *
   * @return The list of Transaction objects.
   */
  public List<Transaction> getTransactions() {
    return transactions;
  }
  /**
   * Adds a new transaction to the list and the view is updated
   *
   * @param t The Transaction object to be added.
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  // Other view methods
}
