package anwesha.common.exception;

//custom exception while reading the csv file

public class readerexpection extends RuntimeException {
	
    public readerexpection(String msg) {
        super(msg);
    }

}