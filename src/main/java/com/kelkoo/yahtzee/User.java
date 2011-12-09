package com.kelkoo.yahtzee;


public class User {

   private Dices launchedDices;
   private Dices keptDices;
   private Yatzee yatzee;
   
   public void selectDices(int... diceNumber) {
      yatzee.notifySelectDices(diceNumber);
   }

   public void wantRethrow() {
      throw new RuntimeException("not implemented");
   }

   public void notifyDicesLaunched(Dices dices) {
      throw new RuntimeException("not implemented");
   }

   public Dices getKeptDices() {
      return keptDices;
   }

   public void setKeptDices(Dices keptDices) {
      this.keptDices = keptDices;
   }

   public void setYatzee(Yatzee yatzee) {
      this.yatzee = yatzee;
   }

}
