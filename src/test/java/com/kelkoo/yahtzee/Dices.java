package com.kelkoo.yahtzee;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Dices {



   private final int[] dices;


   public Dices(int... dices) {
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
}
