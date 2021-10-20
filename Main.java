package com.JavaClassAssignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.text.*;

import static java.lang.Integer.parseInt;

class BankAccount{

    private String name;
    public double balance;
    private int pin;

    public void deposit(double depositAmount){
        this.balance = this.balance + depositAmount;
    }

    public void withdraw(double withdrawAmount){
        this.balance = this.balance + withdrawAmount;
    }

    public void monthlyFees(){

        double amount;
        amount = this.balance/10;
        if(amount > 50){
            amount = 50;
        }
        this.balance = this.balance - amount;
    }

    //Getters and Setters will be used to identify the Account details
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getPin(){
        return pin;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public BankAccount(String name, double balance, int pin){
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

}

class RegularAccount extends BankAccount{

    public RegularAccount(String name, double balance, int pin){
        super(name, balance, pin);
    }

    public void penaltyBalance(){
        if(balance < 500)
        {
            balance = balance - 100;
        }
    }
}

class InterestAccount extends BankAccount{

    public InterestAccount(String name, double balance, int pin){
        super(name, balance, pin);
    }

    public void creditInterest(){
        balance = balance*1.07;
    }
}

class CheckingAccount extends BankAccount{

    public CheckingAccount(String name, double balance, int pin){
        super(name, balance, pin);
    }

    public void creditInterest(){
        balance = balance*1.07;
    }

    public void penaltyBalance(){
        if(balance < 1000)
        {
            balance = balance - 50;
        }
    }

    public void transactionDedect(Double amount){

        double fees;
        fees = amount/1000;
        balance = balance - (amount + fees);

    }
}

class CDAccount extends BankAccount{

    public CDAccount(String name, double balance, int pin){
        super(name, balance, pin);
    }

    public void creditInterest(){
        balance = balance*1.15;
    }

    public void withdrawalBeforeAYear(){

        balance = balance*0.8;

    }
}

public class Lab{

    public static void main(String[] args){

        int choice, month = 8, year=2020;
        Scanner sc = new Scanner(System.in);

        //We will Create Account by adding details ourselves. But in Real World Scenario, We will have a Database of the Bank from where we can call API
        RegularAccount person1 = new RegularAccount("Virat", 50000, 1818);
        InterestAccount person2 = new InterestAccount("Dhoni", 75000, 7777);
        CheckingAccount person3 = new CheckingAccount("Raina", 25000, 3333);
        CDAccount person4 = new CDAccount("Rohit", 10000, 4545);

        Date currentDate = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        if(parseInt(monthFormat.format(currentDate)) != month){

            month = month%12 + 1;
            person1.monthlyFees();
            person1.penaltyBalance();
            person2.monthlyFees();
            person2.creditInterest();
            person3.monthlyFees();
            person3.creditInterest();
            person3.penaltyBalance();
            person4.monthlyFees();

        }

        System.out.println("\tMENU");
        System.out.println("1. Regular Account");
        System.out.println("2. Interest Account");
        System.out.println("3. Checking Account");
        System.out.println("4. CD Account");
        choice = sc.nextInt();

        String name;
        int pin;
        switch(choice){

            case 1:
                System.out.println("Enter the Name: ");
                name = sc.nextLine();
                System.out.println("Enter the PIN: ");
                pin = sc.nextInt();
                int option;
                double amount;
                if(person1.getName() == name && person1.getPin() == pin){

                    System.out.println("Press 1 For Deposit and 2 for Withdrawal and then Amount");
                    option = sc.nextInt();
                    amount = sc.nextDouble();
                    if(option == 1){
                        person1.deposit(amount);
                    }else if(option == 2){
                        person1.withdraw(amount);
                    }else{
                        System.out.println("Wrong Choice");
                    }

                }
                else{
                    System.out.println("Person do not Exist!");
                }
                break;

            case 2:
                System.out.println("Enter the Name: ");
                name = sc.nextLine();
                System.out.println("Enter the PIN: ");
                pin = sc.nextInt();
                if(person2.getName() == name && person2.getPin() == pin){

                    System.out.println("Press 1 For Deposit and 2 for Withdrawal and then Amount");
                    option = sc.nextInt();
                    amount = sc.nextDouble();
                    if(option == 1){
                        person2.deposit(amount);
                    }else if(option == 2){
                        person2.withdraw(amount);
                    }else{
                        System.out.println("Wrong Choice");
                    }

                }
                else{
                    System.out.println("Person do not Exist!");
                }
                break;

            case 3:
                System.out.println("Enter the Name: ");
                name = sc.nextLine();
                System.out.println("Enter the PIN: ");
                pin = sc.nextInt();
                if(person3.getName() == name && person3.getPin() == pin){

                    System.out.println("Press 1 For Deposit and 2 for Withdrawal and then Amount");
                    option = sc.nextInt();
                    amount = sc.nextDouble();
                    if(option == 1){
                        person3.deposit(amount);
                    }else if(option == 2){
                        person3.transactionDedect(amount);
                    }else{
                        System.out.println("Wrong Choice");
                    }
                    person3.penaltyBalance();

                }
                else{
                    System.out.println("Person do not Exist!");
                }
                break;


            case 4:
                System.out.println("Enter the Name: ");
                name = sc.nextLine();
                System.out.println("Enter the PIN: ");
                pin = sc.nextInt();
                if(person4.getName() == name && person4.getPin() == pin){

                    System.out.println("Do you want to Withdraw?(0/1) ");
                    option = sc.nextInt();
                    if(option == 0){
                        System.out.println("Thanks for Visit");
                    }else{
                        //We Will get Date of Deposit from Database
                        // Let date be 2019-02-16
                        LocalDate date = LocalDate.of(2019,02,16)
                        LocalDate now = LocalDate.now();

                        Period diff = Period.between(date,now);
                        if(parseInt(diff.getYears()) < 1){

                            person4.withdrawalBeforeAYear();

                        }
                    }
                }
                else{
                    System.out.println("Person do not Exist!");
                }
                break;

            default:
                System.out.println("Wrong Choice!");
                break;

        }

    }

}