package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestEndToEnd {

   // finishes when reach three throws
   @Test
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

   

   // control no more than three throws
   // manage multiple figures categories (1..6)
   // manage other categories (brelan, carre, full, petite suite, grande suite, yatzee, chance)
   // manage figures bonus
   // manage multiples users
   // implement interface with terminal
   // implement web interface
   // implement network gaming

}
