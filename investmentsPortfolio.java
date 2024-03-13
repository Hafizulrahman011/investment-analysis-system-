import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class investmentsPortfolio {
    
    private User user;
    private String goals;
    private String riskPreference;
    private List<Investments> investments;

    public investmentsPortfolio(User user) {
        this.user = user;
        this.investments = new ArrayList<>();
    }

    public void setGoals(String goals) {this.goals = goals;}

    public void setRiskPreference(String riskPreference) {this.riskPreference = riskPreference;}

    public void addInvestment(Investments investment) {this.investments.add(investment);}

    public void generateReport() {
        System.out.println("Investment Portfolio Report for " + user.getUsername());
        System.out.println("Goals: " + goals);
        System.out.println("Risk Preference: " + riskPreference);

        if (investments.isEmpty()) {
            System.out.println("No investments in the portfolio.");
        } else {
            System.out.println("\nInvestments:");

            printTableHeader();
            for (Investments investment : investments) {
                printTableRow(investment);
            }
            printTableFooter();
        }
    }

    private void printTableHeader() {
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        System.out.printf("| %-19s | %-19s | %-19s | %-19s | %-19s | %-19s |%n",
                "Type", "Option", "Initial Investment", "Balance", "Profit", "Risk Level");
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
    }

    private void printTableRow(Investments investment) {
        System.out.printf("| %-19s | %-19s | %-19.2f | %-19.2f | %-19.2f | %-19s |%n",
                investment.getType(), investment.getOption(),
                investment.getInitialInvestment(), investment.getBalance(),
                investment.getProfit(), investment.getRisk());
    }

    private void printTableFooter() {
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
    }
    
    public static void portfolioOptions(investmentsPortfolio portfolio) {
    while (true) {
        String[] options = {"Set Goals", "Set Risk Preference", "Back to Main Menu"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Portfolio Options:\n1-Set Goals\n2-Set Risk Preference\n3-Back to Main Menu",
                "Portfolio Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                String goals = JOptionPane.showInputDialog("Enter your investment goals:");
                portfolio.setGoals(goals);
                break;
            case 1:
                String riskPreference = JOptionPane.showInputDialog("Enter your risk preference:");
                portfolio.setRiskPreference(riskPreference);
                break;
            case 2:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
        }
    }
    }
    
    public static void addInvestment() {
    String[] investmentTypes = {"Commodities", "Index Funds", "Crypto"};
    int investmentTypeChoice = JOptionPane.showOptionDialog(
            null,
            "Select Investment Type:",
            "Investment Type",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            investmentTypes,
            investmentTypes[0]
    );

    String investmentType;
    switch (investmentTypeChoice) {
        case 0:
            investmentType = "Commodities";
            break;
        case 1:
            investmentType = "Index Funds";
            break;
        case 2:
            investmentType = "Crypto";
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid choice. Exiting investment addition.");
            return;
    }

    String[] investmentOptions;
    switch (investmentTypeChoice) {
        case 0:
            investmentOptions = new String[]{"Gold", "Silver", "Crude Oil"};
            break;
        case 1:
            investmentOptions = new String[]{"S&P500", "FTSE Malaysia", "FTSE China 50"};
            break;
        case 2:
            investmentOptions = new String[]{"Bitcoin", "Binance", "Ethereum"};
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid choice. Exiting investment addition.");
            return;
    }

    int investmentOptionChoice = JOptionPane.showOptionDialog(
            null,
            "Select Investment Option:",
            "Investment Option",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            investmentOptions,
            investmentOptions[0]
    );

    String investmentOption;
    if (investmentOptionChoice >= 0 && investmentOptionChoice < investmentOptions.length) {
        investmentOption = investmentOptions[investmentOptionChoice];
    } else {
        JOptionPane.showMessageDialog(null, "Invalid choice. Exiting investment addition.");
        return;
    }

    double initialInvestment = Double.parseDouble(JOptionPane.showInputDialog("Enter the initial investment amount:"));
    String riskPreference = JOptionPane.showInputDialog("Enter your risk preference (High/Moderate/Low):");

    Investments newInvestment = new Investments(investmentType, investmentOption, riskPreference, initialInvestment);
    
    JOptionPane.showMessageDialog(null, "Investment added successfully!");
  }

}
