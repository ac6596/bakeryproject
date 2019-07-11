package anwesha.common.utils;


import anwesha.common.exception.readerexpection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static anwesha.common.constants.CSV_READING_ERROR;

//read the csv and throws the readerexception if there is any error

public class fileutils {
	
	
	 public static List<String> readFileText(String fileName) {
	        BufferedReader bufferedReader = null;
	        try {
	            InputStream fileResource = fileutils.class.getClassLoader().getResourceAsStream(fileName);
	            bufferedReader = new BufferedReader(new InputStreamReader(fileResource));

	            return bufferedReader.lines().skip(1).collect(Collectors.toList());
	        } catch (Exception e) {
	            throw new readerexpection(CSV_READING_ERROR + fileName);
	        } finally {
	            try {
	                if (bufferedReader != null) {
	                    bufferedReader.close();
	                }
	            } catch (IOException e) { }
	        }
	    }
	

}