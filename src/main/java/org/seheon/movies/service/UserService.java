package org.seheon.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.seheon.movies.domain.Customer;
import org.seheon.movies.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getUserList(){
        return repository.findAll();
    }
    public String selectCustomer(String firstName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(repository.findByFirstName(firstName));
    }

    public void saveCustomer(String firstName, String lastName){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        repository.save(customer);
    }
}
