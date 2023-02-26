package org.seheon.movies.domain;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;
    @AfterEach
    void afterEach(){
        repository.deleteAll();
    }
    @Test
    void save(){
        // given
        Customer customer = new Customer();
        customer.setFirstName("Seho");
        customer.setLastName("Park");
        // when
        Customer savedCustomer = repository.save(customer);
        // then
        assertThat(savedCustomer).isEqualTo(customer);
    }
}
