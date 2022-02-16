package com.albares.edwin.api;

import com.albares.edwin.db.Db;
import com.albares.edwin.domain.Record;
import static com.albares.edwin.domain.Record.getRecordDB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edwin Jaldin S.
 */
@Path("/addRecord")
public class addRecord {

    /*ResponseBuilder r = Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "OPTIONS,POST")
            .header("Access-Control-Allow-Headers", "Content-Type, Authorization");*/
            

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRecord(Record rcd) throws SQLException, Exception {
        Db myDb = new Db();
        myDb.connect();
        rcd.addRecordDB(myDb);
        List records = getRecordDB(myDb);
        myDb.disconnect();
        Response r = Response.ok(records)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "OPTIONS,POST")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
        return r;

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
