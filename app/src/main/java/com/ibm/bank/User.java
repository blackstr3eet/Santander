package com.ibm.bank;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userAccount",
    "error"
})
public class User {

    @JsonProperty("userAccount")
    private UserAccount userAccount;

    @JsonProperty("error")
    private Error error;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public User() {
    }

    public User(UserAccount userAccount, Error error) {
        super();
        this.userAccount = userAccount;
        this.error = error;
    }

    @JsonProperty("userAccount")
    public UserAccount getUserAccount() {
        return userAccount;
    }

    @JsonProperty("userAccount")
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @JsonProperty("error")
    public Error getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Error error) {
        this.error = error;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}