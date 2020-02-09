package com.dhaval.bank.plugin.hdfc.factory;

import com.dhaval.bank.plugin.hdfc.api.HDFCStatementValidator;
import com.dhaval.bank.plugin.hdfc.api.HDFCTransactionAttributeExtractor;
import com.dhaval.bank.plugin.hdfc.impl.HDFCStatementValidatorImpl;
import com.dhaval.bank.plugin.hdfc.impl.HDFCTransactionAttributeExtractorImpl;

public class HDFCFactory {
    public static HDFCStatementValidator getHDFCStatmentValidator() {
        return new HDFCStatementValidatorImpl();
    }
    public static HDFCTransactionAttributeExtractor getHdfcTransactionAttributeExtractor(String entry) { return new HDFCTransactionAttributeExtractorImpl(entry);}
}
