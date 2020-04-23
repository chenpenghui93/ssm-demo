package com.example.toolkit.common.relationship;

import com.example.toolkit.common.relationship.onetoone.Student;
import com.example.toolkit.common.relationship.onetoone.Tuition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * https://dev.to/jhonifaber/hibernate-onetoone-onetomany-manytoone-and-manytomany-8ba
 *
 * @author chenpenghui
 * @date 2020/4/23
 */
public class RelationshipTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void check_sql_statement_when_persisting_in_one_to_one_bidirectional() {
        Student student = new Student();
        student.setName("Ana");

        Tuition tuition = new Tuition();
        tuition.setFee(200.0);
        tuition.setStudent(student);

        student.setTuition(tuition);

        entityManager.persist(student);
    }
}
