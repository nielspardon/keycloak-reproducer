import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.filter.OidcClientRequestFilter;

// Binds the configuration from the application.properties to this REST client.
@RegisterRestClient(configKey = "test")
// Propagates and renews the OIDC token.
@RegisterProvider(OidcClientRequestFilter.class)
@ApplicationScoped
public interface Client {
  @Path("hello")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello();
}
