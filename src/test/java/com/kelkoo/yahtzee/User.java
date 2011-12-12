package com.kelkoo.yahtzee;

public class User {

   private Yatzee yatzee;
   
//   private Dices dices;

   public void selectDices(int ... diceValues) {
      yatzee.receivedUserChoice(diceValues);
   }

   public void canSelectDices(Dices result) {
      throw new RuntimeException("Not Implemented Yet");
   }

   public void setYatzee(Yatzee yatzee) {
      this.yatzee = yatzee;
   }

   public void wantRethrow() {
      yatzee.receivedUserWantRethrow();
   }

//   public Dices getDices() {
//      return dices;
//   }

}
