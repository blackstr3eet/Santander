package com.ibm.bank.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "statementList",
    "error"
})
public class Statement {

    @JsonProperty("statementList")
    private List<StatementList> statementList = null;

    @JsonProperty("error")
    private Error error;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Statement() {
    }

    public Statement(List<StatementList> statementList, Error error) {
        super();
        this.statementList = statementList;
        this.error = error;
    }

    @JsonProperty("statementList")
    public List<StatementList> getStatementList() {
        return statementList;
    }

    @JsonProperty("statementList")
    public void setStatementList(List<StatementList> statementList) {
        this.statementList = statementList;
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