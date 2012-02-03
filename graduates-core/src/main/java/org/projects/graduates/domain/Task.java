package org.projects.graduates.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.dayatang.domain.AbstractEntity;

@Entity
public class Task extends AbstractEntity {
	private static final long serialVersionUID = -6068319628131518494L;
	// 作业名
	private String name;
	// 必须完成时间
	private Date mustBeCompleted;
	// 发布时间
	private Date releaseTime;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMustBeCompleted() {
		return mustBeCompleted;
	}

	public void setMustBeCompleted(Date mustBeCompleted) {
		this.mustBeCompleted = mustBeCompleted;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

}
