package org.graduates.webapp.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.projects.graduates.domain.User;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "web")
@Action(results = { @Result(name = ActionSupport.SUCCESS, type = "json") })
public class ExistUserAction extends BaseAction {

	private static final long serialVersionUID = -2807286441940718845L;

	private boolean exist = false;
	private User user;

	public String execute() {

		if (user != null && User.exist(user)) {
			user = User.findByNamePasswd(user.getName(), user.getPasswd());
			pushUserInSession(user);
			exist = true;
		}
		return ActionSupport.SUCCESS;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
