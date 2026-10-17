/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordvalidator;
import java.util.Scanner;

public class PasswordValidator {
 

    // Check if password length is between 8 and 12 characters
    public static boolean isValidLength(String password) {
        return password.length() >= 8 && password.length() <= 12;
    }

    
    // Check if password contains at leastone uppercase letter, one lowercase letter, one digit, and one symbol
    public static boolean containsRequiredCharacters(String password) {
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSymbol = true;
        }

        return hasUpper && hasLower && hasDigit && hasSymbol;
    }

    
    // Check if password is similar to email 
    public static boolean isSimilarToEmail(String password, String email) {
        String emailName = email.split("@")[0].toLowerCase(); // Extract the part before '@'
        return password.toLowerCase().contains(emailName);
    }

    
    // Password Validation
    public static boolean isValidPassword(String password, String email) {
        if (!isValidLength(password)) {
            System.out.println("Password must be between 8 & 12 characters");
            return false;
        }
        if (!containsRequiredCharacters(password)) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one symbol");
            return false;
        }
        if (isSimilarToEmail(password, email)) {
            System.out.println("Password should not be similar to the email address");
            return false;
        }
        return true;
    }

}
