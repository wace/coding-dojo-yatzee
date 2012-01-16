package com.kelkoo.yahtzee;

public class Yatzee {

   private final DiceLauncher diceLauncher;
   private final User user;
   private Dices selectedDices;
   private Dices launchDices;
   private int launchCounter;
   private int score;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
      this.launchCounter = 0;
      this.score = 0;
   }

   public void start() {
      throwDices();
   }

   private void throwDices() {
      launchDices = diceLauncher.launch();
      user.canSelectDices(launchDices);
      launchCounter ++;
   }

   public Integer score() {
      return score;
   }

   public void receiveUserSelectDices(int... dices) {
      //TODO
      // compare user selected dices with launch dices
      selectedDices = new Dices(dices);
      for (int dice : dices) {
         score += dice;
      }
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      return launchCounter >= 3;
   }
}
