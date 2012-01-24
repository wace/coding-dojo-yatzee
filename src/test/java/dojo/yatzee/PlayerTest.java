package dojo.yatzee;

import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

   @Test
   @Ignore
   public void TestPlayerInParty() {
      Yatzee yatzee = mock(Yatzee.class);
     
    //Mockito.verify(yatzee).launch();
   }
   
   @Test
   public void testPlayerSelectDices() {
      //Given
      Player joe = new Player() ;
      Yatzee yatzee = mock(Yatzee.class);
      
      //When
      joe.selectDices(1,1) ;
      
      //Then
      verify(yatzee).selectDices(1,1);
      
      
   }

}
