package org.graduates.webapp.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.projects.graduates.domain.Feel;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = ActionSupport.LOGIN, location = "login.action", type = "redirectAction") })
public class MainAction extends BaseAction {
	private static final long serialVersionUID = -2904289710672514313L;

	private List<Feel> feels = new ArrayList<Feel>();

	public String execute() {
		if (null == pullUserFromSession()) {
			return ActionSupport.LOGIN;
		}
		feels.addAll(Feel.findAllAsc());
		System.out.println(feels);
		return ActionSupport.SUCCESS;
	}

	public List<Feel> getFeels() {
		return feels;
	}

	public void setFeels(List<Feel> feels) {
		this.feels = feels;
	}

}
