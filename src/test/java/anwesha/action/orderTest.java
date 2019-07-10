package anwesha.action;

import org.junit.Assert;
import org.junit.Test;
import anwesha.common.constants;

import static anwesha.io.implementation.consolewriter.write;
import static org.junit.Assert.assertEquals;

public class orderTest {
	
	orderprocessor orderProcessor = new orderprocessor(new bakery());

	   @Test
	    public void testValidInput() {
	        String output = orderProcessor.process("15 VS5");
	        assertEquals(
	                "15 VS5-Vegemite Scroll $26.97\n\t3 X 5$8.99",
	                output);

	        output = orderProcessor.process("40 CF");
	        assertEquals(
	                "40 CF-Croissant $76.82\n\t1 X 3$5.95\n\t2 X 5$9.95\n\t3 X 9$16.99",
	                output);

	        output = orderProcessor.process("19 MB11");
	        assertEquals(
	                "19 MB11-Blueberry Muffin $61.8\n\t2 X 2$9.95\n\t1 X 5$16.95\n\t1 X 8$24.95",
	                output);
	    }
	   
	    @Test
	    public void testInvalidInput() {
	        String output = orderProcessor.process("30 VS10");
	        Assert.assertEquals(constants.INVALID_PRODUCT_CODE, output);
	    }

	    @Test 
	    public void testInvalidProduct() {
	        String output = orderProcessor.process("75VS5");
	        Assert.assertEquals(constants.INVALID_USER_INPUT, output);
	    }

	    @Test
	    public void testInvalidProductCount() {
	        String output = orderProcessor.process("1 VS5");
	        Assert.assertEquals(constants.INVALID_INPUT_PRODUCT_COUNT, output);
	    }
	    
	    

}
