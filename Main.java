import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Main {
    
    //file handling
    
    File f = new File("Userdata.txt");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User Interface
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to the Investment Management System!",
                    "IMS",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    User.registerUser(input);
                    break;
                case 1:
                    User autUser = User.loginUser(input);
                    if (autUser != null) {
                        JOptionPane.showMessageDialog(null, "Authentication successful!");
                        manageInvestmentPortfolio(input, autUser);
                    } else {
                        JOptionPane.showMessageDialog(null, "Authentication failed.");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
   }
    
    private static void manageInvestmentPortfolio(Scanner input, User user) {
    investmentsPortfolio portfolio = new investmentsPortfolio(user);
    Wallet wallet = new Wallet();

    while (true) {
        String[] options = {"Wallet", "Portfolio", "Investment", "Generate Portfolio", "Exit"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "1-Wallet\n2-Portfolio\n3-Investment\n4-Generate Portfolio\n5-Exit",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                Wallet.walletOptions(input, wallet);
                break;
            case 1:
                investmentsPortfolio.portfolioOptions(input, portfolio);
                break;
            case 2:
                investmentsPortfolio.addInvestment(input, portfolio);
                break;
            case 3:
                portfolio.generateReport();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Exiting...");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
        }
    }
   }

}
