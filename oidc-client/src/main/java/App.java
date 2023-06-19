import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class App implements QuarkusApplication {
  @Inject @RestClient Client client;

  @Inject Logger log;

  @Override
  public int run(String... args) throws Exception {
    log.info(client.hello());
    return 0;
  }
  
}
