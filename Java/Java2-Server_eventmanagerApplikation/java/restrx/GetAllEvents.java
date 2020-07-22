package restrx;

import db.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/events")
public class GetAllEvents {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response geIdNumber()  throws Exception {
        //Öffne MySql Connection
        Database.createConnection();



        //für den directen zugriff auf die url notwendig
        Database.getAllEvents();




        //Der Mist ist notwendig für Angular
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .entity(Database.getAllEvents())
                .build();
    }

}
