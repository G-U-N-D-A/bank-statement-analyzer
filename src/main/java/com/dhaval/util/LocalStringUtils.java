package com.dhaval.util;

import org.apache.commons.lang3.StringUtils;

public class LocalStringUtils {
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }
}
