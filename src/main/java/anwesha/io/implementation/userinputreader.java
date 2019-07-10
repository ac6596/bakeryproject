package anwesha.io.implementation;

import anwesha.io.reader;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class userinputreader implements reader {
	
	public static reader read;
	public static Scanner scanner;
	
    private userinputreader() {
        scanner = new Scanner(System.in);
    }
    
    public static reader getInstance() {
        if(isNull(read)) {
            read = new userinputreader();
        }

        return read;
    }
    
    public String readValue() {
        return scanner.nextLine();
    }

}


//File Complete