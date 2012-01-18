package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dayatang.domain.AbstractEntity;

@Entity
@Table(name = "_teachers")
public class Teacher extends AbstractEntity{

	private static final long serialVersionUID = 1740056845338004384L;
	
	public void assign(AbstractTask task){
		task.setTeacher(this);
		task.save();
	}
	
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
