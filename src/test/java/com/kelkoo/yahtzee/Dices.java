package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Dices {

   public final Integer[] dices;

   public Dices(Integer... dices) {
      this.dices = dices;

   }

   public Object size() {
      throw new RuntimeException("Not Implemented Yet");
   }

   @Override
   public boolean equals(final Object obj) {
      if (obj instanceof Dices) {
         final Dices other = (Dices) obj;
         return new EqualsBuilder().append(dices, other.dices).isEquals();
      } else {
         return false;
      }
   }

   public boolean contains(int dice) {
      for(int arrayDice : dices) {
         if(arrayDice == dice) {
            return true;
         }
      }
      return false;
   }

   public boolean contains(Dices otherDices) {
      List<Integer> otherDicesList = Arrays.asList(otherDices.dices);
      ArrayList<Integer> currentDicesList = new ArrayList<Integer> (Arrays.asList(this.dices));

      for (Integer dice : otherDicesList) {
         if (!currentDicesList.contains(dice)) {
            return false;
         } else{
            currentDicesList.remove(dice);
         }
      }
      
      return true;
   }

   public Integer getScore(int selectedCategory) {
      Integer score = 0;
      if(dices != null) {
         for (Integer dice: dices) {
            if(dice == selectedCategory) {
               score += dice;
            }
         }
      }
      return score;
   }

   public Dices add(Dices selectedDices) {
      List<Integer> l = new ArrayList<Integer>(Arrays.asList(dices));
      l.addAll(Arrays.asList(selectedDices.dices));
      
      return new Dices((Integer[]) l.toArray(new Integer[]{}));
   } 
   
}
