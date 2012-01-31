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
	//����
	private Area area;

	// 学校名称
	private String name;

	// 学校代码
	private String code;
	
}
