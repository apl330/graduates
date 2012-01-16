package org.projects.graduates.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * 学校与学院的关联
 * @author zjzhai
 *
 */
@Entity
@Table(name="_college_schools")
public class CollegeSchool extends AbstractEntity {

	private static final long serialVersionUID = -3229525517907700883L;
	
	private School school;
	
	private Set<College> colleges;
	

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
