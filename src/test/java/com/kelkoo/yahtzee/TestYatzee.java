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

      yatzee.startGame();

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
   public void testTurnFinishedAfter3Launches() throws Exception {
      this.yatzee.startGame();
      this.yatzee.receiveUserWantRethrow();
      this.yatzee.receiveUserWantRethrow();
      assertTrue("yatzee should be finished", yatzee.currentTurnFinished());
   }

   @Test
   public void testNotFinishedAfter2Launches() throws Exception {
      this.yatzee.startGame();
      this.yatzee.receiveUserWantRethrow();
      assertFalse("yatzee should not be finished", yatzee.currentTurnFinished());
   }

   @Test
   public void testScoreAfterStart() throws Exception {
      yatzee.startGame();

      assertThat(yatzee.score(), equalTo(0));
   }
   
   @Test
   public void testScoreAfterTwoLaunches() throws Exception {
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result);
      yatzee.startGame();      
      yatzee.receiveUserSelectedDices(1, 1);
      yatzee.receiveUserSelectedDices(1);   
      yatzee.receiveUserSelectCategory(1);
      
      assertThat(yatzee.score(), equalTo(3));
   }

   @Test(expected = BadSelectedDices.class)
   public void testBadSelectedDicesWhenDiceNotReceived() throws BadSelectedDices {
      Dices result = new Dices(1, 2, 3);
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1, 4);
   }

   @Test(expected = BadSelectedDices.class)
   public void testBadSelectedDicesWhenDiceIsSelectedTwice() throws BadSelectedDices {
      Dices result = new Dices(1, 2, 3);
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1, 1);
   }

   @Test(expected=CategoryAlreadySelected.class)
   public void anErrorIsThrownWhenUserSelectACategoryTwice() throws Exception {
      Dices result = new Dices(1, 2, 3);
      when(diceLauncherMock.launch()).thenReturn(result);

      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1);
      yatzee.receiveUserSelectCategory(1);
      yatzee.receiveUserSelectCategory(1);
   }
   
   @Test
   public void whenReceiveUserSelectWrongCategoryThenScoreIsComputed() throws Exception {   
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result);
      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1, 1);
      yatzee.receiveUserSelectedDices(1);
      yatzee.receiveUserSelectedDices();
      yatzee.receiveUserSelectCategory(2);
      assertThat(yatzee.score(), equalTo(0));            
   }

   @Test
   public void gameFinished() throws Exception
   {
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result);
      this.yatzee.startGame();
      assertThat(yatzee.gameFinished(), is(false));

      yatzee.receiveUserSelectedDices();
      yatzee.receiveUserSelectCategory(2);
      
      this.yatzee.receiveUserWantRethrow();
      yatzee.receiveUserSelectedDices();
      yatzee.receiveUserSelectCategory(1);
      assertThat(yatzee.gameFinished(), is(true));
      
   }

   // TODO check score calculation
   @Test
   public void whenReceiveUserSelectCategoryThenScoreIsComputed() throws Exception {   
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result);
      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1, 1);
      yatzee.receiveUserSelectedDices(1);
      yatzee.receiveUserSelectedDices();
      yatzee.receiveUserSelectCategory(1);
      assertThat(yatzee.score(), equalTo(3));            
   }

   @Test
   public void scoreAfterTwoTurns() throws Exception {   
      Dices result = new Dices(1, 1, 1);
      when(diceLauncherMock.launch()).thenReturn(result).thenReturn(new Dices (2,2,3)) ;

      yatzee.startGame();
      yatzee.receiveUserSelectedDices(1, 1);
      yatzee.receiveUserSelectCategory(1);
      
      yatzee.receiveUserSelectedDices(2, 2);
      yatzee.receiveUserSelectCategory(2);
      assertThat(yatzee.score(), equalTo(6));
   }
}
