package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {
		
	private List<Jet> jets =  new ArrayList<>();	
	private Scanner input = new Scanner(System.in);
	String fileName = "jets.txt";

	public Airfield() {
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	
	public void jetsInput() {
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
	
	public boolean mainMenu(int choice) {
		switch (choice) {
		
		case 1:
			for (Jet jet : getJets()) {
				System.out.println(jet);
			}
			return true;
			
		case 2:
			for (Jet jet : getJets()) {;
			jet.fuelUp();
			}
			return true;
			
		case 3:
			for (Jet jet : getJets()) {;
				jet.fly();
			}
			return true;
			
		case 4:
			Jet j = getJets().get(0);
			for (Jet jet : getJets()) {
				if(jet.getSpeed()>j.getSpeed()) {
					j=jet;
				}
			}
			System.out.println("Fastest Jet: " + j.toString());
			return true;
			
		case 5:
			Jet k = getJets().get(0);
			for (Jet jet : getJets()) {
				if(jet.getRange()>k.getRange()) {
					k=jet;
				}
			}
			System.out.println("Jet with longest range: " + k.toString());
			return true;
			
		case 6:
			for (Jet jet : getJets()) {
				if (jet instanceof CargoJet){
					((CargoJet)jet).loadCargo();;
				}
			}
			return true;
			
		case 7:
			for (Jet jet : getJets()) {
				if (jet instanceof FighterJet){
					jet.fuelUp();
					jet.fly();
				}
			}
			for (Jet jet2 : getJets()) {
				if (jet2 instanceof FighterJet){
					System.out.println(jet2.getModel());
				}
			}
				System.out.println("are all dogfighting now!");
			return true;
			
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
				getJets().add(new FighterJet(a, b, c, d));
				break;
			case 2:
				getJets().add(new CargoJet(a, b, c, d));
				break;
			case 3:
				getJets().add(new PassengerJet(a, b, c, d));
				break;

			default:
				System.out.println("invalid entry, try again...");
				break;
			}
			
			System.out.println("You have added the following jet: " + 
					getJets().get(getJets().size()-1));
			
			return true;
		case 9:
			printRemoveMenu();
			return true;
		case 10:
			System.out.println("Closing app. Goodbye...");
			return false;
			
		default:
			return true;
		}
	}
	
	public int readInt() {
		int i = input.nextInt();
		return i;
	}
//	public double readDouble() {
//		double i = input.nextDouble();
//		return i;
//	}
//	public long readLong() {
//		long i = input.nextLong();
//		return i;
//	}
//	public String readString() {
//		String i = input.nextLine();
//		return i;
//	}
	
	public void printRemoveMenu() {
		for (int i=0; i<getJets().size(); i++) {
			System.out.println("At index " + i + ": " + getJets().get(i));
		}
		System.out.println("Enter the index of the jet you want to remove: ");
		int choice = input.nextInt();
		System.out.println("removing: " + getJets().get(choice));
		getJets().remove(choice);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jets == null) ? 0 : jets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airfield other = (Airfield) obj;
		if (jets == null) {
			if (other.jets != null)
				return false;
		} else if (!jets.equals(other.jets))
			return false;
		return true;
	}
	
	

}
