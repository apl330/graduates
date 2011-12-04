package org.graduates.webapp.actions;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import org.apache.struts2.convention.annotation.Result;
import org.projects.graduates.domain.Feel;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "web")
@Action(results = { @Result(name = ActionSupport.SUCCESS, type = "json"), @Result(name = ActionSupport.LOGIN, type = "redirectAction", location = "login.action") })
public class SaveFeelAction extends BaseAction {

	private static final long serialVersionUID = -2807286441940718845L;

	private Feel feel;

	private boolean success = false;

	public String execute() {
		if (null == pullUserFromSession()) {
			return ActionSupport.LOGIN;
		}
		if (feel != null && StringUtils.isNotEmpty(feel.getText())) {
			feel.setDate(new Date());
			getGradApplication().save(feel);
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

	public Feel getFeel() {
		return feel;
	}

	public void setFeel(Feel feel) {
		this.feel = feel;
	}

}
