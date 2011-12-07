package com.kelkoo.yahtzee;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDicesForCategory {

	@Test
	public void testGet() {  
		DicesForCategory dicesForCategory = new DicesForCategory();
		assertThat(dicesForCategory.get(1), nullValue());
	}
	 
	@Test
	public void testGetNonNull() { 
		DicesForCategory dicesForCategory = new DicesForCategory();
		 
		dicesForCategory.set(new Dices(6, 6), 6);
		assertThat(dicesForCategory.get(6), equalTo(new Dices(6, 6)));
	}

}
