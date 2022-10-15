package org.commonmodels.response;

import lombok.Getter;
import lombok.Setter;
import org.commonmodels.entity.Subject;

@Getter
@Setter
public class SubjectResponse {

	private Long id;
	
	private String subjectName;

	private Double marksObtained;
	
	public SubjectResponse (Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject.getMarksObtained();
	}
}
