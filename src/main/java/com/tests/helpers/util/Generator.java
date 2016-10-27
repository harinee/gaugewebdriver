package com.tests.helpers.util;


import org.apache.commons.lang.RandomStringUtils;

public class Generator {
    public static String randomShortText() {
        String prefix = "generated-by-ft-";
        return prefix +randomText(10);
    }

    public static String randomLongText() {
        String prefix = "generated-by-ft-";
        int randomTextSize = 256-prefix.length();
        return prefix +randomText(randomTextSize);
    }

    public static String randomText(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
