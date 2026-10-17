/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordvalidator;

import java.security.SecureRandom;
// We use "SecureRandom" for better security and less predictable randomness.

 public class  PasswordSuggestion  {
    // Defining all possible characters (upper/lowercase, digits, and special characters)
      private static final String upper_AND_lower_case = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
      private static final String Digits_Special_Characters = "0123456789!@#$%^&*";
      private static final String all_characters =upper_AND_lower_case +Digits_Special_Characters;
 
   public static String StrongPassword(String email) {

    // An empty email username would reject every generated password.
    if (email == null || email.isEmpty() || email.startsWith("@")) {
        throw new IllegalArgumentException(
                "Please enter an email with a username before @."
        );
    }

    SecureRandom rand = new SecureRandom();

    String newPassword;

    do {
        newPassword = "";

        // Assign a random length between 8 and 12 characters.
        int length = 8 + rand.nextInt(5);

        // Generate each character using the original method.
        for (int i = 0; i < length; i++) {
            newPassword += all_characters.charAt(
                    rand.nextInt(all_characters.length())
            );
        }

    } while (
            !PasswordValidator.containsRequiredCharacters(newPassword)
            || PasswordValidator.isSimilarToEmail(newPassword, email)
            || PasswordWeaknessChecker.weakPassword(newPassword, false)
    );

    return newPassword;
}
}
