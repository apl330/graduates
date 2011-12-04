package org.graduates.webapp.actions;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({ @Result(name = Action.SUCCESS, location = "main.action", type = "redirectAction")	})
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = -4892184149251385878L;

	public String execute() {
		return Action.SUCCESS;
	}

}
