package com.ibm.bank.login;

public class LoginResponse {

    public String name;
    public String agency;
    public String account;
    public String balance;

    public void processBody(LoginRequest request) {
        name    = request.body.getUserAccount().getName();
        agency  = request.body.getUserAccount().getBankAccount();
        account = formatterAgencyNumber(request.body.getUserAccount().getAgency());
        balance = String.format("R$%.2f", request.body.getUserAccount().getBalance());
    }

    private String formatterAgencyNumber(String data) {
        StringBuilder builder = new StringBuilder();

        builder.append(data.substring(0, 2));
        builder.append(".");
        builder.append(data.substring(2, 8));
        builder.append("-");
        builder.append(data.substring(8));

        return builder.toString();
    }
}