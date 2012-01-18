package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * 作业
 * 
 * @author zjzhai
 * 
 */
@Entity
@Table(name = "_tasks")
public abstract class AbstractTask extends AbstractEntity {

	private static final long serialVersionUID = 136643315497349816L;

	// 作业名
	private String name;

	// 所属课程
	private Course course;

	//分配作业的老师
	private Teacher teacher;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
