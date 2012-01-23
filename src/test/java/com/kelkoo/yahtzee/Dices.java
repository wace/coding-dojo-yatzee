package com.kelkoo.yahtzee;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Dices {

   private final Integer[] dices;

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

   public boolean contains(Dices dices) {
      List<Integer> dicesList = Arrays.asList(dices.dices);
      List<Integer> currentDiceslist = Arrays.asList(this.dices);
      return currentDiceslist.containsAll(dicesList);
   }
}
