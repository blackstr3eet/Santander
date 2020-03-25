package com.ibm.bank.extract;

import com.ibm.bank.domain.StatementList;
import java.util.List;

public class ExtractResponse {
    List<StatementList> list;

    public void processBody(ExtractRequest request) {
        list = request.body.getStatementList();
    }
}