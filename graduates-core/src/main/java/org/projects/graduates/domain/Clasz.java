package org.projects.graduates.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dayatang.domain.AbstractEntity;

/**
 * 班级概念的抽象
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "classes")
@DiscriminatorColumn(name = "category", discriminatorType = DiscriminatorType.STRING)
public abstract class Clasz extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	// 开班时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	private Person creator;

	@Enumerated(EnumType.STRING)
	private ClassState state;

	@ManyToMany
	@JoinTable(name = "cour_clas", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public ClassState getState() {
		return state;
	}

	public void setState(ClassState state) {
		this.state = state;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
