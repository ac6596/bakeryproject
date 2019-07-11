package anwesha.common.parsers.implementation;


import anwesha.common.exception.userinputexception;
import anwesha.common.parsers.parser;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toMap;
import static anwesha.common.constants.INVALID_USER_INPUT;

//checks the user input if that is in proper format else throw userinputexception

public class userinputparser implements parser<Integer> {
	
    public Map<String, Integer> parseList(List<String> lines) {
        try {
            return lines.stream()
                    .map(line -> line.split(USER_INPUT_SEPARATOR))
                    .collect(toMap(o -> o[1].trim(), o -> parseInt(o[0].trim())));
        } catch (Exception ex) {
            throw new userinputexception(INVALID_USER_INPUT);
        }
    } 

}
