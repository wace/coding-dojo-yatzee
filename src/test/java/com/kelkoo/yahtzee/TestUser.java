package com.kelkoo.yahtzee;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestUser {

   private User user;
   private Yatzee yatzee;
   
   @Before
   public void setup() {
      user = new User();
      yatzee = mock(Yatzee.class);
      user.setYatzee(yatzee);
   }

   @Test
   public void testSelectDices() {
      user.selectDices(1, 1);      
      verify(yatzee).receivedUserChoice(1, 1);
   }

   @Test
   public void testWantRethrow() {
      user.wantRethrow();      
      verify(yatzee).receivedUserWantRethrow();
   }

}
