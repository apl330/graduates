package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ѧУ-
 * @author zjzhai
 *
 */
@Entity
@Table(name="_schools")
public class School {
	//����dddd����
	private Area area;

	// 学校名称
	private String name;

	// ѧУ���
	private String code;
	
}
