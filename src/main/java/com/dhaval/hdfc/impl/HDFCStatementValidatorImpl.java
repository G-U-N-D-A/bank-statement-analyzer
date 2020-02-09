package com.dhaval.hdfc.impl;

import com.dhaval.hdfc.api.HDFCStatementValidator;
import com.dhaval.util.LocalStringUtils;

public class HDFCStatementValidatorImpl implements HDFCStatementValidator {
    @Override
    public boolean isValidTransactionEntry(String entry) {
        return LocalStringUtils.isNotBlank(entry)
                && isNotHeaderEntry(entry);
    }

    private boolean isNotHeaderEntry(String entry) {
        return LocalStringUtils.isNotBlank(entry)
                && !isHeaderEntry(entry);
    }

    private boolean isHeaderEntry(String entry) {
        return LocalStringUtils.isNotBlank(entry)
                && entry.contains("Date")
                && entry.contains("Narration")
                && entry.contains("Chq/Ref Number");
    }


}
