package com.cg.ems.Bean;

import java.sql.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Entity(name="ProjectCode")
public class ProjectCodeModule {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	@SequenceGenerator(name="seq", initialValue=100, allocationSize=1000)
	int projectId;
	
	@NotNull
	String projectDescription;
	
	
	Date projectStartDate;
	
	Date projectEndDate;
	
	
	// Validation of Date Part
	@AssertTrue public boolean isValidRange()
	{
		try {
		return ( projectEndDate.compareTo(projectStartDate) >= 0);
	}catch (Exception e) {
		System.out.println("ENTER VALID DATE");
	}
	return false;
			
	}	
	
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}



	@Override
	public String toString() {
		return "ProjectCodeModule [projectId=" + projectId + ", projectDescription=" + projectDescription
				+ ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + "]";
	}
	
	

	
	
	
	
	

}
