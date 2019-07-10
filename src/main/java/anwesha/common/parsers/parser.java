package anwesha.common.parsers;

import java.util.List;
import java.util.Map;


public interface parser<T> {

    String CSV_SEPARATOR = ",";
    String USER_INPUT_SEPARATOR = " ";
    Map<String, T> parseList(List<String> lines);
	
}

//File Complete
