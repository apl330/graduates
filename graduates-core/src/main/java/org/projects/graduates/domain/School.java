package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 学校-
 * @author zjzhai
 *
 */
@Entity
@Table(name="_schools")
public class School {
	//中文dddd言论
	private Area area;

	// 瀛︽牎鍚嶇О
	private String name;

	// 学校编号
	private String code;
	
}
