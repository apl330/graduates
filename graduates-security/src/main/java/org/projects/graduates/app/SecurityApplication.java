package org.projects.graduates.app;


import org.projects.graduates.domain.User;

import com.dayatang.annotations.Transactional;

public interface SecurityApplication {
	
	@Transactional
	void saveUser(User user);
	
	@Transactional
	void removeUser(User user);

}
