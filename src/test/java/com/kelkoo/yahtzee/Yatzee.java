package com.kelkoo.yahtzee;

public class Yatzee {

   private static final int MAX_TURNS = 3;
   private final DiceLauncher diceLauncher;
   private final User user;
   private Dices selectedDices;
   private int playedTurns;
   private int score;

   public Yatzee(DiceLauncher diceLauncher, User user) {
      this.diceLauncher = diceLauncher;
      this.user = user;
      this.user.setYatzee(this);
   }

   public void start() {
      throwDices();
      playedTurns=0;
      score=0;
   }

   private void throwDices() {
      Dices launch = diceLauncher.launch();
      user.canSelectDices(launch);
   }

   public Integer score() {
      return score;
   }

   public void receiveUserSelectDices(int... dicesValues) throws TooManyThrowsException {
      if (playedTurns>=MAX_TURNS) {
         throw new TooManyThrowsException();
      }
      selectedDices = new Dices(dicesValues);
      for (int value : dicesValues) {
         score += value;
      }
      playedTurns++;
   }

   public void receiveUserWantRethrow() {
      throwDices();
   }

   public Boolean finished() {
      return playedTurns==MAX_TURNS;
   }

   public Dices getSelectedDices() {
      return selectedDices;
   }

}
