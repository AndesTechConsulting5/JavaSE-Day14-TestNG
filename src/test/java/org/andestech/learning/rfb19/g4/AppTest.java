package org.andestech.learning.rfb19.g4;


import org.testng.Assert;
import org.testng.ISuite;
import org.testng.annotations.Test;

/**
 * TestNG Unit test for simple App.
 **/
public class AppTest 
{

    @Test
    public void checker01Test()
    {
        // исключительно в учебных целях!!!
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Assert.assertTrue( true );
    }



    public String getParam(ISuite iSuite, String par)
    {
       return  iSuite.getXmlSuite().getParameter(par);

    }


    @Test
    public void checker02Test()
    {
        // исключительно в учебных целях!!!
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
       // System.out.println(getParam());

        Assert.assertTrue( true );
    }

}
