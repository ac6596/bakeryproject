package anwesha.common;

import static java.util.Arrays.asList;

import java.util.List;

//all the constants required

public class constants {
    public static final List<String> EXIT_COMMANDS = asList("EXIT", "exit", "0"); //To exit out from the prompt where the user will be asked to give the input
    public static final String PRODUCT_CSV_FILE = "productslist.csv"; //productlist as provided which is under resources
    public static final String PRODUCT_PRICE_CSV_FILE = "productprice.csv"; //products and corresponding codes provided which is available under resources
    public static final String CURRENCY = "$";
    public static final String SPACE = " ";
    public static final String TABSPACE = "\t";
    public static final String NEWLINE = "\n";
    public static final String MUL = " X ";
    public static final String LINE = "------------------------------------------------------------";
    public static final String ORDER_TEXT = "How can I help??? What do you want???(Type " + EXIT_COMMANDS+" to exit).";
    public static final String BAKERY_CLOSED_TEXT = "SORRY!!!BAKERY CLOSED!!!MAY BE SOMETIME LATER!!!BYE!!!";
    public static final String INVALID_USER_INPUT = "User input is not valid. Please follow this:8 VS5, 14 MB11, 17 CF";
    public static final String INVALID_PRODUCT_CODE = "PLEASE ENTER A VALID PRODUCT CODE e.g:8 VS5, 14 MB11, 17 CF";
    public static final String CSV_READING_ERROR = "Error while reading the csv provided:";
    public static final String INVALID_INPUT_PRODUCT_COUNT = "Product count is invalid";

}