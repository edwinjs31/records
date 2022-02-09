package com.albares.edwin.domain;

import com.albares.edwin.db.Db;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edwin Jaldin S.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record {

    private Integer id;
    private String name;
    private Integer time;

    public Record() {
    }

    public Record(Integer id, String name, Integer time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void addRecordDB(Db myDb) throws SQLException, Exception {
        PreparedStatement ps = myDb.prepareStatement(
                "INSERT INTO records(name,time) VALUES(?,?) RETURNING id;");
        ps.setString(1, this.getName());
        ps.setInt(2, this.getTime());

        ResultSet rs = myDb.executeQuery(ps);
        if (rs.next()) {
            this.setId(rs.getInt("id"));
        } else {
            throw new Exception();
        }
    }

    public List getRecordDB(Db myDb) throws SQLException {
        PreparedStatement ps = myDb.prepareStatement("SELECT id,name,time FROM records ;");

        ResultSet rs = myDb.executeQuery(ps);
        List<Record> records = new ArrayList<>();

        while (rs.next()) {
            records.add(new Record(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        return records;
    }

}
