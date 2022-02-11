package com.albares.edwin.api;

import com.albares.edwin.db.Db;
import com.albares.edwin.domain.Record;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;

/**
 *
 * @author Edwin Jaldin S.
 */
@Path("/addRecord")
public class addRecord {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRecord(Record rcd) throws SQLException, Exception {
        Db myDb = new Db();
        myDb.connect();
        rcd.addRecordDB(myDb);
        myDb.disconnect();

    }

    @OPTIONS
    public Response doOptions() {
        Response r = Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "OPTIONS,POST")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
        return r;
    }
}
