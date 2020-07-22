package restrx;

import db.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Faengt mit 1 an und nicht null
@Path("/event")
public class GetEventByID {

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response geIdNumber(@PathParam("id") int id)  throws Exception {
        //Öffne MySql Connection
        Database.createConnection();



        //für den directen zugriff auf die url notwendig
        Database.readEvent(id);




        //Der Mist ist notwendig für Angular
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .entity(Database.readEvent(id))
                .build();
    }
}
