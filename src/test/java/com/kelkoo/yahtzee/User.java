package com.kelkoo.yahtzee;

public class User {

   private Dices dices;
   private Yatzee yatzee;

   public void selectDices(Integer ...i) throws BadSelectedDices {
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

   public void selectCategory(int category) {
      this.yatzee.receiveUserSelectCategory(category);
   }
   
}
