package com.bookit.step_definitions;

import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {

    //important

    // java -jar selenium-server-standalone-3.141.59.jar
    //  java -jar selenium-server-standalone-3.141.59.jar -role hub
    // for node at below
    // java -jar selenium-server-standalone*.jar -role node -hub http://localhost:4444/grid/register
    //for chrome set up
    // java -Dwebdriver.chrome.driver="chromedriver.exe"  -jar selenium-server-standalone*.jar -role node -hub http://localhost:4444/grid/register
    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @Before("@db")
    public void dbSetup() {
        DBUtility.createDBConnection(Environment.DB_HOST, Environment.DB_USERNAME, Environment.DB_PASSWORD);
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @After("@db")
    public void dbTearDown() {
        DBUtility.destroy();
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */
    @Before("@ui")
    public void uiSetup() {
        Driver.getDriver().manage().window().maximize();
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */
    @After("@ui")
    public void uiTearDown() {
        Driver.closeDriver();
    }

}
