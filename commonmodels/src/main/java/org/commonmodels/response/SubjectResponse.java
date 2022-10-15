package org.commonmodels.response;

import lombok.*;
import org.commonmodels.entity.Subject;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
