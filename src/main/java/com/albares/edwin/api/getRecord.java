//relente.net/edwin
package com.albares.edwin.api;

import com.albares.edwin.db.Db;
import com.albares.edwin.domain.Record;
import static com.albares.edwin.domain.Record.getRecordDB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edwin Jaldin S.
 */
@Path("/getRecord")
public class getRecord {

    Response.ResponseBuilder r = Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "OPTIONS,POST")
            .header("Access-Control-Allow-Headers", "Content-Type, Authorization");

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecord() throws SQLException {
        Db myDb = new Db();
        myDb.connect();
        List<Record> records = getRecordDB(myDb);
        myDb.disconnect();
        r.entity(records);
        return r.build();
    }

    @OPTIONS
    public Response doOptions() {

        return r.build();
    }

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
