package com.ibm.bank.login;

public class LoginResponse {

    public String name;
    public String agency;
    public String account;
    public String balance;

    public void processBody(LoginRequest loginRequest) {
        name    = loginRequest.body.getUserAccount().getName();
        agency  = loginRequest.body.getUserAccount().getAgency();
        account = loginRequest.body.getUserAccount().getBankAccount();
        balance = String.format("R$%.2f", loginRequest.body.getUserAccount().getBalance());
    }
}