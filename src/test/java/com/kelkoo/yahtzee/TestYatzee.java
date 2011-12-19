package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestYatzee {

   @Test
   public void testStart() {
      DiceLauncher diceLauncherMock = mock(DiceLauncher.class);
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncherMock, user);
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.start();

      verify(user).canSelectDices(result);
   }

   @Test
   public void testReceiveUserSelectDices() throws Exception {
      DiceLauncher diceLauncherMock = mock(DiceLauncher.class);
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncherMock, user);

      yatzee.receiveUserSelectDices(1, 1);

      assertThat(yatzee.getSelectedDices(), equalTo(new Dices(1, 1)));
   }

   @Test
   public void testReceiveUserWantRethrow() {
      DiceLauncher diceLauncherMock = mock(DiceLauncher.class);
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncherMock, user);
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.receiveUserWantRethrow();

      verify(user).canSelectDices(result);
   }

}
