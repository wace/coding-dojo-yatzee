package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.List;

public class Yatzee {

   private final DiceLauncher diceLauncher;
   private final User user;
   private Dices selectedDices;
   private Dices launchDices;
   private int launchCounter;
   private int score;
   private List<Integer> selectedCategories = new ArrayList<Integer>();

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
      this.launchCounter = 0;
      this.score = 0;
   }

   public void start() {
      throwDices();
   }

   private void throwDices() {
      launchDices = diceLauncher.launch();
      user.canSelectDices(launchDices);
      launchCounter++;
   }

   public Integer score() {
      return score;
   }

   public void receiveUserSelectDices(Integer... dices) throws BadSelectedDices {
      selectedDices = new Dices(dices);
      if (!launchDices.contains(selectedDices)) {
         throw new BadSelectedDices("tricheur");
      }
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      return launchCounter >= 3;
   }

   public void receiveUserSelectCategory(int selectedCat) throws CategoryAlreadySelected {
      if(selectedCategories.contains(selectedCat)) {
         throw new CategoryAlreadySelected();
      }
      selectedCategories.add(selectedCat);

      score = selectedDices.getScore(selectedCat);

   }
}
