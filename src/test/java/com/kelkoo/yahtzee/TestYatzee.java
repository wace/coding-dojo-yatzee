package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestYatzee {
   
   private DiceLauncher diceLauncherMock;
   private User user;
   private Yatzee yatzee;

   @Before
   public void setUp() {
      diceLauncherMock = mock(DiceLauncher.class);
      user = mock(User.class);
      yatzee = new Yatzee(diceLauncherMock, user);
   }

   @Test
   public void testStart() {
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.start();

      verify(user).canSelectDices(result);
   }

   @Test
   public void testReceiveUserSelectDices() throws Exception {
      yatzee.receiveUserSelectDices(1, 1);

      assertThat(yatzee.getSelectedDices(), equalTo(new Dices(1, 1)));
   }

   @Test
   public void testReceiveUserWantRethrow() {
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.receiveUserWantRethrow();

      verify(user).canSelectDices(result);
   }

   @Test
   public void testNotFinished() throws Exception {
      receiveUserSelectDicesNTimes(2);
      assertThat(yatzee.finished(), equalTo(false));
   }

   @Test
   public void testFinished() throws Exception {
      receiveUserSelectDicesNTimes(3);
      assertThat(yatzee.finished(), equalTo(true));
   }

   @Test(expected=TooManyThrowsException.class)
   public void testNoMoreThatThreeThrows() throws Exception {
      receiveUserSelectDicesNTimes(4);
   }

   private void receiveUserSelectDicesNTimes(int nbTurns) throws TooManyThrowsException {
      for (int turn = 0; turn<nbTurns; turn++) {
         yatzee.receiveUserSelectDices(1);
      }
   }

   @Test
   public void testScore2() throws Exception {
      receiveUserSelectDicesNTimes(2);
      assertThat(yatzee.score(), equalTo(2));
   }
   @Test
   public void testScore3() throws Exception {
      receiveUserSelectDicesNTimes(3);
      assertThat(yatzee.score(), equalTo(3));
   }
}
