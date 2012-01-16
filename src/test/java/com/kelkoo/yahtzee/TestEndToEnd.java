package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestEndToEnd {

   // finishes when reach three throws
   @Test
   @Ignore
   public void playWithCategoryOfOnesWithOneUserThreeTurns() throws Exception {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch()).thenReturn(new Dices(1, 1, 3, 3, 4)).thenReturn(new Dices(1, 6, 6))
            .thenReturn(new Dices(1, 2));
      User user = new User();
      Yatzee yatzee = new Yatzee(diceLauncher, user);
      yatzee.start();
      user.selectDices(1, 1);
      user.wantRethrow();
      user.selectDices(1);
      user.wantRethrow();
      user.selectDices(1);
      assertThat("should be finished", yatzee.finished(), is(true));
      assertThat(yatzee.score(), is(4));
   }

   // finishes when reach three throws
   @Test
   public void playWithCategory1And2() throws Exception {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch()).thenReturn(new Dices(1, 1, 3, 3, 4)).thenReturn(new Dices(1, 6, 6))
      .thenReturn(new Dices(1, 2))
      .thenReturn(new Dices(2, 1, 3, 6, 4)).thenReturn(new Dices(2,3,4,5)).thenReturn(new Dices(2,2,2));
      User user = new User();
      Yatzee yatzee = new Yatzee(diceLauncher, user);
      yatzee.start();
      user.selectDices(1, 1);
      user.wantRethrow();
      user.selectDices(1);
      user.wantRethrow();
      user.selectDices(1);
      assertThat(yatzee.score(), is(4));
      assertThat("should be finished", yatzee.finished(), is(false));
      // second category : aim for 2
      user.selectDices(2);
      user.wantRethrow();
      user.selectDices(2);
      user.wantRethrow();
      user.selectDices(2,2,2);

      assertThat(yatzee.score(), is(4+10));      
      assertThat("should be finished", yatzee.finished(), is(true));
   }
   
   /*
    * TODO LIST
    * - check dices values
    * - keep "all" selected dices for each turn
    * 
    */

   // control no more than three throws --> DONE
   // manage multiple figures categories (1..6)
   // manage other categories (brelan, carre, full, petite suite, grande suite, yatzee, chance)
   // manage figures bonus
   // manage multiples users
   // implement interface with terminal
   // implement web interface
   // implement network gaming

}
