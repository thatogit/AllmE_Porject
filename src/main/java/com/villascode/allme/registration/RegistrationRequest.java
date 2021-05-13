package com.villascode.allme.registration;

import lombok.*;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final LocalDate dob;
    private final Integer mobileNumber;
    private final String password;


}
