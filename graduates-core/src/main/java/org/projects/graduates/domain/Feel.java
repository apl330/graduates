package org.projects.graduates.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.domain.QuerySettings;

@Entity
@Table(name = "grad_feels")
public class Feel extends AbstractEntity {

	private static final long serialVersionUID = -6787598244640826593L;

	private String text;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

	public static List<Feel> findAllAsc() {
		List<Feel> results = new ArrayList<Feel>();
		results.addAll(getRepository().find(QuerySettings.create(Feel.class).asc("date")));
		return results;
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(text).append(date).toHashCode();
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Feel))
			return false;
		Feel castOther = (Feel) other;
		return new EqualsBuilder().append(text, castOther.text).append(date, castOther.date).isEquals();
	}

	@Override
	public String toString() {
		return text + date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
