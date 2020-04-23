package com.example.toolkit.common.relationship.onetoone;

import javax.persistence.*;

/**
 * @author chenpenghui
 * @date 2020/4/23
 */
@Entity
@Table(name = "tuition")
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double fee;

    @JoinColumn(name = "student_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
