package dojo.yatzee;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class YatzeeTest {

   @Test
   public void startYatzeeShouldLaunchDiceAndDispayDicesToUser() {
      // Given
      DiceLauncher diceLauncher = mock(DiceLauncher.class);
      Dices expectedDices = new Dices(1, 1, 3, 3, 4);
      when(diceLauncher.launch()).
            thenReturn(expectedDices);
      Player joe = mock(Player.class);
      
      Yatzee yatzee = new Yatzee(diceLauncher, joe);
      
      //When
      yatzee.start();
      
      // Then
      Mockito.verify(joe).dicesLaunched(expectedDices);
   }
   
   @Test
   @Ignore
   public void checkGameIsFinishedAfter3Launches() throws Exception {
      //Given
      DiceLauncher diceLauncher = mock(DiceLauncher.class);      
      Player player = mock(Player.class);
      Yatzee yatzee = new Yatzee(diceLauncher, player);
      
      
      
      yatzee.start();
            
      //When      
      player.wantToRethrow();
      player.wantToRethrow();
      
      //Then
      assertTrue(yatzee.isFinished());
   }

   @Test
   @Ignore
   public void checkGameIsFinishedAfter0Launches() throws Exception {
      //Given
      DiceLauncher diceLauncher = mock(DiceLauncher.class);      
      Player player = mock(Player.class);
      Yatzee yatzee = new Yatzee(diceLauncher, player);
      yatzee.start();
            
      //When      
      
      //Then
      assertFalse(yatzee.isFinished());
   }

}
