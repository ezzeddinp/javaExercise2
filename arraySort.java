package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Sesi8 {
	static ArrayList<String> custName = new ArrayList<>();

	public Sesi8() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> coffD = new ArrayList<>();
		ArrayList<String> cupS = new ArrayList<>();
		ArrayList<String> orderID = new ArrayList<>();
		ArrayList<Integer> coffP = new ArrayList<>();
		ArrayList<Integer> cupQ = new ArrayList<>();
		ArrayList<Integer> cupP = new ArrayList<>();
		ArrayList<Integer> totalP = new ArrayList<>();
		
		int input;
		do {
			System.out.println("\nJanji efte coffe");
			System.out.println("================");
			System.out.println("1. Order Coffe");
			System.out.println("2. View Order History");
			System.out.println("3. Remove Data");
			System.out.println("4. Sort by Name");
			System.out.println("5. Exit");
			System.out.print(">>");
			input = sc.nextInt(); sc.nextLine();
	
			switch(input) {
			case 1:
				String name;
				do {
					System.out.println("Input customer name: ");
					name = sc.nextLine();
				} while(!(alpNum(name)));
				
				
				String drink;
				do {
					System.out.println("Order coffe [Caffe Latte|Caramel Macchiato|Espresso]: ");
					drink = sc.nextLine();
					
				} while(!(drink.equals("Caffe Latte") || drink.equals("Caramel Macchiato") || drink.equals("Espresso")));
				
				int coffPrice = 0;
				if(drink.equals("Caffe Latte")) {
					coffPrice = 30000;
					coffP.add(coffPrice);
				}
				else if(drink.equals("Caramel Macchiato")) {
					coffPrice = 35000;
					coffP.add(coffPrice);
				}
				else if(drink.equals("Espresso")) {
					coffPrice = 40000;
					coffP.add(coffPrice);
				}
				
				String cupSize;
				do {
					System.out.println("Cup size [Small|Medium|Big]: ");
					cupSize = sc.nextLine();
					
				}while(!(cupSize.equals("Small") || cupSize.equals("Medium") || cupSize.equals("Big")));
				
				int cupPrice = 0;
				if(cupSize.equals("Small")) {
					cupPrice = 3000;
					
				}
				else if(cupSize.equals("Medium")) {
					cupPrice = 5000;
					
				}
				
				int quantity;
				do {
					System.out.println("Input quantity: ");
					quantity = sc.nextInt(); sc.nextLine();
					if(!(quantity > 0)) {
						System.out.println("Quantity must at least above 0");
					}
					
				}while(!(quantity>=0));
				
				
				double tempTotalPrice = (quantity * coffPrice) + cupPrice;
				double tax = tempTotalPrice * 0.10;
				double totalPrice = tempTotalPrice + tax;
				totalP.add((int) totalPrice);
				double tpp = (int) totalPrice;
				
				
				int ranID = new Random().nextInt(10);
				String oID;
				oID = String.format("OI%03d", ranID);
				orderID.add(oID);
				
				System.out.print("Order Information\n=================\nOrder ID: "+oID+"\nCustomer Name: "+name+"\nCoffee Name: "+drink+"\nCup Size: "+cupSize+"\nQuantity: "+quantity+"\nTotal Price: "+tpp+"\n");
				int money;
				do{
					System.out.print("Input Money [ >= Total Price ]: ");
					money = sc.nextInt();sc.nextLine();
				}while(money < totalPrice);
				int changeM = (int) (money - totalPrice);
				System.out.println("Change : "+changeM+"");
				
				System.out.println("Thank You :)");
				System.out.print("Presss Enter To Continue...");sc.nextLine();
				
				custName.add(name);
				coffD.add(drink);
				cupS.add(cupSize);
				cupP.add(cupPrice);
				cupQ.add(quantity);
				break;
			
				
			case 2: 
				if(custName.size() > 0) {
					for(int i = 0; i < custName.size(); i++) {
						System.out.println("\n" + custName.get(i) + " was found..");
						System.out.println("-----------------------------------------------------------------------------");
						System.out.printf("| %-4s | %-30s | %-15s | %-15s | %-15s | %-15s |\n", "Order ID.", "Customer Name", "Coffe Name", "Cup Size", "Quantity", "Total Price");
						System.out.println("-----------------------------------------------------------------------------");
						System.out.printf("| %-4d | %-30s | %-15s | %-15s | %-15s | %-15s |\n", i + 1, orderID.get(i), custName.get(i), coffD.get(i), cupS.get(i), cupQ.get(i), totalP.get(i));
						System.out.println("-----------------------------------------------------------------------------");
					}
				} else {
					System.out.println("There is no order history!");
				}
				break;
				
			case 3:
				if(custName.size() > 0) {
					System.out.println("Enter custName to delete orders: ");
					String remCust = sc.nextLine();
					
					for(int i = 0; i < custName.size(); i++) {
						if(remCust.equals(custName.get(i))){
							custName.remove(remCust);
							printOrderList(orderID, custName, coffD, cupS, cupQ, totalP);
						} else {
							System.out.println("Invalid Customer Name to be deleted!");
						}
					}

				} else{
					System.out.println("No Order history!");
				}
				break;
			case 4: 
				if(custName.isEmpty()) {
					System.out.println("There is no data to be sorted!");
				} else {
					Collections.sort(custName);
					
					for(int i = 0; i < custName.size(); i++) {
						System.out.println("-----------------------------------------------------------------------------");
						System.out.printf("| %-4s | %-30s | %-15s | %-15s | %-15s | %-15s |\n", "Order ID.", "Customer Name", "Coffe Name", "Cup Size", "Quantity", "Total Price");
						System.out.println("-----------------------------------------------------------------------------");
						System.out.printf("| %-4d | %-30s | %-15s | %-15s | %-15s | %-15s |\n", i + 1, orderID.get(i), custName.get(i), coffD.get(i), cupS.get(i), cupQ.get(i), totalP.get(i));
						System.out.println("-----------------------------------------------------------------------------");
					}
				}
				break;
			}
		} while(input != 5);

	}
	
	public static void main(String[] args) {
		new Sesi8();
	}
	
	public static boolean alpNum(String input) {
		boolean containsLetter = false;
		boolean containsDigit = false;
		boolean containsUnique = true;
		
		for(char a : input.toCharArray()) {
			if(Character.isLetter(a)) {
				containsLetter = true;
			}
			else if(Character.isDigit(a)) {
				containsDigit = true;
			}
			if(containsLetter && containsDigit) {
				return true;
			}
		}
		
		
		for(String names : custName) {
			if(names.matches(input)) return false;
		}
		return containsLetter && containsDigit && containsUnique;
	}
	
    public static void printOrderList(
            ArrayList<String> orderID,
            ArrayList<String> custName,
            ArrayList<String> coffD,
            ArrayList<String> cupS,
            ArrayList<Integer> cupQ,
            ArrayList<Integer> totalP) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-30s | %-15s | %-15s | %-15s | %-15s |\n", "Order ID.", "Customer Name", "Coffe Name", "Cup Size", "Quantity", "Total Price");
        System.out.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < custName.size(); i++) {
            System.out.printf("| %-4d | %-30s | %-15s | %-15s | %-15s | %-15s |\n", i + 1, orderID.get(i), custName.get(i), coffD.get(i), cupS.get(i), cupQ.get(i), totalP.get(i));
            System.out.println("-----------------------------------------------------------------------------");
        }
    }

}
