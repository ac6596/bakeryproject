package anwesha.action;

import anwesha.common.exception.readerexpection;
import anwesha.common.parsers.parser;
import anwesha.common.parsers.implementation.productparser;
import anwesha.common.parsers.implementation.productpriceparser;
import anwesha.common.utils.fileutils;
import anwesha.models.product;
import anwesha.models.productprice;


import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static java.util.Objects.isNull;
import static anwesha.common.constants.PRODUCT_CSV_FILE;
import static anwesha.common.constants.PRODUCT_PRICE_CSV_FILE;
import static anwesha.io.implementation.consolewriter.*;

public class bakeryproductstore {
	private static bakeryproductstore bakeryprdstore;
	private static Map<String, product> productMap;

    private bakeryproductstore() {
        loadProductMap();
        loadPriceInProductMap();
    }

    public static bakeryproductstore getInstance() {
        if(isNull(bakeryprdstore)) {
            bakeryprdstore = new bakeryproductstore();
        }

        return bakeryprdstore;
    }
    
    //find the ordered product from the input given
    
    public product findProduct(String productCode) {
        return productMap.get(productCode);
    }
    
    //read the csv file productslist.csv provided which is defined in fileutils.java
    
    private void loadProductMap() {
        try {
            parser<product> productParser = new productparser();
            productMap = productParser.parseList(fileutils.readFileText(PRODUCT_CSV_FILE));
        } catch (readerexpection rex) {
            write(rex.getMessage());
        }
    }

    //get the price of each product
    
    private void loadPriceInProductMap() {
        Map<String, List<productprice>> productPriceMap = getProductPriceMap();
        populatePriceInProductMap(productPriceMap);
    }
    
    //read the csv file productprice.csv

    private Map<String, List<productprice>> getProductPriceMap() {
        try {
            parser<List<productprice>> productPriceParser = new productpriceparser();
            return productPriceParser.parseList(fileutils.readFileText(PRODUCT_PRICE_CSV_FILE));
        } catch (readerexpection rex) {
            write(rex.getMessage());
            return emptyMap();
        }
    }

    private void populatePriceInProductMap(Map<String, List<productprice>> productPriceMap) {
        productPriceMap.entrySet().forEach(this::populatePriceInProduct);
    }

    private void populatePriceInProduct(Map.Entry<String, List<productprice>> productPriceEntry) {
        product prod = productMap.get(productPriceEntry.getKey());

        productPriceEntry.getValue().forEach(
                productPrice -> {
                    prod.addPricePack(productPrice.getPackSize(), productPrice.getPrice());
                }
        );
    }


}
