# Reproducing issue

1. Checkout repo
2. Run `./gradlew quarkusDev`
3. Receive exception:

```
2023-07-13 23:05:47,729 ERROR [io.qua.run.Application] (Quarkus Main Thread) Failed to start application (with profile [dev]): java.lang.ClassNotFoundException: com.google.cloud.sql.postgres.SocketFactory
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:375)
        at org.postgresql.util.ObjectFactory.instantiate(ObjectFactory.java:50)
        at org.postgresql.core.SocketFactoryFactory.getSocketFactory(SocketFactoryFactory.java:39)
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:227)
        at org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactory.java:54)
        at org.postgresql.jdbc.PgConnection.<init>(PgConnection.java:263)
        at org.postgresql.Driver.makeConnection(Driver.java:443)
        at org.postgresql.Driver.connect(Driver.java:297)
        at io.agroal.pool.ConnectionFactory.createConnection(ConnectionFactory.java:226)
        at io.agroal.pool.ConnectionPool$CreateConnectionTask.call(ConnectionPool.java:536)
        at io.agroal.pool.ConnectionPool$CreateConnectionTask.call(ConnectionPool.java:517)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at io.agroal.pool.util.PriorityScheduledExecutor.beforeExecute(PriorityScheduledExecutor.java:75)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
```