package com.albares.edwin.utils;

import com.albares.edwin.domain.Record;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author Edwin Jaldin S.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private Record record;
    private Integer responseCode;
    private List<Record> records;

    public Response() {
    }

    public Response(Record record) {
        this.record = record;
    }

    public Response(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Response(Integer responseCode, List<Record> records) {
        this.responseCode = responseCode;
        this.records = records;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
