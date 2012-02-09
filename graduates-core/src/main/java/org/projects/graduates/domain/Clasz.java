package org.projects.graduates.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dayatang.domain.AbstractEntity;

/**
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@ManyToOne
	@JoinColumn(name = "creator")
	private Person creator;

	@Enumerated(EnumType.STRING)
	private ClassState state;

	@ManyToMany
	@JoinTable(name = "cour_clas", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courseList;

	public void addCourses(Course... courses) {
		if(null == courseList) {
			courseList = new HashSet<Course>();
		}
		courseList.addAll(createCourseSet(courses));
	}

	private Set<Course> createCourseSet(Course... courses){
		Set<Course> results = new HashSet<Course>();
		if(courses!=null && courses.length!=0){
			for(Course course : courses){
				results.add(course);
			}
		}
		return results;
	}
	
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

	public Set<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}

}
