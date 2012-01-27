package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestUser {

   private User user;

   @Before
   public void setup() {
      user = new User();
   }

   @Test
   public void testSelectDices() {
      Yatzee yatzeeMock = mock(Yatzee.class);
      user.setYatzee(yatzeeMock);

      Dices dices = new Dices(1);
      user.selectDices(dices);

      verify(yatzeeMock).notifySelectDices(dices);
   }

   @Test
   public void testNotifyDicesLaunched() {

      user.notifyDicesLaunched(new Dices(1, 3, 3));

      assertThat(user.getLaunchedDices(), equalTo(new Dices(1, 3, 3)));
   }

   @Test
   public void testWantRethrow() {
      Yatzee yatzeeMock = mock(Yatzee.class);
      user.setYatzee(yatzeeMock);

      user.wantRethrow();

      verify(yatzeeMock).notifyWantRethrow();
   }

   @Test
   public void testSelectCategory() throws CategoryAlreadySelectedException {
      Yatzee yatzeeMock = mock(Yatzee.class);
      user.setYatzee(yatzeeMock);
      
      user.selectCategory(1);

      verify(yatzeeMock).notifySelectCategory(1);
   }

}
