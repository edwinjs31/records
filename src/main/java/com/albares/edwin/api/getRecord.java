//relente.net/edwin
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
@Path("/getRecord")
public class getRecord {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRecord() {

        Record rcd = new Record();
        Response r = new Response();

        try {
            Db myDb = new Db();
            myDb.connect();
            r.setRecords(rcd.getRecordDB(myDb));
            myDb.disconnect();

            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;

    }
}
