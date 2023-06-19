# Reproducer

Start the server and wait for the server to come up:

```bash
$ cd oidc-server
$ ./gradlew quarkusDev
...
2023-06-19 10:47:38,238 INFO  [io.quarkus] (Quarkus Main Thread) oidc-server unspecified on JVM (powered by Quarkus 2.16.7.Final) started in 17.854s. Listening on: http://localhost:8080
2023-06-19 10:47:38,239 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2023-06-19 10:47:38,239 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, config-yaml, oidc, resteasy-reactive, resteasy-reactive-jackson, security, smallrye-context-propagation, smallrye-openapi, swagger-ui, vertx]
2023-06-19 10:47:50,324 INFO  [io.qua.oid.dep.dev.OidcAuthorizationCodePostHandler] (DEV Console action) Using authorization_code grant to get a token from 'http://localhost:57611/realms/quarkus/protocol/openid-connect/token' with client id 'quarkus-app'
```

Start the client and wait for it to complete (there should be a log line saying `Hello world!`)

```bash
$ cd ../oidc-client
$ ./gradlew quarkusDev
...
2023-06-19 10:57:59,352 INFO  [io.quarkus] (Quarkus Main Thread) oidc-client unspecified on JVM (powered by Quarkus 2.16.7.Final) started in 2.532s. Listening on: http://localhost:57884
2023-06-19 10:57:59,354 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2023-06-19 10:57:59,355 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, config-yaml, oidc, oidc-client, oidc-client-filter, rest-client, rest-client-jackson, security, smallrye-context-propagation, vertx]
     2023-06-19 10:57:59,633 INFO  [App] (Quarkus Main Thread) Hello world!
2023-06-19 10:57:59,651 INFO  [io.quarkus] (Quarkus Main Thread) oidc-client stopped in 0.017s
Press [space] to restart, [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [h] for more options>
...
```

Press q + ENTER to exit quarkusDev for the client.

```bash
2023-06-19 11:02:37,299 ERROR [io.qua.oid.dep.dev.key.KeycloakDevServicesProcessor] (Quarkus Shutdown Thread) Failed to stop Keycloak container [Error Occurred After Shutdown]: java.lang.NullPointerException: Cannot invoke "java.io.Closeable.close()" because "this.closeable" is null
        at io.quarkus.deployment.builditem.DevServicesResultBuildItem$RunningDevService.close(DevServicesResultBuildItem.java:90)
        at io.quarkus.oidc.deployment.devservices.keycloak.KeycloakDevServicesProcessor$1.run(KeycloakDevServicesProcessor.java:217)
        at io.quarkus.deployment.builditem.CuratedApplicationShutdownBuildItem$1.run(CuratedApplicationShutdownBuildItem.java:48)
        at io.quarkus.bootstrap.classloading.QuarkusClassLoader.close(QuarkusClassLoader.java:617)
        at io.quarkus.bootstrap.app.CuratedApplication.close(CuratedApplication.java:418)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.close(IsolatedDevModeMain.java:356)
        at io.quarkus.deployment.dev.IsolatedDevModeMain$6.run(IsolatedDevModeMain.java:466)
        at java.base/java.lang.Thread.run(Thread.java:833)


Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/8.1.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 4m 44s
6 actionable tasks: 2 executed, 4 up-to-date
$
```

