package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.List;

public class Dices {

	private final List<Integer> dices;

	public Dices(int...dices) {
		this.dices = new ArrayList<Integer>();
		for (int i : dices) {
			this.dices.add(i);
		}
	}

	public Integer[] toArray() {
		return dices.toArray(new Integer[dices.size()]);
	}

	public void add(int...dices) {
		for (int i : dices) {
			this.dices.add(i);
		}
	}
	
	public int score() {
		int score = 0;
		for (Integer dice : dices) {
			score += dice;
		}
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dices == null) ? 0 : dices.hashCode());
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
		if (dices == null) {
			if (other.dices != null)
				return false;
		} else if (!dices.equals(other.dices))
			return false;
		return true;
	}
		
}
