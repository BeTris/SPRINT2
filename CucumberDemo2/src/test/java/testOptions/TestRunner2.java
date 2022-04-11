package testOptions;

import io.cucumber.testng.*;
//import org.testng.annotations.*;
//import utils.*;

@CucumberOptions(
		
		//The features that we want to specifically run are selected
        features = {"src/test/java/features/Coupons.feature"},
        //the glue file is initialised
        glue = {"stepDefinitions"},
        monochrome = true
)

public class TestRunner2 extends AbstractTestNGCucumberTests {
 
}
