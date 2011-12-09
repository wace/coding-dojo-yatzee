package com.kelkoo.yahtzee;

import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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

}
