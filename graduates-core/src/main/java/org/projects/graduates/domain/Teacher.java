package org.projects.graduates.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {

	private static final long serialVersionUID = -8319674534046524181L;

	@OneToMany(mappedBy = "teacher")
	private Set<Course> courses;

	// ¿ª¿Î
	public void setUp(Course course) {
		if (null == courses) {
			courses = new HashSet<Course>();
		}
		courses.add(course);
		this.save();
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
