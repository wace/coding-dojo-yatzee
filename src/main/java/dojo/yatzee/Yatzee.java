package dojo.yatzee;

public class Yatzee {

   
   private final DiceLauncher diceLauncher;
   private Player player = null;
   
   public Yatzee(DiceLauncher diceLauncher, Player player) {
      this.diceLauncher = diceLauncher;
      this.player = player;
   }

   public void start() {
      Dices currentDices = diceLauncher.launch();
      player.dicesLaunched(currentDices);
   }

   public Integer score() {
      return null;
   }

   public Boolean isFinished() {
      return true;
   }

   public void selectDices(Integer...dices) {
   }

}
