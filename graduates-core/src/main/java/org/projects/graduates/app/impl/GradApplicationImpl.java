package org.projects.graduates.app.impl;

import org.projects.graduates.app.GradApplication;

import com.dayatang.domain.AbstractEntity;

public class GradApplicationImpl implements GradApplication {

	public void save(AbstractEntity entity) {
		entity.save();
	}

	public void remove(AbstractEntity entity) {
		entity.remove();
	}


}
