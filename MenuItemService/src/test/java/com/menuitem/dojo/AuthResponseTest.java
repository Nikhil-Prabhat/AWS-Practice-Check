
package com.menuitem.dojo;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.menuitem.client.AuthResponse;

public class AuthResponseTest {

	AuthResponse auth = new AuthResponse();
	AuthResponse auth1 = new AuthResponse("ad", "ad", true);

	@Test
	public void testUid() {
		auth.setUid("Uid");
		assertEquals(auth.getUid(), "Uid");
	}

	@Test
	public void testName() {
		auth.setName("Name");
		assertEquals(auth.getName(), "Name");
	}

	@Test
	public void testIsValid() {
		auth.setValid(true);
		assertEquals(auth.isValid(), true);
	}

}
