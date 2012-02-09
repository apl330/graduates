package org.graduates.webapp.actions;


import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 */
@Results({ @Result(name = "success", type = "redirect", location = "personalworkstation/personal-workstation-manage.action") })
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = 8835828085195385611L;

	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		if (session == null) {
			session = ActionContext.getContext().getSession();
		}
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

}
