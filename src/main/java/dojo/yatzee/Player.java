package dojo.yatzee;

public class Player {

   private Yatzee yatzee;
   
   public void setYatzee(Yatzee yatzee) {
      this.yatzee = yatzee;
   }

   public void selectDices(Integer...dice) {
      yatzee.selectDices(dice);
   }

   public void wantToRethrow() {
   }

   public void dicesLaunched(Dices expectedDices) {
   }

}
