/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
/**
 *
 * @author hp
 */
public class POEpart1 {

    public static void main(String[] args) {
        
        Login login_check = new Login();
        
        Scanner sc = new Scanner(System.in);
        
        String firstname = "";
        String lastname = "";
        String username = "";
        String password = "";
        
        System.out.println("Enter your name: ");
        firstname = sc.nextLine();
        System.out.println("Enter your lastname: ");
        lastname = sc.nextLine();
        
        do{
            System.out.println("Enter username: ");
            username = sc.nextLine();
         }while( !login_check.checkUsername(username));
        
        
       do{
           System.out.println("Enter password: ");
           password = sc.nextLine();
        }while( !login_check.checkPasswordComplexity(password));
        
        
    }
}
