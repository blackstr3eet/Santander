package com.ibm.bank.login;

public class LoginResponse {

    private String name;
    private String agency;
    private String account;
    private String balance;

    public void processBody(LoginRequest request) {
        name    = request.getBody().getUserAccount().getName();
        agency  = request.getBody().getUserAccount().getBankAccount();
        account = formatterAgencyNumber(request.getBody().getUserAccount().getAgency());
        balance = String.format("R$%.2f", request.getBody().getUserAccount().getBalance());
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

    public String getName() {
        return name;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccount() {
        return account;
    }

    public String getBalance() {
        return balance;
    }
}