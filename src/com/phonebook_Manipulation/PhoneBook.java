package com.phonebook_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private List<Contact> phoneBook = new ArrayList<>();   //List<Integer> list=new ArrayList<Integer>();

	List<Contact> getPhoneBook() {
		return phoneBook;
	}

	private void setPhoneBook(List<Contact> phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public void addContact(Contact contactObj) {
		phoneBook.add(contactObj);
	}
	
	public List<Contact> viewAllContacts(){
		return phoneBook;
		
	}
	
	 Contact viewContactGivenPhone(long phoneNumber) {
		 for (int i=0;i<phoneBook.size();i++) {//.size() is used to iterate in list same as .length to array
	        Contact contact = phoneBook.get(i);//.get is used to get index  and .set is used to replace obj.set(index, item_replacble);                                     
		        if (contact.getPhoneNumber()== phoneNumber) {
		            return contact;
		        }
		    }
		    return null;
		}
	 
	 
		 public boolean removeContact(long phoneNumber) {
		        for (Contact contact : phoneBook) { 
		            if(contact.getPhoneNumber() == phoneNumber){
		                phoneBook.remove(contact);
		                return true;
		            }
		        }return false;
		    }
	 }
