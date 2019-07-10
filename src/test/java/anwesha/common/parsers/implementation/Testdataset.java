package anwesha.common.parsers.implementation;

import java.util.List;

import static java.util.Arrays.asList;

public class Testdataset {
	
    public static final String INVALID_CSV_FILE = "invalidFile.csv";

    public static final List<String> PRODUCT_LIST = asList(
            "VS5, Vegemite Scroll", "MB11, Blueberry Muffin", "CF, Croissant"
    );

    public static final List<String> PRODUCT_PRICE_LIST = asList(
                    "VS5, 3, 6.99", "MB11,2, 9.95", "MB11, 5, 16.95", "CF, 3, 5.95", "CF, 5, 9.95", "CF, 9, 16.99"
    );

    public static final List<String> USER_INPUT_LIST = asList("9 VS5", "17 MB11", "14 CF");

}
