package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.domain.QuerySettings;

@Entity
@Table(name = "grad_users")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 3903033950210699208L;

	private String name;

	private String passwd;

	
	public static boolean exist(User user){
		User result = getRepository().getSingleResult(QuerySettings.create(User.class).eq("name",	user.getName()).eq("passwd", user.getPasswd()));
		return result == null ? false : true;
	}
	
	public static User findByNamePasswd(User user){
		User result = getRepository().getSingleResult(QuerySettings.create(User.class).eq("name",	user.getName()).eq("passwd", user.getPasswd()));
		return result;
	}
	public static User findByNamePasswd(String name, String passwd) {
		User result = getRepository().getSingleResult(QuerySettings.create(User.class).eq("name",	name).eq("passwd", passwd));
		return result;
	}
	
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name).append(passwd).toHashCode();
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof User))
			return false;
		User castOther = (User) other;
		return new EqualsBuilder().append(name, castOther.name).append(passwd, castOther.passwd).isEquals();
	}

	public String toString() {
		return this.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


}
