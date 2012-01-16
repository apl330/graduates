package org.projects.graduates.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

@Entity
@Table(name= "_clasz_students")
public class Clasz_Student extends AbstractEntity{

	private static final long serialVersionUID = -6329618103297613990L;
	
	private Clasz clasz;
	private Set<Student> students;
	
	
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
