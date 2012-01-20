package com.kelkoo.yahtzee;

public class Yatzee {

   private DiceLauncher diceLauncher;
   private final User user;
   private Dices selectDices = new Dices();
   private int score = 0;
   public Integer selectedCategory;


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
      return score;
   }

   public void notifySelectDices(Dices dices) {
      selectDices.add(dices); 
   }

   public Dices getSelectedDices() {
      return selectDices;
   }

   public void notifyWantRethrow() {
      notifyThrowDice();
   }

   public void notifySelectCategory(int category) {
      score = selectDices.sum(category);
   }
}
