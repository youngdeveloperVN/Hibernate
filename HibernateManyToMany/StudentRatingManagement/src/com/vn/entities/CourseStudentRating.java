package com.vn.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="course_like")
public class CourseStudentRating implements Serializable {
	
	@EmbeddedId
	private CourseStudentRateKey id;
	
	private Integer rate;
	
	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "student_id")
	private Student student = new Student();
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	private Course course = new Course();
	
}
