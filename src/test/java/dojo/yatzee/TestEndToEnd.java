package dojo.yatzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;

import dojo.yatzee.Yatzee;

public class TestEndToEnd {

   
   
   
   // Finishes when category of one is done
   @Test 
   //@Ignore
   public void playWithCategoryOfOnesWithOneUserThreeTurns() throws Exception {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch()).
            thenReturn(new Dices(1, 1, 3, 3, 4)).
            thenReturn(new Dices(1, 6, 6)).
            thenReturn(new Dices(1, 2));
      Player joe = new Player();
      Yatzee yatzee = new Yatzee(diceLauncher, joe);
      yatzee.start();
      joe.selectDices(1, 1);
      joe.wantToRethrow();
      joe.selectDices(1);
      joe.wantToRethrow();
      joe.selectDices(1);
      assertThat("game should be finished", yatzee.isFinished(), is(true));
      assertThat(yatzee.score(), is(4));
   }

   
   // manage multiple figures categories (1..6)
   // manage other categories (brelan, carre, full, petite suite, grande suite, yatzee, chance)
   // manage figures bonus
   // manage multiples users
   // implement interface with terminal
   // implement web interface
   // implement network gaming
}
