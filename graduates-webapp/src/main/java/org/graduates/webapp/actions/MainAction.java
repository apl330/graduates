package org.graduates.webapp.actions;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = ActionSupport.LOGIN, location = "login.action", type = "redirectAction") })
public class MainAction extends BaseAction {
	private static final long serialVersionUID = -2904289710672514313L;

	public String execute() {
		return SUCCESS;
	}

}
