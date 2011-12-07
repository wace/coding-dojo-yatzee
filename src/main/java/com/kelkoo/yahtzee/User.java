package com.kelkoo.yahtzee;

public class User {

	private Integer[] launchedDices;
	private Yatzee yatzee;

	public void selectDices(int...dices) {
		yatzee.notifyUserChoice(dices);
	}

	public void wantRethrow() {
		yatzee.notifyUserWantRethrow();
	}

	public void notifyDicesLaunch(Integer...dices) {
		this.launchedDices = dices;
	}

	public void playTo(Yatzee yatzee) {
		this.yatzee = yatzee;
	}

	public void selectCategory(int category) {
	    this.yatzee.notifyUserSelectedCategory(category);
	}

}
