package com.skilldistillery.jets;

public class PassengerJet extends Jet implements FlightOps, PassengerOps {
	
	private boolean hasPassengers;

	public void loadPassengers() {
		if(this.hasPassengers == false) {
			this.hasPassengers = true;
		}
		else {
			System.out.println(this.getModel() + " passengers already onboard");
		}
	}

	public void unloadPassengers() {
		if(this.hasPassengers == true && this.isAirborne()==false) {
			this.hasPassengers = false;
		}
		else if(this.hasPassengers == true && this.isAirborne()==true) {
			System.out.println(this.getModel() + " is airborne, cannot unload passengers");
		}
		else {
			System.out.println(this.getModel() + " already does not contain passengers");
		}
		
	}

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public boolean hasPassengers() {
		return hasPassengers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasPassengers ? 1231 : 1237);
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
		PassengerJet other = (PassengerJet) obj;
		if (hasPassengers != other.hasPassengers)
			return false;
		return true;
	}
	
	

}
