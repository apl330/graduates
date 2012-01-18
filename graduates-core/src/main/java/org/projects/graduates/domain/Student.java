package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * 学生
 * 
 * @author zjzhai
 * 
 */
@Entity
@Table(name="_students")
public class Student extends AbstractEntity {

	private static final long serialVersionUID = 1571982779625761898L;

	// 真实姓名
	private String realName;

	// 昵称
	private String nickName;

	// 年龄
	private int age;

	
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
