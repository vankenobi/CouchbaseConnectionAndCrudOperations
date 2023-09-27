package org.example.Model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String membershipLevel;


}
