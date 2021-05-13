package com.villascode.allme.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Entity
@Table
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "account_sequnce",
            sequenceName = "account_sequnce",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequnce"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String password;
    private LocalDate dob;
    @Transient
    private Integer age;
    private Integer mobileNumber;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean isLocked = false;
    private Boolean isEnable = false;

    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String gender,
                   LocalDate dob,
                   Integer mobileNumber,
                   String password,
                   AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.appUserRole = appUserRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}
