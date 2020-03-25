package com.ibm.bank.login;

import com.ibm.bank.domain.User;
import com.ibm.bank.domain.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(LoginResponse.class)
public class LoginResponseTest {

    @Mock
    private LoginRequest loginRequest;

    @Mock
    private UserAccount userAccount;

    @Mock
    private User user;

    private LoginResponse response = new LoginResponse();

    @Before
    public void setUp() {
        when(loginRequest.getBody()).thenReturn(user);

        when(user.getUserAccount()).thenReturn(userAccount);

        when(userAccount.getName()).thenReturn("Jose da Silva Teste");
        when(userAccount.getBankAccount()).thenReturn("2050");
        when(userAccount.getAgency()).thenReturn("012314564");
        when(userAccount.getBalance()).thenReturn(3.3445d);
    }

    @Test
    public void processingResponseBodyData() {
        response.processBody(loginRequest);

        Assert.assertEquals("Jose da Silva Teste", response.getName());
        Assert.assertEquals("2050", response.getAgency());
        Assert.assertEquals("01.231456-4", response.getAccount());
        Assert.assertEquals("R$3,34", response.getBalance());
    }
}