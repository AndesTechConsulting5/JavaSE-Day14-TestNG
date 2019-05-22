package org.andestech.learning.rfb19.g4;


import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * TestNG Unit test for simple App.
 **/

public class App2Test
{

    @Test
    public void checker03Test()
    {
        // исключительно в учебных целях!!!
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Assert.assertTrue( true );
    }


    @Test
    @Parameters({"name", "sname", "login"})
    public void loginDataTest(String name, String sname, String login)
    {
     Assert.assertEquals( (name.substring(0,1) + sname).toUpperCase(), login  );

    }

    @DataProvider(name = "data")
    public static Object[][] getLoginsFromDB(){

        return new Object[][]{
                {"Peter", "Pen", "PPEN"},
                {"Basil", "Hide", "BHID2"},
                {"Kate", "Barlow", "KBARLOW"}};
    }


    @DataProvider(name = "data2")
    public static Object[][] getLoginsFromDB2(){

       // Object[][] oarr = new Object[][3];

        ArrayList<Object[]> arr = new ArrayList<>(20);

        arr.add(new Object[]{"Peter", "Pen", "PPEN"});
        arr.add(new Object[]{"Basil", "Hide", "BHIDE"});
        arr.add(new Object[]{"Kate", "Barlow", "KBARLOW"});


        Object[][] oarr = new Object[arr.size()][3];

        int i=0;
        for (Object[] d: arr)  oarr[i++]= d;

        return oarr;






    }


    @Test(dataProvider = "data2")
   // @Parameters({"name", "sname", "login"})
    public void loginDataTest2(String name, String sname, String login)
    {
        Assert.assertEquals( login, (name.substring(0,1) + sname).toUpperCase() );

    }

    @DataProvider(name = "idData")
    public static Object[] getIds(){

     //   System.out.println(iSuite.getXmlSuite().getParameter("page"));

        return new Object[]{"id213","Hgqyweu","p_1221_3123_222"};
    }


    @DataProvider(name = "idData2")
    public static Object[] getIds2(ITestContext ctx){

       // File file = new File(ctx.getCurrentXmlTest().getParameter("webElements"));
        String filename = ctx.getCurrentXmlTest().getParameter("webElements");
        List<String> lines = null;

        try {
            lines =Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            lines.removeIf( x -> x.startsWith("#"));

            System.out.println(lines);
        }
        catch (IOException ex){ex.printStackTrace();}

        //   Object[] arr = new Object[lines.size()];
        //   System.out.println(iSuite.getXmlSuite().getParameter("page"));

        return lines.toArray();
    }


    @Test(dataProvider = "idData2")
    public void elementPresenceTest(String id)
    {
        System.out.println("id: " + id);

    }




}
