package org.webapp.model;

import org.agileware.test.PropertiesTester;
import org.junit.Test;

public class IdentityTest {

    @Test
    public void coverage() throws Exception {
        PropertiesTester tester = new PropertiesTester();
        tester.testAll(Identity.class);
    }
}