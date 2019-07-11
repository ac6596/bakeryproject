package anwesha.common.parsers;

import java.util.List;
import java.util.Map;

//related to the csv parse operation 

public interface parser<T> {

    String CSV_SEPARATOR = ",";
    String USER_INPUT_SEPARATOR = " "; //User should provide input like 10 VS5
    Map<String, T> parseList(List<String> lines);
	
}
