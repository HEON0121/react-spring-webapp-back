package org.seheon.movies.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public List<String> items;

//    @DocumentReference
//    private List<String> reviewIds;
//    public Customer() {}

//    public Customer(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "Customer[id=%s, firstName='%s', lastName='%s']",
//                id, firstName, lastName);
//    }
}
