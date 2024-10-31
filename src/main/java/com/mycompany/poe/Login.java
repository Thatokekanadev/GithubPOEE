/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import java.util.regex.Pattern;

/**
 *
 * @author hp
 */
public class Login {

    private String name;
    private String surname;
    private String username;
    private String password;

    // Compile patterns once for efficiency
    private static final Pattern CHECK_NUM = Pattern.compile("[0-9]");
    private static final Pattern CHECK_SPECIAL = Pattern.compile("[*~!@#&_'^]");
    private static final Pattern CHECK_UPPER = Pattern.compile("[A-Z]");

    public Login() {
    }

    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

   //Verify the complexity of the password based on a set of criteria (At least 8 charcters long, with captial letter, number and special character)
    public boolean checkPasswordComplexity(String password){
     //Define Regular expression pattern for validation
     Pattern check_num = Pattern.compile("[0123456789]");
     Pattern check_uppercase = Pattern.compile("[QWERTYUIOPLKJHGFDSAZXCVBNM]");
     Pattern check_specials = Pattern.compile("[!@#$%^&*+-_:.<,>~']");
     
     //Declare and assign a temporary variable to false.
     boolean Found = false;
     
     if(check_num.matcher(password).find() && (check_specials.matcher(password).find()) && (check_uppercase.matcher(password).find())){
         Found = true;
         System.out.println("Password successfully captured.");
         //Assign the temporary variable to true if the password is captured successfully.
         return true;
     }else{
        //Assign the temporary variable to false if the password is not captured successfully.
         Found = false;
         System.out.println("Password is not correctly formatted, please "
                 + "ensure that the password contains at least 8 characters, a "
                 + "capital letter, a number and a special character.");
         return Found;
     }
    }

    public String registerUser(String username, String password, String name, String surname) {
        if (!checkUsername(username)) {
            return "The username is incorrectly formatted!";
        } else if (!checkPasswordComplexity(password)) {
            return "The password does not meet the password complexity requirements";
        } else {
            this.name = name;
            this.surname = surname;
            this.username = username;
            this.password = password;
            return "User has been registered successfully";
        }
    }

    public boolean loginUser(String username, String password) {
        return this.username != null && this.password != null 
                && this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(String loginUsername, String loginPassword, String name, String surname ) {
        if (loginUser(username, password)) {
            return "A successful Login, Welcome " + name + " " + surname;
        } else {
            return "Login failed. Incorrect username or password.";
        }
    }
}