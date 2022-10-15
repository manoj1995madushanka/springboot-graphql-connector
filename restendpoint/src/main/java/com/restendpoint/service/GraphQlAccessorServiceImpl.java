package com.restendpoint.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.commonmodels.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;


@Service
public class GraphQlAccessorServiceImpl implements GraphQlAccessorService{
    @Autowired
    private ObjectMapper objectMapper;

    private String url = "http://localhost:8080/student-service";
    private String query = "{\n" +
            "  student(id:2){\n" +
            "    firstName,\n" +
            "    lastName,\n" +
            "    city,\n" +
            "    email,\n" +
            "    fullName,\n" +
            "    learningSubjects(subjectNameFilter:MongoDB){\n" +
            "      subjectName,\n" +
            "      id,\n" +
            "      marksObtained\n" +
            "    }\n" +
            "  }\n" +
            "}&variables={}";

    public StudentResponse getStudent(long id) throws JsonProcessingException {
        HttpResponse httpResponse = null;
        try {
            httpResponse = callGraphQLService();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String actualResponse = null;
        try {
            actualResponse = IOUtils.toString(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objectMapper.readValue(actualResponse, StudentResponse.class);
    }

    HttpResponse callGraphQLService()
            throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        URI uri = new URIBuilder(request.getURI())
                .addParameter("query", query)
                .build();
        request.setURI(uri);
        return client.execute(request);
    }
}
