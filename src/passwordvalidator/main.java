/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordvalidator;
import java.util.Scanner;
import static passwordvalidator.PasswordValidator.isValidPassword;
import passwordvalidator.PasswordSuggestion;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
       
        
        System.out.print("\n The recommended password must: "
                + "\n1-Be between 8 & 12 characters"
                + "\n2-Contains at least: "
                + "\n -one uppercase letter"
                + "\n -one lowercase letter"
                + "\n -one digit "
                + "\n -one symbol "
                + "\n3-Not be similar to email "
                + "\n \nEnter your password: ");
        String password = scanner.nextLine();

       boolean valid = isValidPassword(password, email);
        boolean weak = PasswordWeaknessChecker.weakPassword(password);

        // Provide feedback to the user and Suggesting a secure password  
        if (valid && !weak) {
            System.out.println("Strong password!");
        } else {
            System.out.println("Weak password\nPlease use a different one!");
       
            String suggested_password = PasswordSuggestion.StrongPassword(email);
            System.out.println("Here's a recommended strong password: " + suggested_password);
        } 
        
        scanner.close();
    }
}
