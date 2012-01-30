package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestUser {
   private User user;
   private Yatzee yatzee;

   @Before
   public void setUp() {
      user = new User();
      yatzee = mock(Yatzee.class);
      user.setYatzee(yatzee);
   }

   @Test
   public void testSelectDices() throws Exception {
      user.selectDices(1, 1);

      verify(yatzee).receiveUserSelectDices(1, 1);
   }

   @Test
   public void testWantRethrow() {
      user.wantRethrow();

      verify(yatzee).receiveUserWantRethrow();
   }

   @Test
   public void testCanSelectDices() {
      Dices dices = new Dices(1, 1, 1, 3, 4);

      user.canSelectDices(dices);

      assertThat(user.getDices(), equalTo(dices));
   }

   @Test
   public void selectCategory() {
      user.selectCategory(1);
      
      verify(yatzee).receiveUserSelectCategory(1);
   }

}
