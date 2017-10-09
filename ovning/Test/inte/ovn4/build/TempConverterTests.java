package inte.ovn4.build;

import static org.junit.Assert.*;
import static inte.ovn4.build.TempConverter.celsiusToFarenheit;

import org.junit.Test;

public class TempConverterTests {

    @Test
    public void testOneCelsius() {
        assertEquals(33.8, celsiusToFarenheit(1), 0.01);
    }

    @Test
    public void testOneHundredCelsius() {
        assertEquals(212, celsiusToFarenheit(100), 0.01);
    }

}