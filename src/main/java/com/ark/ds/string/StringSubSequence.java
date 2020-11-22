package com.ark.ds.string;

/**
 * <p> Class to implement logic for checking whether a given sub sequence exists in a given String using
 * Brute Force Solution</p>
 *
 * @author AbdulR.
 */
public enum StringSubSequence {
    INSTANCE;

    public boolean checkSubSequence(String str, String sub) {
        validate(str, sub);
        int strLen = str.length();
        int subLen = sub.length();
        if (subLen > strLen) return false; //As sub string length must be <= original string length
        for (int index = 0; index <= strLen - subLen; index++) {
            int cnt = 0;
            while (cnt < subLen && sub.charAt(cnt) == str.charAt(index + cnt)) {
                cnt++; //Matching Window found
            }
            if (cnt == subLen) return true;
        }
        return false;
    }

    private void validate(String str, String sub) {
        validate(str);
        validate(sub);
    }

    private void validate(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid String");
        }
    }
}
