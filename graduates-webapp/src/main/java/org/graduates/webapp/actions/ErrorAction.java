package org.graduates.webapp.actions;


public class ErrorAction extends BaseAction {

	private static final long serialVersionUID = 8194058827439698355L;

	private String url;
	
	private Long organizationId;
	
	public String execute() {
		return SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	
	
	
}
