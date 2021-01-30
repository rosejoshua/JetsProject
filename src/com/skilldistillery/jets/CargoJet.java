package com.skilldistillery.jets;

public class CargoJet extends Jet implements FlightOps, CargoOps {
	
	private boolean cargoLoaded;


	public void loadCargo() {
		if(this.cargoLoaded == false) {
			this.cargoLoaded = true;
		}
		else {
			System.out.println("cargo already loaded");
		}
	}

	public void unloadCargo() {
		if(this.cargoLoaded == true) {
			this.cargoLoaded = false;
		}
		else {
			System.out.println("plane already empty");
		}		
	}

	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public boolean isCargoLoaded() {
		return cargoLoaded;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (cargoLoaded ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoJet other = (CargoJet) obj;
		if (cargoLoaded != other.cargoLoaded)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " cargoLoaded=" + cargoLoaded;
	}

	
	
	
}
