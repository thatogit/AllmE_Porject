package com.villascode.allme.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //TO DO REGEX TO VALIDATE EMAIL
        return true;
    }
}
