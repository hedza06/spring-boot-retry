package com.springboot.retry.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    private static final long serialVersionUID = -20200110224600L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "exception", nullable = false)
    private String exceptionMessage;

    @Column(name = "retries")
    private Integer numberOfAttempts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    @Override
    public String toString()
    {
        return "Job{" +
                "id=" + id +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", numberOfAttempts=" + numberOfAttempts +
                '}';
    }
}
