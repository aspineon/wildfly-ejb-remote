# wildfly-ejb-remote
Wildfly example of remote EJB invocation. Based on the work by Jaikiran Pai and Mike Musgrove. (<https://github.com/wildfly/quickstart/>)

What is it?
-----------

Access an EJB from a remote WAR client application, using *EJB* and *JNDI*. There are two components to this example:

1. A server side component:

    The server component is comprised of a stateful EJB and a stateless EJB. It provides both an EJB JAR that is deployed to the server and a JAR file containing the remote business interfaces required by the remote client application.

2. A remote client application that accesses the server component.

    The remote client application depends on the remote business interfaces from the server component. This application looks up the stateless and stateful beans via JNDI and invokes a number of methods on them.

Each component is defined in its own standalone Maven module. There is a top level Maven module to simplify the packaging of the artifacts.

System requirements
-------------------

The application this project produces is designed for WildFly 10, and uses Java 8 and Maven 3.1.1 or later.

Build and Deploy the Quickstart
-------------------------

1. Build and install the server side component:
    * Navigate to the server-side subdirectory:

            cd server-side
    * Build the EJB and client interfaces JARs and install them in your local Maven repository.

            mvn clean install
    * Deploy and run the EJB JAR to a WildFly server.

            mvn wildfly:run

2. Build and run the client REST services:
    * Navigate to the client subdirectory:

            cd ../client
    * Compile the client code

            mvn clean compile
    * Deploy and run the WAR to a WildFly server.

            mvn wildfly:run

3. Test the REST services

The server runs on port 9080. The client (REST services) runs on port 8080.

Examples:

    http://localhost:8080/api/calc/add/3/4

    http://localhost:8080/api/calc/sub/7/5

    http://localhost:8080/api/count/inc/3

    http://localhost:8080/api/count/dec/2
