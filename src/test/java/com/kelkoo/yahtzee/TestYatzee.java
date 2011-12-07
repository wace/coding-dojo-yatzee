package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestYatzee {

	@Mock
	private DiceLauncher diceLauncher;
	@Mock
	User user;
	private Yatzee yatzee;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		yatzee = new Yatzee(diceLauncher, user);
	}

	@Test
	public void ensureUserKnowsYatzee() throws Exception {
		verify(user).playTo(yatzee);
	}

	@Test
	public void startsByLaunchingDices() throws Exception {
		when(diceLauncher.launch()).thenReturn(new Dices(1, 1, 2, 2, 5));

		yatzee.start();

		verify(user).notifyDicesLaunch(1, 1, 2, 2, 5);
	}

	@Test
	public void relaunchDicesIfUserWantRethrow() throws Exception {
		when(diceLauncher.launch()).thenReturn(new Dices(1, 2));

		yatzee.notifyUserWantRethrow();

		verify(user).notifyDicesLaunch(1, 2);
	}

	@Test
	public void testTurnFinishedAfterThreeRolls() {
		when(diceLauncher.launch()).thenReturn(new Dices(1, 2, 1, 5, 6))
				.thenReturn(new Dices(1, 4, 3)).thenReturn(new Dices(1));
		yatzee.notifyUserChoice(1, 1);
		assertThat("it is the round number 1", yatzee.turnFinished(), is(false));
		yatzee.notifyUserChoice(1);
		assertThat("it is the round number 2", yatzee.turnFinished(), is(false));
		yatzee.notifyUserChoice(1);
		assertThat("it is the round number 3", yatzee.turnFinished(), is(true));
	}

	@Test
	public void computeScoreWithOneLaunch() {
		yatzee.notifyUserChoice(1, 1);

		assertThat(yatzee.score(), is(2));
	}

	@Test
	public void computeScoreWithTwoLaunch() {
		yatzee.notifyUserChoice(1, 1);
		yatzee.notifyUserChoice(1, 1);

		assertThat(yatzee.score(), is(4));
	}

	@Test
	public void computeScoreWithThreeLaunch() {
		yatzee.notifyUserChoice(1, 1);
		yatzee.notifyUserChoice(1, 1);
		yatzee.notifyUserChoice(1);

		assertThat(yatzee.score(), is(5));
	}

	@Test
	public void testGetRound() {
		when(diceLauncher.launch()).thenReturn(new Dices(1, 2, 1, 5, 6))
				.thenReturn(new Dices(1, 4, 3)).thenReturn(new Dices(1));
		yatzee.notifyUserChoice();
		assertThat(yatzee.getRound(), is(1));
		yatzee.notifyUserChoice();
		assertThat(yatzee.getRound(), is(2));
		yatzee.notifyUserChoice();
		assertThat(yatzee.getRound(), is(3));
	}

	@Test
	public void testScoreforCategory() {
		yatzee.notifyUserChoice(6, 6);
		yatzee.notifyUserChoice(6);
		yatzee.notifyUserChoice();
		assertThat(yatzee.scoreforCategory(6), equalTo(18));
	}


}
