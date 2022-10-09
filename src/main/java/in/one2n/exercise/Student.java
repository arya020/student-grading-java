package in.one2n.exercise;

import java.util.jar.Attributes.Name;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Student {

    
    private String firstname;
    private String lastname;
    private String university;
    private Double test1Score;
    private Double test2Score;
    private Double test3Score;
    private Double test4Score;

    // computed fields
    private Double finalScore;
    private Grade grade;

    public Student(String firstname, String lastname, String university) {
        // TODO: add your implementation here
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;

    }

    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
        // TODO: add your implementation here
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
        this.test1Score = test1Score;
        this.test2Score = test2Score;
        this.test3Score = test3Score;
        this.test4Score = test4Score;

    }

    public String getUniversity() {
        return university;
    }

    public Double getFinalScore() {
        // TODO: add your implementation here
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public Grade getGrade() {
        // TODO: add your implementation here
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Double getTest1Score() {
        return test1Score;
    }

    public Double getTest2Score() {
        return test2Score;
    }

    public Double getTest3Score() {
        return test3Score;
    }

    public Double getTest4Score() {
        return test4Score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return new EqualsBuilder()
                .append(firstname, student.firstname)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstname)
                .toHashCode();
    }

}

