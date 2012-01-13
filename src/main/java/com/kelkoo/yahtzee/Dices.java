package com.kelkoo.yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Dices {
   private List<Integer> diceValues = new ArrayList<Integer>();

   public Dices(int... diceValues) {
      for (Integer dice : diceValues) {
         this.diceValues.add(dice);
      }
      Collections.sort(this.diceValues);
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37).append(diceValues).toHashCode();
   }

   @Override
   public boolean equals(final Object obj) {
      if (obj instanceof Dices) {
         final Dices other = (Dices) obj;
         return new EqualsBuilder().append(diceValues, other.diceValues).isEquals();
      } else {
         return false;
      }
   }

   public void add(Dices dices) {
      this.diceValues.addAll(dices.diceValues);
      Collections.sort(this.diceValues);
   }

   @Override
   public String toString() {
      return new ToStringBuilder(this).append("diceValues", diceValues).toString();
   }

   public Integer sum() {
      int score = 0;
      for (Integer value : diceValues) {
         score += value;
      }
      return score;
   }

}
