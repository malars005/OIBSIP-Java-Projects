package com.malar.project;

import java.util.Scanner;
import java.util.ArrayList;

public class ATMInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userId = "malar";
		int pin = 1234;

		double balance = 10000;

		ArrayList<String> transactionHistory = new ArrayList<>();

		int attempts = 0;
		System.out.println("===== ATM LOGIN =====");

		while (attempts < 3) {

		    System.out.print("Enter User ID: ");
		    String enteredUserId = sc.next();

		    System.out.print("Enter PIN: ");
		    int enteredPin = sc.nextInt();

		    if (enteredUserId.equals(userId) && enteredPin == pin) {
		        System.out.println("\nLogin Successful!");
		        break;
		    } else {
		        attempts++;
		        System.out.println("Invalid User ID or PIN");

		        if (attempts == 3) {
		            System.out.println("Account Locked! Too many failed attempts.");
		            sc.close();
		            return;
		        }
		    }
		}
		while (true) {

		    System.out.println("\n===== ATM MENU =====");
		    System.out.println("1. Transaction History");
		    System.out.println("2. Withdraw");
		    System.out.println("3. Deposit");
		    System.out.println("4. Transfer");
		    System.out.println("5. Exit");

		    System.out.print("Enter your choice: ");
		    int choice = sc.nextInt();

		    switch (choice) {

		    case 1:

		        System.out.println("\n===== Transaction History =====");

		        if (transactionHistory.isEmpty()) {

		            System.out.println("No Transactions Found!");

		        } else {

		            for (String transaction : transactionHistory) {
		                System.out.println(transaction);
		            }

		        }

		        break;
		    case 2:
		        System.out.print("Enter Withdraw Amount: ");
		        double withdraw = sc.nextDouble();

		        if (withdraw <= balance) {

		            balance = balance - withdraw;

		            transactionHistory.add("Withdraw ₹" + withdraw);

		            System.out.println("Amount Withdrawn Successfully!");

		            System.out.println("Current Balance: ₹" + balance);

		        } else {

		            System.out.println("Insufficient Balance!");

		        }

		        break;

		    case 3:

		        System.out.print("Enter Deposit Amount: ");
		        double deposit = sc.nextDouble();

		        balance = balance + deposit;

		        transactionHistory.add("Deposited ₹" + deposit);

		        System.out.println("Amount Deposited Successfully!");

		        System.out.println("Current Balance: ₹" + balance);

		        break;

		    case 4:

		        System.out.print("Enter Receiver Account Number: ");
		        String receiver = sc.next();

		        System.out.print("Enter Transfer Amount: ");
		        double transfer = sc.nextDouble();

		        if (transfer <= balance) {

		            balance = balance - transfer;

		            transactionHistory.add("Transferred ₹" + transfer + " to " + receiver);

		            System.out.println("Transfer Successful!");

		            System.out.println("Current Balance: ₹" + balance);

		        } else {

		            System.out.println("Insufficient Balance!");

		        }

		        break;
		       
		    case 5:
		        System.out.println("Thank you for using ATM!");
		        sc.close();
		        return;

		    default:
		        System.out.println("Invalid Choice!");
		    }

		}
	}

}
