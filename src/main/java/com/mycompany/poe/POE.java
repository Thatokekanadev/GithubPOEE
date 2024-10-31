/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.List;
/**
 *
 * @author hp
 */
public class POE {
    
  public static int totalHours = 0;
  
    public static void main(String[] args) {
        Login login_check = new Login();
       
//Declarations
        String username;
        String password;
        String name;
        String surname;
        
        String loginUsername;
        String loginPassword;
        boolean loggedIn = false;
         JOptionPane.showMessageDialog(null, "Hi, Please create an Account");
       //Prompt user name and surname
       
       name = JOptionPane.showInputDialog("Enter Name: ");
       surname = JOptionPane.showInputDialog("Enter SurName: ");
       
       //User registration
        username = JOptionPane.showInputDialog("Register Account\nEnter Username: ");
       
        password = JOptionPane.showInputDialog("Enter Password: ");
       
       //Register a user new user in the system
       String registration = login_check.registerUser(username, password, name, surname);
       JOptionPane.showMessageDialog(null, registration);
       
       if (registration.equals("User has been registered successfully")) {
            // If registration is successful, proceed to login
            loginUsername = JOptionPane.showInputDialog("Login to your account\nEnter username: ");
            loginPassword = JOptionPane.showInputDialog("Enter password: ");

            // Display login status message
            String loginStatus = login_check.returnLoginStatus(loginUsername, loginPassword, name, surname);
           JOptionPane.showMessageDialog(null, loginStatus);
        
          
          
        if (loginStatus.equals("A successful Login, Welcome " + name + "  " + surname)){
           loggedIn = true;
                }
       }
       
      if(loggedIn){
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            
            boolean running = true;
            while(running){
                String option = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                    "1) Add Tasks\n" +
                    "2) Show Report (Coming Soon)\n" +
                    "3) Quit");
                              
                switch (option){
                    case "1":
                        //Task Creation
                        addTasks();
                        break;
                    case "2":
                        // Show report - currently in development
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        // Quit Application
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
                    }
                }         
        }
    JOptionPane.showMessageDialog(null, "_END_");
    }
    private static void addTasks(){
      int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add? "));
            ArrayList<Task> taskList = new ArrayList<>();
            int totalHrs = 0;
            
    //Create task based on the user's input
    for (int i = 0; i < numTasks; i++){
       String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String description;
            do {
                description = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (description.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Task successfully captured");
                    break;
                }
            } while (description.length() > 50);
    String developerDetails = JOptionPane.showInputDialog("Enter Developer Name:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));

            // Task status menu
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status",
                    "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            
            //Create task object
            Task task = new Task(taskName,i +1, description, developerDetails,duration, taskStatus);
            taskList.add(task);
            totalHrs += duration;
            
            // Display task details
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
    
    //Display total amount of hours of each tasks
    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);    
    }
    
        
        
     
            }

       
        

