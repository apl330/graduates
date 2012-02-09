package org.projects.graduates.app.impl;

import org.projects.graduates.app.SecurityApplication;
import org.projects.graduates.domain.User;



public class SecurityApplicationImpl implements SecurityApplication {

	public void saveUser(User user) {
		user.save();
	}

	public void removeUser(User user) {
		user.remove();
	}

}
