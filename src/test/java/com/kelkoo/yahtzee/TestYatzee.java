package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class TestYatzee {

   @Test
   public void testStart() {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      when(diceLauncher.launch()).thenReturn(new Dices(1, 1, 3, 3, 4));
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncher, user);

      yatzee.start();

      verify(diceLauncher).launch();
      verify(user).notifyDicesLaunched(Mockito.any(Dices.class));

   }

   @Test
   public void testNotifySelectDices() {
      Yatzee yatzee = new Yatzee(new DiceLauncher(), new User());
      Dices dices = new Dices(1, 1);

      yatzee.notifySelectDices(dices);

      assertThat(yatzee.getSelectedDices(), equalTo(dices));
   }

   @Test
   public void testNotifyWantRethrow() {
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      Dices dices = new Dices(1, 1, 3, 3, 4);
      when(diceLauncher.launch()).thenReturn(dices);
      User user = mock(User.class);
      Yatzee yatzee = new Yatzee(diceLauncher, user);

      yatzee.notifyWantRethrow();

      verify(user).notifyDicesLaunched(dices);
   }



   @Test
   public void notifySelectCategory() {
      Yatzee yatzee = new Yatzee(new DiceLauncher(), mock(User.class));
      yatzee.notifySelectDices(new Dices(1, 1, 1));

      yatzee.notifySelectCategory(1);

      assertThat(yatzee.score(), equalTo(3));

   }

   @Test
   public void notifySelectCategoryDifferentFromSelectedDices() throws Exception {

      Yatzee yatzee = new Yatzee(new DiceLauncher(), mock(User.class));
      yatzee.notifySelectDices(new Dices(1, 1, 1));

      yatzee.notifySelectCategory(2);

      assertThat(yatzee.score(), equalTo(0));
   }

   @Test(expected=CategoryAlreadySelectedException.class)
   
   public void notifySelectCategoryPossibleOnlyOnce() throws Exception {

      Yatzee yatzee = new Yatzee(new DiceLauncher(), mock(User.class));

      yatzee.notifySelectCategory(2);
      yatzee.notifySelectCategory(2);

   }

}
