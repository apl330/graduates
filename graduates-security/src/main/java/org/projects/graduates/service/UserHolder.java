package org.projects.graduates.service;

import org.projects.graduates.domain.User;




/**
 * 获取当前登录用户.如果没登录则返回null。
 * @author yyang
 *
 */
public interface UserHolder {
	String getUsername();
	User getCurrentUser();
}
