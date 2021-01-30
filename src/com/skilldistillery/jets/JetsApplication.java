package com.skilldistillery.jets;

public class JetsApplication {
	
	private Airfield airfield = new Airfield();
	
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		JetsApplication app = new JetsApplication();		
	
		app.airfield.jetsInput();	

		while(run) {
			app.printMenu();
			run = app.airfield.mainMenu(app.airfield.readInt());		
			
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
	
	



}
