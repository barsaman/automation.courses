package com.skillup.automation.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomEmail {

    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    public static String randomEmail() {
        String randomEmail = nextSessionId() + "@gmail.com";
        return randomEmail;
    }
}
