package com.beauchef.service;

import org.jboss.as.quickstarts.ejb.remote.stateful.RemoteCounter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by jean- on 2016-03-06.
 */
public class CounterService {

    public List<Integer> inc(int steps) throws NamingException {
        return count(steps, true);
    }

    public List<Integer> dec(int steps) throws NamingException {
        return count(steps, false);
    }

    private List<Integer> count(int steps, boolean up) throws NamingException {

        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        final Context context = new InitialContext(jndiProperties);

        RemoteCounter counter =  (RemoteCounter)context.lookup(
                "ejb:/wildfly-ejb-remote-server-side/CounterBean!" + RemoteCounter.class.getName() + "?stateful");

        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < steps; i++) {
            if (up) {
                counter.increment();
            } else {
                counter.decrement();
            }
            ints.add(counter.getCount());
        }
        context.close();
        return ints;
    }

}
