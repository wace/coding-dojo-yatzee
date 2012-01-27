package com.kelkoo.yahtzee;

import static java.util.Collections.*;

import java.util.HashSet;
import java.util.Set;

public class Yatzee {

   private static final int NUMBER_OF_CATEGORIES = 2;
   private static final int MAX_NB_THROWS = 3;
   private DiceLauncher diceLauncher;
   private final User user;
   private Dices selectedDices = new Dices();
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
      user.notifyDicesLaunched(diceLauncher.launch());   
   }

   public Boolean isFinished() {
      return selectedCategories.size() == NUMBER_OF_CATEGORIES;
   }

   public Integer score() {
      return score;
   }

   public void notifySelectDices(Dices dices) {
      selectedDices.add(dices); 
   }

   public Dices getSelectedDices() {
      return selectedDices;
   }

   public void notifyWantRethrow() throws NumberThrowsExceededException {
      if(nbThrows == MAX_NB_THROWS) {
         throw new NumberThrowsExceededException();
      }
      launchDicesAndNotifyToUser();
      nbThrows++;
   }

   public void notifySelectCategory(int category) throws CategoryAlreadySelectedException {
      if (selectedCategories.contains(category)) {
         throw new CategoryAlreadySelectedException();
      }
      score += selectedDices.sum(category);
      selectedCategories.add(category);
   }
}
