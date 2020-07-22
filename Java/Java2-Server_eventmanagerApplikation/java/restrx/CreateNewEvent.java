package restrx;

import db.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/new")
public class CreateNewEvent {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response createEvent() throws Exception{
        //Öffne MySql Connection
        Database.createConnection();


        //schreib testweise das 1 Event neu in die Datenbank
        Database.writeEventIntoDatabase();


        //Der Mist ist notwendig für Angular
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .entity(Database.writeEventIntoDatabase())
                .build();
    }
}
