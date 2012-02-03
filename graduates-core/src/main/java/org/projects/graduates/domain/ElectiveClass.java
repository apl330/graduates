package org.projects.graduates.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.dayatang.domain.AbstractEntity;

/**
 * 选修班 由老师开设
 * @author Administrator
 *
 */
@Entity
@DiscriminatorValue(value = "elective_class")
public class ElectiveClass extends AbstractEntity{

	private static final long serialVersionUID = -2670943249854053688L;

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
