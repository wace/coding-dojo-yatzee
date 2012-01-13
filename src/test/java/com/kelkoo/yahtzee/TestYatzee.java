package com.kelkoo.yahtzee;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class TestYatzee {
	
	@Test
	public void testStart(){
		DiceLauncher diceLauncher = mock(DiceLauncher.class);
	      when(diceLauncher.launch()).thenReturn(new Dices(1, 1, 3, 3, 4));
	      User user = mock(User.class);
	      Yatzee yatzee = new Yatzee(diceLauncher, user);
	      
	      yatzee.start();
	      
	      verify(diceLauncher).launch();
	      verify(user).notifyDicesLaunched(Mockito.any(Dices.class));
	      
	}

   @Test
   public void testNotifySelectDices()
   {
      Yatzee yatzee = new Yatzee(new DiceLauncher(), new User());
      Dices dices = new Dices(1,1);
      
      yatzee.notifySelectDices(dices);
      
      assertThat(yatzee.getSelectedDices(), equalTo(dices));
   }

   @Test
   public void testNotifyWantRethrow()
   {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      Dices dices = new Dices(1, 1, 3, 3, 4);
      when(diceLauncher.launch()).thenReturn(dices);
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncher, user);
      
      yatzee.notifyWantRethrow();
      
      verify(user).notifyDicesLaunched(dices);
   }
   
   @Test
   public void testScore()
   {
      Yatzee yatzee = new Yatzee(new DiceLauncher(), mock(User.class));
      
      yatzee.notifySelectDices(new Dices(1,1,1));
      
      assertThat(yatzee.score(), equalTo(3));
      
      yatzee.notifySelectDices(new Dices(1,1));

      assertThat(yatzee.score(), equalTo(5));
   }
   
   @Test
   public void testScoreThreeTimes() throws Exception {

      Yatzee yatzee = new Yatzee(new DiceLauncher(), mock(User.class));
      
      yatzee.notifySelectDices(new Dices(1,1,1));
      
      assertThat(yatzee.score(), equalTo(3));
      assertThat(yatzee.score(), equalTo(3));
   }
}
