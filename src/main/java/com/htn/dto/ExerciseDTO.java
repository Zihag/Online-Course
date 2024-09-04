/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.dto;

import java.util.Collection;
import java.util.Collection;
import java.util.Date;
/**
 *
 * @author DELL
 */

public class ExerciseDTO {
    private Integer id;
    private String title;
    private String description;
    private Short status;
    private Date dueDate;
    private Date createdAt;
    private Integer courseId; // Chỉ ID của Course
    private Collection<SubmissionDTO> submissionCollection;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Collection<SubmissionDTO> getSubmissionCollection() {
        return submissionCollection;
    }

    public void setSubmissionCollection(Collection<SubmissionDTO> submissionCollection) {
        this.submissionCollection = submissionCollection;
    }
}

