package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDices {

   @Test
   public void containsTrue()
   {
      Dices dices = new Dices(1, 2, 3);
      assertThat(dices.contains(new Dices(1,2,3)), is(true));
   }

   @Test
   public void containsFalse()
   {
      Dices dices = new Dices(1, 2, 3);
      assertThat(dices.contains(new Dices(1,2,4)), is(false));
   }

   @Test
   public void containsDuplicate()
   {
      Dices dices = new Dices(1, 2, 3);
      assertThat(dices.contains(new Dices(1,1)), is(false));
   }

   @Test
   public void scoreForCategoryIsTrue() {
      Dices dices = new Dices(1, 2, 3);
      assertThat(dices.getScore(1), is(1));
   }

   @Test
   public void add()
   {
      Dices dices = new Dices(1);
      dices.add(new Dices(2));
      assertThat(dices, equalTo(new Dices(1,2)));
   }
}
