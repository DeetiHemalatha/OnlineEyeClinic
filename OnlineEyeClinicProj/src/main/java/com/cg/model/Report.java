package com.cg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
/**
 * 
 *mapping Report Table with database
 *
 */
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="report_seq")
	@SequenceGenerator(name="report_seq",sequenceName="report_seq",allocationSize=1)
	/**
	 * mapping the column Report_id
	 */
	@Column(name="Report_Id")
	 private int reportId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	/**
	 * mapping the column Date_Of_Report
	 */
	@Column(name="Date_Of_Report")
private Date dateOfReport;
	/**
	 * mapping the column Date_Of_Report
	 */
	@NotBlank(message="Description cannot be blank")
	@Column(name="Description_Of_Report")
private String description;
	/**
	 * mapping the column Date_Of_Report
	 */
	@NotBlank(message="Visual acuity cannot be blank")
	@Column(name="visual_Acuity")
private String visualAcuity;
	/**
	 * mapping the column Date_Of_Report
	 */
	@Column(name="visual_Acuity_For_Near")
private String visualAcuityForNear;
	/**
	 * mapping the column Date_Of_Report
	 */
	@Column(name="visual_Acuity_For_Distance")
private String visualAcuityForDistance;
	/**
	 * Mapping Test table with the reference of patient_Id

	 */
	@OneToOne
	@JoinColumn(name="patient_Id")
private Patient patient; //object reference variable of Patient class
	/**
	 * Mapping Test table with the reference of test_Id
	 */
	@OneToOne
	@JoinColumn(name="test_Id")
private Test test; //object reference variable of Test class
	/**
	 * 
	 *Getters AND Setters
	 */
	public int getReportId() {
		return reportId;
	}
	public void setReportId(final int reportId) {
		this.reportId = reportId;
	}
	public Date getDateOfReport() {
		return dateOfReport;
	}
	/**
	 * 
	 * @param dateOfReport
	 */
	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(final String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getVisualAcuityForNear() {
		return visualAcuityForNear;
	}
	/**
	 * 
	 * @param visualAcuityForNear
	 */
	public void setVisualAcuityForNear(final String visualAcuityForNear) {
		this.visualAcuityForNear = visualAcuityForNear;
	}
	public String getVisualAcuityForDistance() {
		return visualAcuityForDistance;
	}
	/**
	 * 
	 * @param visualAcuityForDistance
	 */
	public void setVisualAcuityForDistance(String visualAcuityForDistance) {
		this.visualAcuityForDistance = visualAcuityForDistance;
	}
	public Test getTest() {
		return test;
	}
	public Patient getPatient() {
	 return patient;
	}
	/**
	 * @param reportId
	 * @param dateOfReport
	 * @param description
	 * @param visualAcuity
	 * @param visualAcuityForNear
	 * @param visualAcuityForDistance
	 * @param patient
	 * @param test
	 */
	public Report(final int reportId,final Date dateOfReport,final String description,final String visualAcuity,
			 final String visualAcuityForNear,final String visualAcuityForDistance, Patient patient, Test test) {
		//super();
		this.reportId = reportId;
		this.dateOfReport = dateOfReport;
		this.description = description;
		this.visualAcuity = visualAcuity;
		this.visualAcuityForNear = visualAcuityForNear;
		this.visualAcuityForDistance = visualAcuityForDistance;
		this.patient = patient;
		this.test = test;
	}
	/**
	 * Empty default constructor
	 */
public Report() {	
}
}
