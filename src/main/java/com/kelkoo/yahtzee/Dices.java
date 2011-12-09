package com.kelkoo.yahtzee;

import java.util.Arrays;

public class Dices {
	int[] diceValues;
	
	public Dices(int ... diceValues) {
		this.diceValues = diceValues;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(diceValues);
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
		Dices other = (Dices) obj;
		if (!Arrays.equals(diceValues, other.diceValues))
			return false;
		return true;
	}

}
