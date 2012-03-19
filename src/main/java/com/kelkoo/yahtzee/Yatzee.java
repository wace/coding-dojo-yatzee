package com.kelkoo.yahtzee;

import java.util.HashSet;
import java.util.Set;

public class Yatzee {

   public static class Turn {
      private Dices selectedDices;
      private static final int MAX_NB_THROWS = 3;

      public Dices getSelectedDices() {
         return selectedDices;
      }

      void selectedDices(Dices dices) {
         selectedDices.add(dices);
      }

      Integer sum(int category) {
         return selectedDices.sum(category);
      }

      public Turn() {
         this.selectedDices = new Dices();
      }
   }

   private static final int NUMBER_OF_CATEGORIES = 2;
   private DiceLauncher diceLauncher;
   private final User user;
   private Turn turn = new Turn();
   private int score = 0;
   private Set<Integer> selectedCategories = new HashSet<Integer>();
   private int nbThrows;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
   }

   public void start() {	
      launchDicesAndNotifyToUser();
   }

   private void launchDicesAndNotifyToUser() {  
      nbThrows++;
      user.notifyDicesLaunched(diceLauncher.launch());   
   }

   public Boolean isFinished() {
      return selectedCategories.size() == NUMBER_OF_CATEGORIES;
   }

   public Integer score() {
      return score;
   }

   public void notifySelectDices(Dices dices) {
      turn.selectedDices(dices);
   }

   public void notifyWantRethrow() throws NumberThrowsExceededException {
      if (getNbThrow() == Turn.MAX_NB_THROWS) {
         throw new NumberThrowsExceededException();
      }
      launchDicesAndNotifyToUser();
   }

   public void notifySelectCategory(int category) throws CategoryAlreadySelectedException {
      if (selectedCategories.contains(category)) {
         throw new CategoryAlreadySelectedException();
      }
      score += turn.sum(category);
      selectedCategories.add(category);
      nbThrows = 0;
   }

   public Integer getNbThrow() {
      return nbThrows;
   }

   public Dices getSelectedDices() {
      return turn.getSelectedDices();
   }

}
