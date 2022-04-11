package testOptions;

import io.cucumber.testng.*;

@CucumberOptions(
		
		//The features that we want to specifically run are selected
        features = {"src/test/java/features/Products.feature"},
        //the glue file is initialised
        glue = {"stepDefinitions"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
 
}
