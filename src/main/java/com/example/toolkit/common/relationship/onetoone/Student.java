package com.example.toolkit.common.relationship.onetoone;

import javax.persistence.*;

/**
 * @author chenpenghui
 * @date 2020/4/23
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Tuition tuition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }
}
