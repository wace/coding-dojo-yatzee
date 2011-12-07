package com.kelkoo.yahtzee;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestUser {
	
	@Mock Yatzee yatzee;
	User user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.playTo(yatzee);
	}

	@Test
	public void whenUserSelectDicesThenYatzeeIsNotified() {
		user.selectDices(1, 3);
		
		verify(yatzee).notifyUserChoice(1, 3);
	}

	@Test
	public void whenUserWantRethrowThenYatzeeIsNotified() {
		user.wantRethrow();
		
		verify(yatzee).notifyUserWantRethrow();
	}

	@Test
	public void testSelectCategory() {
		user.selectCategory(6);
		verify(yatzee).notifyUserSelectedCategory(6);
	}
}
