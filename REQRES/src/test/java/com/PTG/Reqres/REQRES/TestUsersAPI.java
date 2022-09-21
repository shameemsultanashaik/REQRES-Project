package com.PTG.Reqres.REQRES;

import org.testng.annotations.Test;

public class TestUsersAPI {
	@Test
	public void testUserDetails() {
		Users us = new Users();
		us.GetUsersDetails();

	}

	@Test
	public void testSingleUser() {
		Users us = new Users();

		us.getSingleUser(2);

	}

	@Test
	public void getSingleUserNotfound() {
		Users us = new Users();

		us.getSingleUserNotfound(23);
	}

	@Test
	public void getListResource() {
		Users us = new Users();

		us.getListResource();
	}
	@Test
	public void postUser() {
		Users us = new Users();
		us.postUser();
		
	}
	@Test
	public void putUser() {
		Users us = new Users();
		us.putUser();
		
	}
	@Test
	public void deleteUser() {
		Users us = new Users();
		us.deleteUser();;
}
}
