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
		
		//app.airfield.run();
		
		
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
				for (Jet jet : this.airfield.getJets()) {
					jet.fuelUp();
					jet.fly();
				}
				break;
				
			case 3:
				Jet j = this.airfield.getJets().get(0);
				for (Jet jet : this.airfield.getJets()) {
					if(jet.getSpeed()>j.getSpeed()) {
						j=jet;
					}
				}
				System.out.println("Fastest Jet: " + j.toString());
				break;
				
			case 4:
				Jet k = this.airfield.getJets().get(0);
				for (Jet jet : this.airfield.getJets()) {
					if(jet.getRange()>k.getRange()) {
						k=jet;
					}
				}
				System.out.println("Jet with longest range: " + k.toString());
				break;

			default:
				break;
			}
		}
	}
	
	public void printMenu() {
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
		System.out.println();
		System.out.print("Enter your choice (1-9): ");
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
