import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Investments {
    private String Type;
    private String Option;
    private String Risk;
    private double initialInvestment;
    private double Balance;
    private double Profit;
    private double currentPrice;
    private List<Investments> investments;

    public Investments(String Type, String Option, String Risk, double initialInvestment) {
        this.Type = Type;
        this.Option = Option;
        this.Risk = Risk;
        this.initialInvestment = initialInvestment;
        this.Balance = initialInvestment;
        this.currentPrice = 0.0;
        this.investments = new ArrayList<>();
        this.calculateProfit();
    }
    public void setType(String Type){this.Type = Type;}

    public void setOption(String Option) {this.Option = Option;}
    
    public void setRisk(String Risk){this.Risk = Risk;}
    
    public void setInitital(double initialInvestment){this.initialInvestment = initialInvestment;}
    
    public void setBalance (double Profit){this.Profit = Profit;}
    
    public void setPrice (double currentPrice) {this.currentPrice = currentPrice;}
    
    public void setInvestment(String Type, String Option , String Risk , double initialInvestment , double Profit , double currentPrice){
        this.Type = Type ;
        this.Option = Option;
        this.Risk =  Risk ;
        this.initialInvestment =  initialInvestment ;
        this.Profit =  Profit ;
        this.currentPrice = currentPrice;
    }

    public String getOption() {return Option;}

    public String getType() {return Type;}
    
    public String getRisk() {return Risk;}

    public double getInitialInvestment() {return initialInvestment;}

    public double getBalance() {return Balance;}

    public double getProfit() {return Profit;}

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        System.out.println("Price for " + Type + " (" + Option + ") updated to: $" + currentPrice);
    }

    public void calculateProfit() {
        double profitPercentage = 0.0;

        switch (Risk.toLowerCase()) {
            case "high":
                profitPercentage = 0.1;
                break;
            case "moderate":
                profitPercentage = 0.05;
                break;
            case "low":
                profitPercentage = 0.02;
                break;
            default:
                System.out.println("Invalid risk level");
                return;
        }

        Profit =Balance * profitPercentage;
    }

    public void addInvestment(Investments investment) {
        this.investments.add(investment);
    }
}
