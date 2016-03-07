package com.beauchef.service;

import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by jean- on 2016-03-06.
 */
public class CalculatorService {

    public int add(int n1, int n2) throws NamingException {
        return lookupRemoteCalculator().add(n1, n2);
    }

    public int subtract(int n1, int n2) throws NamingException {
        return lookupRemoteCalculator().subtract(n1, n2);
    }

    private RemoteCalculator lookupRemoteCalculator() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        final Context context = new InitialContext(jndiProperties);
        RemoteCalculator calculator = (RemoteCalculator)context.lookup(
                "ejb:/wildfly-ejb-remote-server-side/CalculatorBean!" + RemoteCalculator.class.getName());
        return calculator;
    }

}
