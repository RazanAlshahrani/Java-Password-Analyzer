/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordvalidator;

import java.util.Arrays;
import java.util.List;
public class PasswordWeaknessChecker {
    //list of common  weak  passwords
    private static final List <String> WeakWord= Arrays.asList("password","1111","admin","kitchen");
    
public static boolean weakPassword(String pass) {
    return weakPassword(pass, true);
}

public static boolean weakPassword(String pass, boolean showMessages) {        for (String word : WeakWord) {
    if (pass.toLowerCase().contains(word)) {
        if (showMessages)
        System.out.println("The password contains a commonly used word");
        return true;
    }
}
         // Check for repeated characters EX."aaaa" ,"11111"
       if (pass.matches("(?s).*(.)\\1{3,}.*")) {
           if (showMessages)
            System.out.println("The password contains repeated characters");
        return true;
        }
        // Check for sequential characters like "1234" or "abcd"
         if (pass.toLowerCase().matches("(?s).*(01234|1234|abcd|bcde).*")) {
             if (showMessages)
            System.out.println("The password contains sequential characters");
        return true;
    }
         return false;
}}


