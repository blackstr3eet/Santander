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
    "title",
    "desc",
    "date",
    "value"
})
public class StatementList {

    @JsonProperty("title")
    private String title;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("date")
    private String date;

    @JsonProperty("value")
    private double value;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public StatementList() {
    }

    public StatementList(String title, String desc, String date, double value) {
        super();
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.value = value;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("value")
    public double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(double value) {
        this.value = value;
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
