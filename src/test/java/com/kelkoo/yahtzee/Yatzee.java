package com.kelkoo.yahtzee;

public class Yatzee {

   private final DiceLauncher diceLauncher;
   private final User user;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
   }

   public void start() {
      Dices launch = diceLauncher.launch();
      user.canSelectDices(launch);
   }

   public Integer score() {
      throw new RuntimeException("Not Implemented Yet");
   }

   public void receivedUserChoice(int ... l) {
      throw new RuntimeException("Not Implemented Yet");
   }

   public void receivedUserWantRethrow() {
      throw new RuntimeException("Not Implemented Yet");
   }

   public Boolean finished() {
      return true;
   }

}
