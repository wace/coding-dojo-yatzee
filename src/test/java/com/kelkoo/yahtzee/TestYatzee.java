package com.kelkoo.yahtzee;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestYatzee {

   @Test
   public void testStart() {
      DiceLauncher diceLauncherMock = mock(DiceLauncher.class);
      User user = mock(User.class);
      Yatzee yatzee =  new Yatzee(diceLauncherMock, user);
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);
      
      yatzee.start();

      verify(user).canSelectDices(result);
   }
   

   
   

}
