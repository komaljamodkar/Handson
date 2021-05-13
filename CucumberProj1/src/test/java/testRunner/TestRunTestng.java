package testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "./src/test/java/features/login4.feature"
        
        )
 
public class TestRunTestng extends AbstractTestNGCucumberTests{
 
}