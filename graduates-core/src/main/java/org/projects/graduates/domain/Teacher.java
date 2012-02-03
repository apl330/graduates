package org.projects.graduates.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {

	private static final long serialVersionUID = -8319674534046524181L;

	@OneToMany(mappedBy = "teacher")
	private Set<Curriculum> curriculum;

	// 开设课程
	public void setUp(Curriculum curriculum) {
		curriculum.setTeacher(this);
		curriculum.setEnable(true);
		curriculum.save();
	}

	public void setUp() {

	}

	// 取消课程
	public void cancel(Curriculum curriculum) {
		curriculum.setEnable(false);
		curriculum.save();
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
