package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Student assignedStudent;
	private Date startTime;
	private Date endTime;
	private Subject subject;
	private Tutor tutor;
	private ApptType apptType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getAssignedStudent() {
		return assignedStudent;
	}
	public void setAssignedStudent(Student assignedStudent) {
		this.assignedStudent = assignedStudent;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public ApptType getApptType() {
		return apptType;
	}
	public void setApptType(ApptType apptType) {
		this.apptType = apptType;
	}
	
	
}
