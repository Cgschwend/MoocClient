package com.example.moocClient;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meetup {

    private List<Group> results = new ArrayList<>();

    private String count;

    public List<Group> getResults() {
        return results;
    }

    public void setResults(List<Group> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
