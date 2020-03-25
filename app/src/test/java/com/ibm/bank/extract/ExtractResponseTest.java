package com.ibm.bank.extract;

import com.ibm.bank.domain.Statement;
import com.ibm.bank.domain.StatementList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(ExtractResponse.class)
public class ExtractResponseTest {

    @Mock
    private ExtractRequest request;

    @Mock
    private Statement statement;

    private List<StatementList> list = new ArrayList();
    private ExtractResponse response = new ExtractResponse();

    @Before
    public void setUp() {
        list.add(new StatementList("DOC Recebida", "Victor Silva", "2018-06-23", 399.9d));
        list.add(new StatementList("Pagamento", "Faculdade", "2018-09-10", -500d));

        when(request.getBody()).thenReturn(statement);
        when(statement.getStatementList()).thenReturn(list);
    }

    @Test
    public void processingResponseBodyData() {
        response.processBody(request);

        assertEquals(response.getList().size(), 2);
        assertTrue(response.getList().get(0).getDesc().equals("Victor Silva"));
        assertTrue(response.getList().get(1).getTitle().equals("Pagamento"));
    }
}