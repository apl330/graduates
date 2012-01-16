package org.projects.graduates.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

@Entity
@Table(name="_clasz_college")
public class ClaszCollege extends AbstractEntity {
	private static final long serialVersionUID = -4851061674137567489L;

	private College college;
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

}
