package org.commonmodels.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.commonmodels.entity.Student;

import java.util.List;

@Setter
@Getter
public class StudentResponse {

    private long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;

    private Student student;

    // we are not generating fullName in constructor because some consumers do not need fullName
    // so we move fullName generating logic to resolver
    private String fullName;

    public StudentResponse(Student student) {
        if (student != null) {
            this.student = student;
            this.id = student.getId();
            this.firstName = student.getFirstName();
            this.lastName = student.getLastName();
            this.email = student.getEmail();

            this.street = student.getAddress().getStreet();
            this.city = student.getAddress().getCity();

            /*if (student.getLearningSubjects() != null) {
                learningSubjects = new ArrayList<SubjectResponse>();
                for (Subject subject : student.getLearningSubjects()) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }*/
        }
    }

}
