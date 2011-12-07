package com.kelkoo.yahtzee;

public class Turn {
	public DiceLauncher diceLauncher;
	public boolean turnFinished;
	public Dices launchedDices;
	public Dices currentDices;
	private int round;

	public Turn(DiceLauncher diceLauncher) {
		this.diceLauncher = diceLauncher;
		this.currentDices = new Dices();
	}

	public Integer[] launchDices() {
		return diceLauncher.launch().toArray();
	}

	public int getRound() {
		return round;
	}

	public int getScore() {
		return currentDices.score();
	}

	public void notifyUserChoiceOnTurn(int... dices) {
		++round;
		currentDices.add(dices);
		turnFinished = (getRound() == 3) ? true : false;
	}

	public boolean isFinished() {
		return turnFinished;
	}

	public Dices getSelectedDices() {
		return currentDices;
	}

}