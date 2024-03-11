package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;

    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

    private String companySuffix = "xyzcompany.com";


    //constructor to receive first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;


        //call a method asking for the department - return the department
        this.department = setDepartment();


        //call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+this.password);

        //combine elements to generate email
        email = firstName.toLowerCase()+ "."+lastName.toLowerCase()+"@"+ department.toLowerCase()+"."+ companySuffix;

    }


    //ask for department
    private String setDepartment(){
        System.out.print("New Worker:"+firstName + ". DEPARTMENT CODES \n1 for Sales\n2 for Development\n3 for Accounting\n4 for IT\n0 for none\n Enter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "Sales";
        } else if (depChoice == 2) {
            return "Dev";
        } else if (depChoice == 3) {
            return "Acc";
        }else if (depChoice == 4)
        {
            return "IT";
        }else {
            return "none";
        }
    }

    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++)
        {
           int rand = (int)(Math.random()*passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    //get method to display mailbox capacity
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    //get method to display alternate email
    public String getAlternateEmail(){
        return alternateEmail;
    }

    //get method to display alternate password
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        if (department.equals("none")) {
            return "DISPLAY NAME: " + firstName + " " + lastName +
                    "\nCOMPANY EMAIL: " + email +
                    "\nNo department assigned" +
                    "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
        } else {
            return "DISPLAY NAME: " + firstName + " " + lastName +
                    "\nCOMPANY EMAIL: " + email +
                    "\nDEPARTMENT: " + department +
                    "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
        }
    }
}