package com.ibm.bank;

import java.util.ArrayList;
import java.util.List;

public class MockList {

    public static final MockList INSTANCE = new MockList();

    private MockList(){
        // singleton class
    }

    public List<StatementList> createMockListItemsExtract(){
        final List<StatementList> listItems = new ArrayList<>();
        listItems.add(new StatementList("Pagamento", "Eletropaulo", "10/03/2020", 181.59));
        listItems.add(new StatementList("Transferência", "Conta Poupança", "11/03/2020", 2050.00));
        listItems.add(new StatementList("Débito", "Pão de Açucar", "12/03/2020", 56.10));
        listItems.add(new StatementList("Pagamento", "Sabesp", "12/03/2020", 43.67));
        listItems.add(new StatementList("Débito", "Santa Lolla", "13/03/2020", 129.99));
        listItems.add(new StatementList("Pagamento", "Vivo Internet", "15/03/2020", 150.00));
        listItems.add(new StatementList("Débito", "Si Señor", "20/03/2020", 219.15));
        listItems.add(new StatementList("Transferência", "Renda Fixa", "28/03/2020", 950.00));
        return listItems;
    }
}