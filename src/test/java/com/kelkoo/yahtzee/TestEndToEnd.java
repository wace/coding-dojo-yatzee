package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestEndToEnd {

   // finishes when reach three throws
   @Test
   public void playWithCategoryOfOnesWithOneUserTwoTurns() throws Exception {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch()).
         thenReturn(new Dices(1, 1, 3, 3, 4)).
         thenReturn(new Dices(1, 6, 6)).
         thenReturn(new Dices(1, 2)).
         thenReturn(new Dices(1, 1, 2, 3, 4)).
         thenReturn(new Dices(1, 2, 4, 6)).
         thenReturn(new Dices(1, 2, 3));
      User user = new User();
      Yatzee yatzee = new Yatzee(diceLauncher, user);
      yatzee.start();
      user.selectDices(1, 1);
      user.wantRethrow();
      user.selectDices(1);
      user.wantRethrow();
      user.selectDices(1);
      user.selectCategory(1);
      assertThat("should not be finished", yatzee.gameFinished(), is(false));
      assertThat(yatzee.score(), is(4));
      
      
      user.selectDices(2);
      user.wantRethrow();
      user.selectDices(2);
      user.wantRethrow();
      user.selectDices(2);
      user.selectCategory(2);
      assertThat("should be finished", yatzee.currentTurnFinished(), is(true));
      assertThat(yatzee.score(), is(10));
      
   }

   /*
    * TODO LIST
    * - TODO refactor array of integer in Dices (ie. to arraylist)
    * - keep "all" selected dices for each turn
    * 
    */

   // control no more than three throws
   // manage multiple figures categories (1..6)
   // manage other categories (brelan, carre, full, petite suite, grande suite, yatzee, chance)
   // manage figures bonus
   // manage multiples users
   // implement interface with terminal
   // implement web interface
   // implement network gaming

}
