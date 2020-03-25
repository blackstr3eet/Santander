package com.ibm.bank.util;

import com.ibm.bank.domain.Credentials;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Storage.class)
public class StorageTest {

    @Mock
    private Credentials credentials;

    @Before
    public void setUp() {
        mockStatic(Storage.class);

        doReturn("chewbacca@starwars.com").when(credentials).getUser();
        doReturn("St@rW@rs").when(credentials).getPassword();

        when(Storage.retrieveDataWithSharedPreferences(Matchers.any())).thenReturn(credentials);
        when(Storage.saveDataWithSharedPreferences(Matchers.any(), Matchers.any())).thenReturn(true);
    }

    @Test
    public void saveLoginDataInInternalStorage() {
        boolean status = Storage.saveDataWithSharedPreferences(Matchers.any(), Matchers.any());

        assertTrue(status);
    }

    @Test
    public void retrieveLoginDataInInternalStorage() {
        Credentials credentials = Storage.retrieveDataWithSharedPreferences(Matchers.any());

        assertEquals("chewbacca@starwars.com", credentials.getUser());
        assertEquals("St@rW@rs", credentials.getPassword());
    }
}