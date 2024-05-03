package com.phonebook_Manipulation;

import java.util.List;
import java.util.Scanner;

public class Main {
	// TODO Auto-generated method stub
    private static Scanner sc = new Scanner(System.in);
    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        while(true) {
            displayMenu();
            int chooose = sc.nextInt();
            switch (chooose) {
                case 1 -> addContact();
                case 2 -> displayAllContacts();
                case 3 -> searchContactByPhone();
                case 4 -> removeContact();
                case 5 -> {
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("Menu");
        System.out.println("1. Add Contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Search contact by phone");
        System.out.println("4. Remove contact");
        System.out.println("5. Exit");
        System.out.print("Enter your choice ");
    }

    private static void addContact(){
        sc.nextLine();
//        System.out.println("Add a Contact=>");
        System.out.print("Enter the First Name: ");
        String firstName= sc.nextLine();
        System.out.print("Enter the Last Name: ");
        String lastName =sc.nextLine();
        System.out.print("Enter the Phone No.: ");
        long phoneNumber=sc.nextLong();
        sc.nextLine();
        System.out.print("Enter the Email: ");
        String email=sc.nextLine();
        Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
        phoneBook.addContact(newContact);
        System.out.println("Contact added successfully!");
    }

    private static void displayAllContacts(){
        List<Contact> allContacts = phoneBook.viewAllContacts();
            System.out.println("The contacts in the List are=>");
            for (Contact contacts:allContacts) {
                displayContact(contacts);
                if(allContacts==null) {
                	System.out.println("nothing to display");
                }
            }
            
        }

    private static void searchContactByPhone() {
        System.out.print("Enter the Phone number to search contact=> ");
        long searchPhoneNumber=sc.nextLong();
        List<Contact> phoneBookContacts= phoneBook.getPhoneBook();
        Contact searchedContact=null;
        for (int i = 0; i < phoneBookContacts.size(); i++) {
            Contact contact = phoneBookContacts.get(i);
            if (contact.getPhoneNumber() == searchPhoneNumber) {
                searchedContact = contact;
                break;
            }
        }if(searchedContact !=null) {
            displayContact(searchedContact);
        } else {
            System.out.println("Contact unffound.");
        }
    }

    private static void removeContact(){
        System.out.print("Enter the Phone number to remove=> ");
        long removePhoneNumber=sc.nextLong();
        sc.nextLine();
        System.out.print("Do you want to remove the contact (Yes/no): ");
        char confirm = sc.nextLine().charAt(0);
        if (confirm == 'Y' || confirm == 'y') {
            boolean deleted= phoneBook.removeContact(removePhoneNumber);
            if (deleted) {
                System.out.println("contact removed");
            } else {
                System.out.println("contact unfound");
            }
        }
    }
    private static void displayContact(Contact contact) {
        System.out.println(contact.getFirstName());
        System.out.println(contact.getLastName());
        System.out.println(contact.getPhoneNumber());
        System.out.println(contact.getEmailId());
        System.out.println();
    }
    
    
}