package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestYatzeeTurn {

   @Test
   public void testTurn() throws Exception {
      
      YatzeeTurn yatzeeTurn = new YatzeeTurn();
      
      assertThat(yatzeeTurn.isFinished(), equalTo(false));
      
      // launch 3 throws 
      assertThat(yatzeeTurn.isFinished(), equalTo(true));
      
   }

   @Test
   public void testTurnNotFinished() throws Exception {
      
      
   }
}
