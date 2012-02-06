package org.projects.graduates.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dayatang.domain.ValueObject;

@Embeddable
public class CourseProfile implements ValueObject {

	private static final long serialVersionUID = -8110096580986610904L;

	public CourseProfile() {
	}

	@Temporal(TemporalType.DATE)
	private Date from;

	@Temporal(TemporalType.DATE)
	private Date to;

	@Enumerated(EnumType.STRING)
	private Week week;

	// µÚ¼¸½Ú
	private int section;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

}
