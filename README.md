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
2023-06-19 11:17:14,747 WARN  [io.qua.ver.htt.run.VertxHttpRecorder] (Quarkus Shutdown Thread) Failed to undeploy deployment : java.util.concurrent.RejectedExecutionException: event executor terminated
        at io.netty.util.concurrent.SingleThreadEventExecutor.reject(SingleThreadEventExecutor.java:934)
        at io.netty.util.concurrent.SingleThreadEventExecutor.offerTask(SingleThreadEventExecutor.java:351)
        at io.netty.util.concurrent.SingleThreadEventExecutor.addTask(SingleThreadEventExecutor.java:344)
        at io.netty.util.concurrent.SingleThreadEventExecutor.execute(SingleThreadEventExecutor.java:836)
        at io.netty.util.concurrent.SingleThreadEventExecutor.execute0(SingleThreadEventExecutor.java:827)
        at io.netty.util.concurrent.SingleThreadEventExecutor.execute(SingleThreadEventExecutor.java:817)
        at io.vertx.core.impl.EventLoopContext.execute(EventLoopContext.java:88)
        at io.vertx.core.impl.ContextBase.execute(ContextBase.java:225)
        at io.vertx.core.impl.future.FutureBase.emitSuccess(FutureBase.java:51)
        at io.vertx.core.impl.future.SucceededFuture.addListener(SucceededFuture.java:88)
        at io.vertx.core.impl.future.FutureBase.compose(FutureBase.java:84)
        at io.vertx.core.impl.future.SucceededFuture.compose(SucceededFuture.java:27)
        at io.vertx.core.Future.compose(Future.java:360)
        at io.vertx.core.impl.VertxImpl.undeploy(VertxImpl.java:750)
        at io.vertx.core.impl.VertxImpl.undeploy(VertxImpl.java:755)
        at io.quarkus.vertx.http.runtime.VertxHttpRecorder$12.run(VertxHttpRecorder.java:814)
        at io.quarkus.vertx.http.runtime.VertxHttpRecorder.shutDownDevMode(VertxHttpRecorder.java:229)
        at io.quarkus.vertx.http.runtime.devmode.VertxHttpHotReplacementSetup.close(VertxHttpHotReplacementSetup.java:215)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.close(IsolatedDevModeMain.java:351)
        at io.quarkus.deployment.dev.IsolatedDevModeMain$6.run(IsolatedDevModeMain.java:466)
        at java.base/java.lang.Thread.run(Thread.java:833)

Press [space] to restart, [e] to edit command line args (currently ''), [h] for more options>
2023-06-19 11:17:14,748 ERROR [io.qua.oid.dep.dev.key.KeycloakDevServicesProcessor] (Quarkus Shutdown Thread) Failed to stop Keycloak container [Error Occurred After Shutdown]: java.lang.NullPointerException: Cannot invoke "java.io.Closeable.close()" because "this.closeable" is null
        at io.quarkus.deployment.builditem.DevServicesResultBuildItem$RunningDevService.close(DevServicesResultBuildItem.java:90)
        at io.quarkus.oidc.deployment.devservices.keycloak.KeycloakDevServicesProcessor$1.run(KeycloakDevServicesProcessor.java:217)
        at io.quarkus.deployment.builditem.CuratedApplicationShutdownBuildItem$1.run(CuratedApplicationShutdownBuildItem.java:48)
        at io.quarkus.bootstrap.classloading.QuarkusClassLoader.close(QuarkusClassLoader.java:617)
        at io.quarkus.bootstrap.app.CuratedApplication.close(CuratedApplication.java:407)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.close(IsolatedDevModeMain.java:356)
        at io.quarkus.deployment.dev.IsolatedDevModeMain$6.run(IsolatedDevModeMain.java:466)
        at java.base/java.lang.Thread.run(Thread.java:833)


Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/8.1.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 21s
6 actionable tasks: 1 executed, 5 up-to-date
$
```

