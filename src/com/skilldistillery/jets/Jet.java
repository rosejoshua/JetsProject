package com.skilldistillery.jets;

public abstract class Jet implements FlightOps {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	private boolean hasFuel;
	private boolean isAirborne;
	
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public Jet() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean hasFuel() {
		return hasFuel;
	}
	
	public boolean isAirborne() {
		return isAirborne;
	}

	public void fuelUp() {
		if (this.hasFuel == false) {
			this.hasFuel = true;			
		}
		else {
			System.out.println("plane already fueled up");
		}
	}

	public void fly() {
		if(this.isAirborne == false) {
			this.isAirborne = true;
		}
		else {
			System.out.println("plane already airborne");
		}
	}
	
	public void land() {
		if(this.isAirborne == true) {
			this.isAirborne = false;
		}
		else {
			System.out.println("plane already on the ground");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasFuel ? 1231 : 1237);
		result = prime * result + (isAirborne ? 1231 : 1237);
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Jet other = (Jet) obj;
		if (hasFuel != other.hasFuel)
			return false;
		if (isAirborne != other.isAirborne)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass() + " model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + ", hasFuel="
				+ hasFuel + ", isAirborne=" + isAirborne;
	}
	
	

}