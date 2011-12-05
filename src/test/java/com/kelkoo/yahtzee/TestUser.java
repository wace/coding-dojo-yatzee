package com.kelkoo.yahtzee;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestUser {

   @Test
   public void testSelectDices() {
      User user = new User();
      user.canSelectDices(new Dices(1, 1, 2, 3, 4));
      
      user.selectDices(1, 1);
      
      Yatzee yatzee = mock(Yatzee.class);
      verify(yatzee).receivedUserChoice(1,1);
   }

}
