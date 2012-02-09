package org.graduates.webapp.actions;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;
import org.projects.graduates.Constants;
import org.projects.graduates.app.GradApplication;
import org.projects.graduates.app.SecurityApplication;
import org.projects.graduates.domain.User;
import org.projects.graduates.service.UserHolder;

import com.dayatang.domain.EntityRepository;
import com.dayatang.domain.InstanceFactory;
import com.dayatang.utils.WritableConfiguration;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = -1754469889670152640L;

	private static WritableConfiguration configuration;
	
	@Inject
	protected GradApplication gradApplication;

	@Inject
	protected SecurityApplication securityApplication;
	
	@Inject
	private UserHolder userHolder;
	
	@Inject
	private EntityRepository repository;
	
	private WritableConfiguration getConfiguration() {
		if (configuration == null) {
			configuration = InstanceFactory.getInstance(WritableConfiguration.class);
		}
		return configuration;
	}

	public void setConfiguration(WritableConfiguration configuration) {
		BaseAction.configuration = configuration;
	}


	public GradApplication getGradApplication() {
		return gradApplication;
	}

	public void setGradApplication(GradApplication gradApplication) {
		this.gradApplication = gradApplication;
	}

	public SecurityApplication getSecurityApplication() {
		return securityApplication;
	}

	public UserHolder getUserHolder() {
		return userHolder;
	}

	public void setSecurityApplication(SecurityApplication securityApplication) {
		this.securityApplication = securityApplication;
	}

	public void setUserHolder(UserHolder userHolder) {
		this.userHolder = userHolder;
	}

	public String getCurrentUsername() {
		return userHolder.getUsername();
	}
	
	public User getCurrentUser() {
		return userHolder.getCurrentUser();
	}
	
	public String getBasePath() {
		return ServletActionContext.getRequest().getContextPath();
	}

	public String getDateFormat() {
		return getConfiguration().getString(Constants.DATE_FORMAT);
	}

	public String getTimeFormat() {
		return getConfiguration().getString(Constants.TIME_FORMAT);
	}

	public String getDateTimeFormat() {
		return getConfiguration().getString(Constants.DATE_TIME_FORMAT);
	}
	
	public String getNumberFormat() {
		return getConfiguration().getString(Constants.NUMBER_FORMAT);
	}
	
	public String getPercentageFormat() {
		return getConfiguration().getString(Constants.PERCENTAGE_FORMAT);
	}
	
	public int getTableRows() {
		return getConfiguration().getInt(Constants.TABLE_ROWS, 30);
	}
	
	public String getCharset() {
		return getConfiguration().getString(Constants.CHARSET, "utf-8");
	}
	
	public String getUploadDir() {
		return getConfiguration().getString(Constants.UPLOAD_DIR, "/tmp");
	}
	

		
	public EntityRepository getRepository() {
		if (repository == null) {
			repository = InstanceFactory.getInstance(EntityRepository.class);
		}
		return repository;
	}

	public void setRepository(EntityRepository repository) {
		this.repository = repository;
	}
}
