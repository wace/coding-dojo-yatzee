package com.kelkoo.yahtzee;

public class Yatzee {
	
	private DiceLauncher diceLauncher;
	private final User user;
   private Dices selectDices;
	

	public Yatzee(DiceLauncher diceLauncher, User user) {
		this.diceLauncher = diceLauncher;
		this.user = user;
		this.user.setYatzee(this);
	}

	public void start() {		
		notifyThrowDice();
	}

   private void notifyThrowDice() {
      user.notifyDicesLaunched(diceLauncher.launch());
   }

	public Boolean finished() {
		return true;
	}

	public Integer score() {
		// TODO Auto-generated method stub
		return null;
	}

   public void notifySelectDices(Dices dices) {
      selectDices = dices; 
   }

   public Dices getSelectedDices() {
      return selectDices;
   }

   public void notifyWantRethrow() {
      notifyThrowDice();
   }
}
