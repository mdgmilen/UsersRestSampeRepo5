package org.mileng.sample.MavenHerokuWebappPr3.rest;
// org.mileng.sample.MavenHerokuWebappPr3.rest

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mileng.sample.MavenHerokuWebappPr3.bl.BlHelper;

/**
 * Root resource (exposed at "rest/myresource" path)
 * http://localhost:8080/MavenHerokuWebappPr3
 *   1. /rest/users
 *   2. /Peter
 * 
 * 
 */
@Path("users")
public class UsersService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" MediaType.TEXT_PLAIN  media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
    	BlHelper helper = new BlHelper();
        return "All users: \n" + helper.getUsersAsString();
    }
    
    @GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Hello user: " + msg;
		return Response.status(200).entity(output).build();

	}
    
    
}
