package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatOps {

	public void dogFight() {
		// TODO Auto-generated method stub
	}

	public void eject() {
		// TODO Auto-generated method stub
	}
	

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	
	
}
