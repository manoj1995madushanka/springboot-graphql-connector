package com.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import org.commonmodels.entity.Subject;
import com.graphql.enums.SubjectNameFilter;
import org.commonmodels.response.StudentResponse;
import org.commonmodels.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    // each method of resolver should be public
    // this is student to subject edge
    // because we're traversing though student to subject node
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse,
                                                     SubjectNameFilter subjectNameFilter) {

        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if (subjectNameFilter.name().equalsIgnoreCase("All")) {
                    learningSubjects.add(new SubjectResponse(subject));
                } else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }

        return learningSubjects;
    }

    /**
     * logic for generate fullName
     */
    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
