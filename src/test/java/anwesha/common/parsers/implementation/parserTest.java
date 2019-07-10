package anwesha.common.parsers.implementation;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import anwesha.common.parsers.parser;
import anwesha.models.product;
import anwesha.models.productprice;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static anwesha.common.parsers.implementation.Testdataset.PRODUCT_LIST;
import static anwesha.common.parsers.implementation.Testdataset.PRODUCT_PRICE_LIST;
import static anwesha.common.parsers.implementation.Testdataset.USER_INPUT_LIST;


public class parserTest {

	@Test
    public void testProductParser() {
        parser<product> productParser = new productparser();
        Map<String, product> productMap = productParser.parseList(PRODUCT_LIST);
        assertNotNull(productMap);
        assertEquals(3, productMap.entrySet().size());
        assertEquals("Vegemite Scroll", productMap.get("VS5").getName());
        assertEquals("Blueberry Muffin", productMap.get("MB11").getName());
        assertEquals("Croissant", productMap.get("CF").getName());
    }

    @Test
    public void testProductPriceParser() {
        parser<List<productprice>> productPriceParser = new productpriceparser();
        Map<String, List<productprice>> productPriceMap = productPriceParser.parseList(PRODUCT_PRICE_LIST);
        assertNotNull(productPriceMap);
        assertEquals(3, productPriceMap.entrySet().size());
        assertEquals(1, productPriceMap.get("VS5").size());
        assertEquals(2, productPriceMap.get("MB11").size());
        assertEquals(3, productPriceMap.get("CF").size());
    }

    @Test
    public void testParseGameCharacter() {
        parser<Integer> userInputParser = new userinputparser();
        Map<String, Integer> userInputMap = userInputParser.parseList(USER_INPUT_LIST);
        assertNotNull(userInputMap);
        assertEquals(3, userInputMap.entrySet().size());
        assertEquals(9, userInputMap.get("VS5").intValue());
        assertEquals(17, userInputMap.get("MB11").intValue());
        assertEquals(14, userInputMap.get("CF").intValue());
    }
}
