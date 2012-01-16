package com.kelkoo.yahtzee;

public class User {

   private Dices dices;
   private Yatzee yatzee;

   public void selectDices(int ...i) throws TooManyThrowsException {
      this.yatzee.receiveUserSelectDices(i);
   }

   public void canSelectDices(Dices result) {
      this.dices = result;
   }

   public Dices getDices() {
      return dices;
   }

   public void setYatzee(Yatzee yatzee) {
      this.yatzee = yatzee;
   }

   public Yatzee getYatzee() {
      return yatzee;
   }

   public void wantRethrow() {
      this.yatzee.receiveUserWantRethrow();
   }
   
}
