package com.hibernatesdemo.learning6.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Annotate the class as an entity and map to DB table
 * define the fields
 * annotate fields with db columns names
 * create constructor
 * generate getter/ setter methods
 * generate toString() method
 * 
 */


@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	
	/*
	 * 
	 * The below instructor mappedBy is referring to instructorDetail in instructor class
	 * 
	 */
	@OneToOne(mappedBy="instructorDetail", 
						cascade= {CascadeType.DETACH,
								  CascadeType.MERGE,
								  CascadeType.PERSIST,
								  CascadeType.REFRESH})
	private Instructor instructor;
	
	public InstructorDetail() {
	}
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public String toString() {
		return "Instructor Details [id=" + id + ", youtube_channel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
