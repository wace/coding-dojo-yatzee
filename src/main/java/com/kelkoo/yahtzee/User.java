package com.kelkoo.yahtzee;


public class User {

   private Dices launchedDices;
   private Yatzee yatzee;
   
   public void selectDices(Dices dices) {
      yatzee.notifySelectDices(dices);
   }

   public void wantRethrow() {
      yatzee.notifyWantRethrow();
   }

   public void notifyDicesLaunched(Dices dices) {
      this.launchedDices = dices;
   }

   public void setYatzee(Yatzee yatzee) {
      this.yatzee = yatzee;
   }

   Dices getLaunchedDices() {
      return launchedDices;
   }

   public void selectCategory(int i) throws CategoryAlreadySelectedException {
      yatzee.notifySelectCategory(i);
   }
}
