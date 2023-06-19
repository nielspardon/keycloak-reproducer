import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
