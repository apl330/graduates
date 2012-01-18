package org.projects.graduates.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.dayatang.domain.AbstractEntity;

@Entity
@Table(name = "dictionaries", uniqueConstraints = { @UniqueConstraint(columnNames = { "category", "serial_number" }), @UniqueConstraint(columnNames = { "category", "text" }) })
public class Dictionary extends AbstractEntity {

	@NotNull
	@Column(name = "serial_number", nullable = false)
	private String serialNumber;

	@NotNull
	private String text;

	@Column(name = "parent_sn")
	private String parentSn;

	@Column(name = "sort_order")
	private int sortOrder;

	@NotNull
	@Enumerated(EnumType.STRING)
	private DictionaryCategory category;

	@Column(length = 256)
	private String remark;

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
