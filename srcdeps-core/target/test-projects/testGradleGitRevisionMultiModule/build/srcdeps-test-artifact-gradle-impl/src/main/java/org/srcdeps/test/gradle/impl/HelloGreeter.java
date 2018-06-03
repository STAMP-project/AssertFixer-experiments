package org.srcdeps.test.gradle.impl;

import org.srcdeps.test.gradle.api.Greeter;

/**
 * @author <a href="https://github.com/ppalaga">Peter Palaga</a>
 */
public class HelloGreeter implements Greeter {

    @Override
    public String greet(String whom)  {
        return "Hello "+ whom +"!";
    }

}
