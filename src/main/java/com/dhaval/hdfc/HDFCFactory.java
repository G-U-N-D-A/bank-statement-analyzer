package com.dhaval.hdfc;

import com.dhaval.hdfc.api.HDFCStatementValidator;
import com.dhaval.hdfc.impl.HDFCStatementValidatorImpl;

public class HDFCFactory {
    public static HDFCStatementValidator getHDFCStatmentValidator() {
        return new HDFCStatementValidatorImpl();
    }
}
