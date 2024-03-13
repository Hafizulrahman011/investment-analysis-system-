import java.util.Scanner;
import javax.swing.JOptionPane;

public class Wallet {
    Scanner input = new Scanner(System.in);

    private double Funds;
    
    public Wallet(){Funds = 0.0;}

    public Wallet(double Funds) {this.Funds = 0.0;}

    public void setWallet(double Funds) {this.Funds = Funds;}

    public double getWallet() {return Funds;}

    public double Deposit(double amount) {
        Funds += amount;
        System.out.println("Deposited $" + amount + " into the wallet. Current balance: $" + this.Funds);
        return Funds;
    }
    
    public static void walletOptions(Scanner input, Wallet wallet) {
    while (true) {
        String[] options = {"View Balance", "Deposit Funds", "Back to Main Menu"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Wallet Options:\n1-View Balance\n2-Deposit Funds\n3-Back to Main Menu",
                "Wallet Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "Current Balance: $" + wallet.getWallet());
                break;
            case 1:
                String depositAmountStr = JOptionPane.showInputDialog("Enter the amount to deposit: $");
                try {
                    double depositAmount = Double.parseDouble(depositAmountStr);
                    wallet.Deposit(depositAmount);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");
                }
                break;
            case 2:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
        }
    }
   }
}
