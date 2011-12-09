package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestUser {

   @Test
   public void testSelectDices() {
      User u = new User();
      Yatzee yatzeeMock = mock(Yatzee.class);
      u.setYatzee(yatzeeMock);
      
      u.selectDices(1);
      
      verify(yatzeeMock).notifySelectDices(1);
   }

   @Test
   public void testNotifyDicesLaunched()
   {
      User u = new User();
      
      
      
   }

}
