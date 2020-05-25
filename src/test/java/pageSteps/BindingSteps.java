package pageSteps;


import core.ProjectProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Report;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;


public class BindingSteps {

    private Scenario scenario;

    @Before
    public void beforeTagSelenium(Scenario scenario){
        this.scenario = scenario;
        Report.startTest(scenario.getName());
        getDriver();
    }

    @Before(value="RestAssured")
    public void beforeTagRestAssured(){

    }

    @After
    public void after(){
        if(ProjectProperties.CLOSE_BROWSER){
            killDriver();
        }
        Report.close();
    }
}

