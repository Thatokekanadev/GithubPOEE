/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.regex.Pattern;
/**
 *
 * @author hp
 */
class Login {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
     public boolean checkUsername(String username){
         //temp variable for checking
         boolean Found = false;
         
         if(username.contains("_")&& username.length() <= 5){
            //then assign true
            Found = true;
             System.out.println("Username Captured");
              
         }
         else{
             System.out.println("Username is not captured");
             Found = false;
         }
         //check username
         return Found;
     }
     
     //message return method 
     public String RegisterUser(String firstname, String lastname, String username, String password){
         
         String UserResult = "";
         if( !checkUsername(username)){
             UserResult = "The username is incorrectly formatted!";
         }
     else if(!checkPasswordComplexity(password)){
             UserResult = "The password does not meet the password complexity requirements";
         }
     else {
             UserResult = "The user has been registered successfully";
                 this.firstname = firstname;
                 this.lastname = lastname;
                 this.username = username;
                 this.password = password;
                 }
         return UserResult;
             
         }
         //check the password method
          public boolean checkPasswordComplexity(String password){
             
              //pattern regex
              Pattern check_num = Pattern.compile("[0123456789]");
              Pattern check_special = Pattern.compile("[*~!@#&_'^]");
              Pattern check_Upper = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
              
              //temp variable found
              boolean Found = false;
              
              //check all here
              if( check_num.matcher(password).find()&& check_special.matcher(password).find()&& check_Upper.matcher(password).find()){
                 //assign true
                 Found = true;
                 //message
                 System.out.println("Password is captured!!");
              }
              else{
                  //assign to false
                  Found = false;
                  //message
                  System.out.println("Password is not captured!!");
              }
              return Found;
          }  
         public boolean loginUser(String username, String password){
                
             //initialized login_UserResult variable
                 boolean login_UserResult = false;
                
                 //check if username and password matches
                 if(username.matches(username)&& password.matches(password)){
                     System.out.println("Login details match!");
                       
                  //assign to true
                     login_UserResult = true;
                 
                 }else{
                     System.out.println("Login details do not match login details stored when registred!");
                     //assign to false
                     login_UserResult = false;
                 }
                 return login_UserResult;
                 
             }
              public String returnLoginStatus(String firstname, String lastname, String username, String password){
                  //initialized outcome variable
                  String outcome = "";
                  //check if login is successful
                  if(loginUser(username, password)){
                      outcome = "A successful Login, Welcome" +firstname+lastname;
                  }
                  else{
                      outcome = "A failed Login";
                  }
                  return outcome;
              }
         }
        
     

