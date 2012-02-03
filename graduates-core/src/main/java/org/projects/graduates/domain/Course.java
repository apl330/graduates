package org.projects.graduates.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * ¿Î³Ì
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "course")
public class Course extends AbstractEntity {

	private static final long serialVersionUID = -7984770532590404814L;

	private String name;

	private boolean enable;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@ManyToMany(mappedBy = "courses")
	private Set<Clasz> classes;

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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Clasz> getClasses() {
		return classes;
	}

	public void setClasses(Set<Clasz> classes) {
		this.classes = classes;
	}

}
