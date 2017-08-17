package DefaultNamespace;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestConverter {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 32, 0 } , {35,2.0} , {19,-7.0} , {40,4.0} , {60,16.0}
           });
    }

    double Input;
    double Expected;

    public TestConverter(double input, double expected) {
    	Input= input;
        Expected= expected;
    }

	@Test
    public void test() {
    	System.out.println("Parameterized Number is : " + Input);
        assertEquals( Double.toString(Expected), Double.toString(AddServiceClient.convertTemperature(Input)) );
    }

}

