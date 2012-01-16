package org.projects.graduates.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * 选修
 * 
 * @author zjzhai
 * 
 */
@Entity
@Table(name = "_electives")
public class Elective extends AbstractEntity {

	private static final long serialVersionUID = 6129658116377128865L;

	private Student student;
	private Date electiveTime;
	private Set<Course> courses;

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
