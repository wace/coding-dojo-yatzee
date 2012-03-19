package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestEndToEnd {

   @Test
//   @Ignore
   public void playWithCategoryOfOnesWithOneUserThreeTurns() throws Exception {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch())
         .thenReturn(new Dices(1, 1, 3, 3, 4)).thenReturn(new Dices(1, 6, 6)).thenReturn(new Dices(1, 2))
         .thenReturn(new Dices(1, 2, 2, 5, 6)).thenReturn(new Dices(1, 3, 5)).thenReturn(new Dices(2, 3, 4));
      User user = new User(); 
      Yatzee yatzee = new Yatzee(diceLauncher, user);
      yatzee.start();
      
      user.selectDices(new Dices(1,1));
      user.wantRethrow();
      user.selectDices(new Dices(1));
      user.wantRethrow();
      user.selectDices(new Dices(1));
      user.selectCategory(1);
      assertThat("should not be finished", yatzee.isFinished(), is(false));
      assertThat(yatzee.score(), is(4));

      user.selectDices(new Dices(2,2));
      user.wantRethrow();
      user.wantRethrow();
      user.selectDices(new Dices(2));
      user.selectCategory(2);      
      assertThat("should be finished", yatzee.isFinished(), is(true));
      assertThat(yatzee.score(), is(10));
   }
 
   // FIXME remove the getNbThrow in Yatzee
   
   // TODO manage multiple figures categories (1..6)
   // TODO manage other categories (brelan, carre, full, petite suite, grande suite, yatzee, chance)
   // TODO manage figures bonus
   // TODO manage multiples users
   // TODO implement interface with terminal
   // TODO implement web interface
   // TODO implement network gaming

}
