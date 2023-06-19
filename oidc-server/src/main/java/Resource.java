import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Resource {
  @Path("hello")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @RolesAllowed("user")
  public String hello() {
    return "Hello world!";
  }
}
