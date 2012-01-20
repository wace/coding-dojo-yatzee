package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestDices {

   @Test
   public void addDices() throws Exception {
      Dices dices = new Dices(1,1);
      dices.add(new Dices(2));      
      assertThat(dices, equalTo(new Dices(1,1,2)));
   }
   
   @Test
   public void sum() throws Exception {
      Dices dices = new Dices(1,1,2,2);
      
      int sum = dices.sum(2);
      
      assertThat(sum, is(4));
   }
}
