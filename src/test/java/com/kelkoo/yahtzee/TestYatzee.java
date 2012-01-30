package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

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
   public void testReceiveUserWantRethrow() {
      Dices result = new Dices();
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.receiveUserWantRethrow();

      verify(user).canSelectDices(result);
   }

   @Test
   public void testFinishedAfter3Launches() throws Exception {
      this.yatzee.start();
      this.yatzee.receiveUserWantRethrow();
      this.yatzee.receiveUserWantRethrow();
      assertTrue("yatzee should be finished", yatzee.finished());
   }

   @Test
   public void testNotFinishedAfter2Launches() throws Exception {
      this.yatzee.start();
      this.yatzee.receiveUserWantRethrow();
      assertFalse("yatzee should not be finished", yatzee.finished());
   }

   @Test
   public void testScoreAfterUserSelection() throws Exception {
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result);
      yatzee.start();
      yatzee.receiveUserSelectDices(1, 1);
      yatzee.receiveUserSelectDices(1);
      yatzee.receiveUserSelectDices();

      assertThat(yatzee.score(), equalTo(3));
   }

   @Test
   public void testScoreAfterStart() throws Exception {
      yatzee.start();

      assertThat(yatzee.score(), equalTo(0));
   }

   @Test(expected = BadSelectedDices.class)
   public void testBadSelectedDicesWhenDiceNotReceived() throws BadSelectedDices {
      Dices result = new Dices(1, 2, 3);
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.start();
      yatzee.receiveUserSelectDices(1, 4);
   }

   @Test(expected = BadSelectedDices.class)
   public void testBadSelectedDicesWhenDiceIsSelectedTwice() throws BadSelectedDices {
      Dices result = new Dices(1, 2, 3);
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.start();
      yatzee.receiveUserSelectDices(1, 1);
   }

   @Test
   public void receiveUserSelectCategory() {
      // TODO check score calculation
   }
}
