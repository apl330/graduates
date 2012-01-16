package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 学校
 * @author zjzhai
 *
 */
@Entity
@Table(name="_schools")
public class School {

	// 学校所在区域，如北京市东城区
	private Area area;

	// 学校名称
	private String name;

	// 学校代码
	private String code;
	
}
