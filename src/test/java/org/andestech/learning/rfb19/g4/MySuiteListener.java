package org.andestech.learning.rfb19.g4;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("++" + iSuite.getName());

        System.out.println(iSuite.getXmlSuite().getParameter("uname"));
        System.out.println();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("--" + iSuite.getName());
    }
}
