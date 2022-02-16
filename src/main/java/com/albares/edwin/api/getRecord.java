//relente.net/edwin
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
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edwin Jaldin S.
 */
@Path("/getRecord")
public class getRecord {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecord() throws SQLException {
        Db myDb = new Db();
        myDb.connect();
        List<Record> records = getRecordDB(myDb);
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

    /*
    @OPTIONS
    @Path("{path : .*}")
    public Response options() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }
     */
}
