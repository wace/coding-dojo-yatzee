package com.kelkoo.yahtzee;

public class Yatzee {

	private User user;
	private Turn turn;
	private DicesForCategory dicesForCategory;

	public Yatzee(DiceLauncher diceLauncher, User user) {
		this.turn = new Turn(diceLauncher);
		this.user = user;
		registerUserToGame();
		this.dicesForCategory = new DicesForCategory();
	}

	public void start() {
		launchDices();
	}

	private void registerUserToGame() {
		this.user.playTo(this);
	}

	private void launchDices() {
		user.notifyDicesLaunch(turn.launchDices());
	}

	int getRound() {
		return turn.getRound();
	}

	public int score() {
		return turn.getScore();
	}

	public void notifyUserChoice(int... dices) {
		turn.notifyUserChoiceOnTurn(dices);
		if (turn.isFinished()) {
			dicesForCategory.set(turn.getSelectedDices(), (turn.getSelectedDices().toArray().length>0)?turn.getSelectedDices().toArray()[0]:1);
		}
	}

	public void notifyUserWantRethrow() {
		launchDices();
	}

	public boolean finished() {
		return false;
	}

	public Boolean turnFinished() {
		return this.turn.turnFinished;
	}

	public Integer scoreforCategory(int category) {
		return dicesForCategory.get(category).score();
	}

	public void notifyUserSelectedCategory(int category) {
		// TODO Auto-generated method stub
		
	}

}
