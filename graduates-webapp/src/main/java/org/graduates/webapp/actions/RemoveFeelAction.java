package org.graduates.webapp.actions;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import org.apache.struts2.convention.annotation.Result;
import org.projects.graduates.domain.Feel;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "web")
@Action(results = { @Result(name = ActionSupport.SUCCESS, type = "json"), @Result(name = ActionSupport.LOGIN, type = "redirectAction", location = "login.action") })
public class RemoveFeelAction extends BaseAction {

	private static final long serialVersionUID = -2807286441940718845L;

	private long id = 0L;

	private boolean success = false;

	public String execute() {
		if (null == pullUserFromSession()) {
			return ActionSupport.LOGIN;
		}
		Feel feel = Feel.get(Feel.class, id);
		if(null != feel){
			getGradApplication().remove(feel);
			success = true;
		}
		return ActionSupport.SUCCESS;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
