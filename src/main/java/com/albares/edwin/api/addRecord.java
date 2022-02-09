package com.albares.edwin.api;

import com.albares.edwin.db.Db;
import com.albares.edwin.domain.Record;
import com.albares.edwin.utils.Response;
import com.albares.edwin.utils.ResponseCode;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
    public Response addRecord(Record rcd) {

        try {
            Db myDb = new Db();
            myDb.connect();
            rcd.addRecordDB(myDb);
            myDb.disconnect();
            return new Response(ResponseCode.OK);
        } catch (Exception e) {
            return new Response(ResponseCode.ERROR);
        }

    }
}
