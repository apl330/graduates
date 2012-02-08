package org.graduates.webapp.actions;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;
import org.projects.graduates.app.GradApplication;

import com.dayatang.domain.EntityRepository;
import com.dayatang.domain.InstanceFactory;
import com.dayatang.projmgmt.Constants;
import com.dayatang.projmgmt.application.ProjApplication;
import com.dayatang.projmgmt.application.SecurityApplication;
import com.dayatang.projmgmt.domain.Assignment;
import com.dayatang.projmgmt.domain.Dictionary;
import com.dayatang.projmgmt.domain.DictionaryCategory;
import com.dayatang.projmgmt.domain.Organization;
import com.dayatang.projmgmt.domain.OrganizationCategory;
import com.dayatang.projmgmt.domain.Person;
import com.dayatang.projmgmt.domain.User;
import com.dayatang.projmgmt.service.UserHolder;
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
	
	private Map<DictionaryCategory, Map<String, String>> dictionaryMap = new HashMap<DictionaryCategory, Map<String,String>>();

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

	public void setProjApplication(ProjApplication projApplication) {
		this.projApplication = projApplication;
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
	
	public Person getCurrentPerson() {
		return Person.getByUsername(getCurrentUsername());
	}
	
	public String getPersonName() {
		Person person = getCurrentPerson();
		return person == null ? getCurrentUsername() : person.getName();
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
	
	public String getDictionary(DictionaryCategory category, String key) {
		Map<String, String> dictionaries = dictionaryMap.get(category);
		if (dictionaries == null) {
			dictionaries = Dictionary.getMap(category);
			dictionaryMap.put(category, dictionaries);
		}
		return dictionaries.get(key);
	}
	
	public String getProjectTypeName(String key) {
		return getDictionary(DictionaryCategory.PROJECT_TYPE, key);
	}

	public Set<Organization> getResponsibleOrganizations() {
		return Assignment.findOrganizationScopeOf(getCurrentPerson());
	}
	
	/**
	 * 判断用户是否只管理一个事业部
	 * @return
	 */
	public boolean getIsOnlyOneDivisionScope() {	
		int scopeSize = getDivisionScopes().size();
		return scopeSize > 0 && scopeSize == 1 && getTheOnlyOrganizationScope().getCategory().equals(OrganizationCategory.DIVISION);
	}

	/**
	 * 判断是否用户只管理一个项目部
	 * @return
	 */
	public boolean getIsOnlyOneProjectDepartmentScope() {
		int scopeSize = getProjectDepartmentScopes().size();
		return scopeSize > 0 && scopeSize == 1 && getTheOnlyOrganizationScope().getCategory().equals(OrganizationCategory.PROJECT_DEPARTMENT);
	}

	/**
	 * 获取用户唯一管理的部门范围
	 * @return
	 */
	public Organization getTheOnlyOrganizationScope() {
		return getResponsibleOrganizations().iterator().next();
	}
	
	/**
	 * 获取用户所管理的事业部范围
	 * @return
	 */
	public Set<Organization> getDivisionScopes() {
		Set<Organization> results = new HashSet<Organization>();
		
		for (Organization organization : getResponsibleOrganizations()) {
			if (organization.getCategory().equals(OrganizationCategory.PROJECT_DEPARTMENT)) {
				continue;
			}
			if (organization.getCategory().equals(OrganizationCategory.HOST)) {
				results.addAll(organization.getChildren());
				return results;
			}
			
			results.add(organization);
		}
		
		return results;
	}
	
	/**
	 * 获取用户所管理的项目部范围
	 * @return
	 */
	public Set<Organization> getProjectDepartmentScopes() {
		Set<Organization> results = new HashSet<Organization>();
		
		for (Organization organization : getResponsibleOrganizations()) {
			if (organization.getCategory().equals(OrganizationCategory.HOST)) {
				for (Organization division : organization.getChildren()) {
					results.addAll(division.getChildren());
				}
				return results;
			}
			
			if (organization.getCategory().equals(OrganizationCategory.DIVISION)) {
				results.addAll(organization.getChildren());
				continue;
			}
			
			results.add(organization);
		}
		
		return results;
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
