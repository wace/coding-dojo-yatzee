package com.kelkoo.yahtzee;

import java.util.HashMap;
import java.util.Map;

public class DicesForCategory {

	private final Map<Integer, Dices> dices = new HashMap<Integer, Dices>();

	public Dices get(int category) {
		return this.dices.get(category);
	}

	public void set(Dices dices, int i) {
		this.dices.put(i, dices);
	}

}
