package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.List;

public class Yatzee {

   public static class Turn {
      private Dices selectedDices = new Dices();
      private int launchCounter = 0;

      public Turn() {
      }

      public Dices getSelectedDices() {
         return selectedDices;
      }

      public void addSelectedDices(Dices selectedDices) {
         this.selectedDices.add(selectedDices);
      }

      public int getLaunchCounter() {
         return launchCounter;
      }

      public void setLaunchCounter(int launchCounter) {
         this.launchCounter = launchCounter;
      }

      public int getScore(int selectedCat) {
         return selectedDices.getScore(selectedCat);
      }

      public boolean isFinished() {
         return launchCounter >= 3;
      }

      public void increaseLaunchCounter() {
         this.launchCounter = launchCounter + 1;
      }
      
   }

   private final DiceLauncher diceLauncher;
   private final User user;
   private Dices launchDices;
   private int score;
   private List<Integer> selectedCategories = new ArrayList<Integer>();
   private Turn turn;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
      turn = new Turn();
      this.score = 0;
   }

   public void start() {
      throwDices();
   }

   private void throwDices() {
      launchDices = diceLauncher.launch();
      user.canSelectDices(launchDices);
      turn.increaseLaunchCounter();
   }

   public Integer score() {
      return score;
   }

   public void receiveUserSelectDices(Integer... dices) throws BadSelectedDices {
      turn.addSelectedDices(new Dices(dices));
      if (!launchDices.contains(turn.getSelectedDices())) {
         throw new BadSelectedDices("tricheur");
      }
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      return selectedCategories.size() == 2;
   }
   
   public Boolean turnFinished() {
      return turn.isFinished();
   }

   public void receiveUserSelectCategory(int selectedCat) throws CategoryAlreadySelected {
      checkCategoryAlreadySelected(selectedCat);
      
      selectedCategories.add(selectedCat);

      score = turn.getScore(selectedCat);

   }

   private void checkCategoryAlreadySelected(int selectedCat) throws CategoryAlreadySelected {
      if(selectedCategories.contains(selectedCat)) {
         throw new CategoryAlreadySelected();
      }
   }
   
  
}
