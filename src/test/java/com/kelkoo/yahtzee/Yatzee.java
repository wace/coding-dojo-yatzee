package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.List;

public class Yatzee {

   public static class Turn {
      private Dices selectedDices;
      private Dices launchedDices;
      private int launchCounter = 0;

      public Turn() {
      }

      public Dices getSelectedDices() {
         return selectedDices;
      }

      public void setSelectedDices(Dices selectedDices) throws BadSelectedDices {
         this.selectedDices = selectedDices;
         checkSelectedDices();
      }

      public Dices getLaunchedDices() {
         return launchedDices;
      }

      public int getLaunchCounter() {
         return launchCounter;
      }

      public void setLaunchCounter(int launchCounter) {
         this.launchCounter = launchCounter;
      }
      

      public void throwDices(Dices launchedDices) {
         this.launchedDices = launchedDices;
         launchCounter++;
      }

      public void checkSelectedDices() throws BadSelectedDices {
         if (!launchedDices.contains(selectedDices)) {
            throw new BadSelectedDices("tricheur");
         }
      }

      boolean isFinished() {
         return launchCounter >= 3;
      }

      Integer computeScore(int selectedCat) {
         return selectedDices.getScore(selectedCat);
      }
   }

   private final DiceLauncher diceLauncher;
   private final User user;
   private Turn turn;
   private int score;
   private List<Integer> selectedCategories = new ArrayList<Integer>();

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
      this.turn = new Turn();
      this.score = 0;
   }

   public void start() {
      throwDices();
   }

   private void throwDices() {
      turn.throwDices(diceLauncher.launch());
      user.canSelectDices(turn.getLaunchedDices());
   }

   public Integer score() {
      return score;
   }

   public void receiveUserSelectedDices(Integer... dices) throws BadSelectedDices {
      turn.setSelectedDices(new Dices(dices));
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      return turn.isFinished();
   }

   public void receiveUserSelectCategory(int selectedCat) throws CategoryAlreadySelected {
      if(selectedCategories.contains(selectedCat)) {
         throw new CategoryAlreadySelected();
      }
      selectedCategories.add(selectedCat);

      score = turn.computeScore(selectedCat);

   }
}
