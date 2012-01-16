package org.graduates.webapp.actions;

import javax.inject.Inject;

import org.projects.graduates.app.GradApplication;

import com.dayatang.domain.EntityRepository;
import com.dayatang.domain.InstanceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 3084760228983271007L;

	@Inject
	protected GradApplication gradApplication;

	@Inject
	private EntityRepository repository;

	/**
	 * 将user写入session
	 * @param user
	 */
	public GradApplication getGradApplication() {
		if (null == gradApplication) {
			gradApplication = InstanceFactory.getInstance(GradApplication.class);
		}
		return gradApplication;
	}

	public EntityRepository getRepository() {
		if (null == repository) {
			repository = InstanceFactory.getInstance(EntityRepository.class);
		}
		return repository;
	}

	public void setRepository(EntityRepository repository) {
		this.repository = repository;
	}

	public void setGradApplication(GradApplication gradApplication) {
		this.gradApplication = gradApplication;
	}
	

}
