package com.kelkoo.yahtzee;

public class Yatzee {

   private final DiceLauncher diceLauncher;
   private final User user;
   private Dices selectedDices;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
   }

   public void start() {
      throwDices();
   }

   private void throwDices() {
      Dices launch = diceLauncher.launch();
      user.canSelectDices(launch);
   }

   public Integer score() {
      throw new RuntimeException("Not Implemented Yet");
   }

   public void receiveUserSelectDices(int... i) {
      selectedDices = new Dices(i);
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      throw new RuntimeException("Not Implemented Yet");
   }

   public Dices getSelectedDices() {
      return selectedDices;
   }

}
