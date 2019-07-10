package anwesha.common;

import static java.util.Arrays.asList;

import java.util.List;

public class constants {
    public static final List<String> EXIT_COMMANDS = asList("EXIT", "exit", "0");
    public static final String PRODUCT_CSV_FILE = "productslist.csv";
    public static final String PRODUCT_PRICE_CSV_FILE = "productprice.csv";
    public static final String CURRENCY = "$";
    public static final String SPACE = " ";
    public static final String TABSPACE = "\t";
    public static final String NEWLINE = "\n";
    public static final String MUL = " X ";
    public static final String LINE = "------------------------------------------------------------";
    public static final String ORDER_TEXT = "How can I help??? What do you want???(Type " + EXIT_COMMANDS+" to exit).";
    public static final String BAKERY_CLOSED_TEXT = "BAKERY CLOSED";
    public static final String INVALID_USER_INPUT = "User input is not valid. Please follow this:8 VS5, 14 MB11, 17 CF";
    public static final String INVALID_PRODUCT_CODE = "PLEASE ENTER A VALID PRODUCT CODE e.g:8 VS5, 14 MB11, 17 CF";
    public static final String CSV_READING_ERROR = "Error while reading csv:";
    public static final String INVALID_INPUT_PRODUCT_COUNT = "Product count is invalid";

}

//File Complete