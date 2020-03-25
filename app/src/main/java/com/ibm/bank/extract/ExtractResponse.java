package com.ibm.bank.extract;

import com.ibm.bank.domain.StatementList;
import java.util.List;

public class ExtractResponse {

    private List<StatementList> list;

    public void processBody(ExtractRequest request) {
        list = request.getBody().getStatementList();
    }

    public List<StatementList> getList() {
        return list;
    }
}