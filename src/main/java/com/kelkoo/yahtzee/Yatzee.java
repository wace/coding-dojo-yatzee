package com.kelkoo.yahtzee;

public class Yatzee {
	
	private DiceLauncher diceLauncher;
	private final User user;

	public Yatzee(DiceLauncher diceLauncher, User user) {
		this.diceLauncher = diceLauncher;
		this.user = user;
		this.user.setYatzee(this);
	}

	public void start() {		
		user.notifyDicesLaunched(diceLauncher.launch());		
	}

	public Boolean finished() {
		return true;
	}

	public Integer score() {
		// TODO Auto-generated method stub
		return null;
	}

   public void notifySelectDices(int... diceNumber) {
      throw new RuntimeException("Not Implemented Yet");
   }

}
