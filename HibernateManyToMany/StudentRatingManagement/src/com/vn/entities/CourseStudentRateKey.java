package com.vn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CourseStudentRateKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "course_id")
	private Integer courseId;

	@Column(name = "student_id")
	private Integer studentId;

}
