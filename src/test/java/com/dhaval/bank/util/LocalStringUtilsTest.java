package com.dhaval.bank.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocalStringUtilsTest {

    @Test
    public void test_isBlank_blankString() {
        String blankString = "";
        Assert.assertTrue(LocalStringUtils.isBlank(blankString));
    }

    @Test
    public void test_isBlank_nonBlankString() {
        String blankString = "abcd";
        Assert.assertFalse(LocalStringUtils.isBlank(blankString));
    }

    @Test
    public void test_isNotBlank_blankString() {
        String NonBlankString = "";
        Assert.assertFalse(LocalStringUtils.isNotBlank(NonBlankString));
    }

    @Test
    public void test_isNotBlank_nonBlankString() {
        String NonBlankString = "abcd";
        Assert.assertTrue(LocalStringUtils.isNotBlank(NonBlankString));
    }
}