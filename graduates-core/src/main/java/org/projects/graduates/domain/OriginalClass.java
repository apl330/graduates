package org.projects.graduates.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * ÉýÑ§°à
 * 
 * @author Administrator
 * 
 */
@Entity
@DiscriminatorValue(value = "original")
public class OriginalClass extends Clasz {

	private static final long serialVersionUID = -4110000570524632978L;

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
