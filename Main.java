package main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fullName = "";
		String email = "";
		String type = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Masukkan nama: ");
		fullName = sc.nextLine();
		
		boolean syarat1 = fullName.charAt(0) >= 'A' && fullName.charAt(0) <= 'Z';
		// syarat1 huruf pertama harus kapital 
		boolean syarat2 = fullName.split(" ").length >= 2;
		// syarat2 harus terdiri dari 2 kata atau lebih
		
		if (syarat1 && syarat2) {
			System.out.println("Nama sudah benar");
		} else {
			System.out.println("Nama masih salah!");
		}
		
		System.out.println("Masukkan email: ");
		email = sc.nextLine();
		
		boolean syarat3 = email.contains("@");
		boolean syarat4 = email.endsWith(".com") || email.endsWith(".co.id");
		boolean syarat5 = !email.startsWith("@") && !email.endsWith("@");
		
		if (syarat3 && syarat4 && syarat5) {
			System.out.println("Email sudah benar");
		} else {
			System.out.println("Email masih salah");
		}
		
		System.out.println("Masukkan tipe [Small | Medium | Big]: ");
		type = sc.nextLine().toLowerCase();
		
		boolean syarat6 = type.equals("Small") || type.equals("Medium") || type.equals("Big") || type.equals("small") || type.equals("medium") || type.equals("big");
		
		if (syarat6) {
			System.out.println("Tipe sudah benar");
		} else {
			System.out.println("Tipe masih salah!");
		}
		
		double typeModifier = 0;
		
		switch(type) {
		case "Small": {
			typeModifier = 1.2;
			break;
		}
		case "Medium": {
			typeModifier = 1.5;
			break;
		}
		case "Big": {
			typeModifier = 2.0;
			break;
		}
		}
		
		double price = 5000 * typeModifier * 1.1;
		
		String uniqueId = "";
		uniqueId += fullName.substring(0, 2).toUpperCase(); // 2 huruf pertama dari fullname
		uniqueId += type.substring(type.length() - 2).toUpperCase(); // huruf terakhir dari type
		
		Random random = new Random();
		int randomNumber = random.nextInt();
		uniqueId += randomNumber; // random numbernya 
		
		int sisa = randomNumber % 3;
		
		uniqueId += sisa == 0 ? "ID" : sisa == 1 ? "MY" : "TH"; // tambahkan akhirannya berdasarkan sisa bagi.
		
		System.out.println(fullName);
		System.out.println(email);
		System.out.println(type);
		System.out.println(price);
		System.out.println(uniqueId);
		
		

	}

}
