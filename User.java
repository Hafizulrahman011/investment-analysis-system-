import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class User {
    private String Username;
    private String Password;
    private static String UserType;
    private static String goals;
    private static String riskPreference;
    private investmentPortfolio portfolio;

    public User() {
        Username = null;
        Password = null;
        UserType = null;
        goals = null;
        riskPreference = null;
    }

    public User(String Username, String Password, String UserType) {
        this.Username = Username;
        this.Password = Password;
        this.UserType = UserType;
        goals = null;
        riskPreference = null;
    }

    public void setUsername(String Username) {this.Username = Username;}

    public void setPassword(String Password) {this.Password = Password;}

    public void setUserType(String UserType) {this.UserType = UserType;}

    public void setGoals(String goals) {this.goals = goals;}

    public void setRiskPreference(String riskPreference) {this.riskPreference = riskPreference;}
    
    public String getUsername() {return Username;}

    public String getPassword() {return Password;}

    public String getUserType() {return UserType;}

    public String getGoals() {return goals;}

    public String getRiskPreference() {return riskPreference;}
    
    //methods
    public static void registerUser(Scanner input) {
    JOptionPane.showMessageDialog(null, "Register a new user:");

    String username = JOptionPane.showInputDialog("Enter your username:");
    String password = JOptionPane.showInputDialog("Enter your password:");

      try {
        FileWriter printData = new FileWriter("UserData.txt", true);
        printData.write("Name: " + username + "\t" + "Password: " + password + "\n");
        printData.close();

        JOptionPane.showMessageDialog(null, "Registration successful!");
      } 
      catch (IOException e) 
      {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error occurred during registration.");
      }
    }
    
    public static User loginUser(Scanner input) {
    JOptionPane.showMessageDialog(null, "Enter your login credentials:");

    String username = JOptionPane.showInputDialog("Enter your username:");
    String password = JOptionPane.showInputDialog("Enter your password:");

    try {
        BufferedReader br = new BufferedReader(new FileReader("UserData.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");

            // Checking
            if (parts.length >= 2 &&
                    parts[0].trim().startsWith("Name:") && parts[0].trim().substring(6).equals(username) &&
                    parts[1].trim().startsWith("Password:") && parts[1].trim().substring(10).equals(password)) {
                return new User(username, password, "regular");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
    }
}

