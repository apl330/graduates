package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

/**
 * 作业
 * @author zjzhai
 *
 */
@Entity
@Table(name = "_tasks")
public class Task extends AbstractEntity {

	private static final long serialVersionUID = 136643315497349816L;

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
