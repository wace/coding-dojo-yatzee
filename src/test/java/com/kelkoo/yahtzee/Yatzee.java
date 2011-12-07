package com.kelkoo.yahtzee;

public class Yatzee {
	
	private Dices currentDices;
	private DiceLauncher diceLauncher;
	private final User user;

	public Yatzee(DiceLauncher diceLauncher, User user) {
		this.diceLauncher = diceLauncher;
		this.user = user;
		
	}

	public void start() {
		currentDices = diceLauncher.launch();
		
		
	}

	public Boolean finished() {
		return true;
	}

	public Integer score() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dices getCurrentDices() {
		return currentDices;
	}

}
