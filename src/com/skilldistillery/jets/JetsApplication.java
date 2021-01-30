package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	
	private Airfield airfield;
	private Scanner input;
	
	public static void main(String[] args) {
		List<Jet> jets =  new ArrayList<>();
		
		JetsApplication app = new JetsApplication();
		
		String fileName = "jets.txt";
	
		app.jetsInput(jets, fileName);	

		app.airfield = new Airfield(jets);
		
		app.input = new Scanner(System.in);
		
		app.run();
		
		
	}
	
	public void run() {
		boolean run = true;
		int choice;
		while(run) {
			printMenu();
			choice = input.nextInt();
			switch (choice) {
			
			case 1:
				for (Jet jet : this.airfield.getJets()) {
					System.out.println(jet);
				}
				break;
				
			case 2:
				for (Jet jet : this.airfield.getJets()) {;
				jet.fuelUp();
				}
				break;
				
			case 3:
				for (Jet jet : this.airfield.getJets()) {;
					jet.fly();
				}
				break;
				
			case 4:
				Jet j = this.airfield.getJets().get(0);
				for (Jet jet : this.airfield.getJets()) {
					if(jet.getSpeed()>j.getSpeed()) {
						j=jet;
					}
				}
				System.out.println("Fastest Jet: " + j.toString());
				break;
				
			case 5:
				Jet k = this.airfield.getJets().get(0);
				for (Jet jet : this.airfield.getJets()) {
					if(jet.getRange()>k.getRange()) {
						k=jet;
					}
				}
				System.out.println("Jet with longest range: " + k.toString());
				break;
				
			case 6:
				CargoJet cJ;
				for (Jet jet : this.airfield.getJets()) {
					if (jet.getClass()==CargoJet.class){
						cJ = (CargoJet)jet;
						cJ.loadCargo();;
					}
				}
				break;
				
			case 7:
				List<FighterJet> listFighters = new ArrayList<>();
				for (Jet jet : this.airfield.getJets()) {
					if (jet.getClass()==FighterJet.class){
						listFighters.add((FighterJet)jet);
						jet.fuelUp();
						jet.fly();
					}
				}
				for (FighterJet fJ : listFighters) {
					System.out.println(fJ);
				}
				System.out.println("are all dogfighting now!");
				break;
				
			case 8:
				String a;
				double b;
				int c;
				long d;
				int e;
				
				System.out.println("To add a new jet to the fleet, you will need to input some info.");
				System.out.print("Enter the name of the jet's model as a String: ");
				input.nextLine();
				a = input.nextLine();
				System.out.print("Enter the jet's max speed in MPH as a double: ");
				b = input.nextDouble();
				input.nextLine();
				System.out.print("Enter the jet's max range in miles as an integer: ");
				c = input.nextInt();
				input.nextLine();
				System.out.print("Enter the jet's price as a long: ");
				d = input.nextLong();
				input.nextLine();
				System.out.println("What kind of jet is it? ");
				System.out.println("1. Fighter Jet");
				System.out.println("2. Cargo Jet");
				System.out.println("3. Passenger Jet");
				System.out.print("Enter your choice (1-3): ");
				
				e = input.nextInt();
				
				switch (e) {
				case 1:
					airfield.getJets().add(new FighterJet(a, b, c, d));
					break;
				case 2:
					airfield.getJets().add(new CargoJet(a, b, c, d));
					break;
				case 3:
					airfield.getJets().add(new PassengerJet(a, b, c, d));
					break;

				default:
					System.out.println("invalid entry, try again...");
					break;
				}
				
				System.out.println("You have added the following jet: " + 
						airfield.getJets().get(airfield.getJets().size()-1));
				
				break;
			case 9:
				printRemoveMenu();
				break;
			case 10:
				System.out.println("Closing app. Goodbye...");
				run=false;
				break;
				
			default:
				break;
			}
		}
	}
	
	public void printMenu() {
		System.out.println("1. List fleet");
		System.out.println("2. Fuel all jets");
		System.out.println("3. Fly all jets");
		System.out.println("4. View fastest jet");
		System.out.println("5. View jet with longest range");
		System.out.println("6. Load all Cargo Jets");
		System.out.println("7. Dogfight!");
		System.out.println("8. Add a jet to Fleet");
		System.out.println("9. Remove a jet from Fleet");
		System.out.println("10. Quit");
		System.out.println();
		System.out.print("Enter your choice (1-10): ");
	}
	
	public void printRemoveMenu() {
		for (int i=0; i<airfield.getJets().size(); i++) {
			System.out.println("At index " + i + ": " + airfield.getJets().get(i));
		}
		System.out.println("Enter the index of the jet you want to remove: ");
		int choice = input.nextInt();
		System.out.println("removing: " + airfield.getJets().get(choice));
		airfield.getJets().remove(choice);
	}
	
	public void jetsInput(List<Jet> jets, String fileName) {
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
			  String line;
			  String[] temp ;
			  
			  
				while ((line = bufIn.readLine()) != null) {
					
					temp = line.split(", ");
					switch (temp[0]) {
					case "passenger" :
						jets.add(new PassengerJet(temp[1], Double.parseDouble(temp[2]), 
								Integer.parseInt(temp[3]), Long.parseLong(temp[4])));
						break;
						
					case "cargo" :
						jets.add(new CargoJet(temp[1], Double.parseDouble(temp[2]), 
								Integer.parseInt(temp[3]), Long.parseLong(temp[4])));
						break;
						
					case "fighter" :
						jets.add(new FighterJet(temp[1], Double.parseDouble(temp[2]), 
								Integer.parseInt(temp[3]), Long.parseLong(temp[4])));
						break;

					default:
						throw new IOException();
					}
				}
			}
			catch (IOException e) {
			  System.err.println(e);
			}
	}


}
