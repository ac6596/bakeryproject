package anwesha.action;

import anwesha.io.reader;
import anwesha.io.implementation.userinputreader;
import static anwesha.common.constants.LINE;
import static anwesha.common.constants.ORDER_TEXT;
import static anwesha.io.implementation.consolewriter.write;


public class bakery {
	//
	private reader read = userinputreader.getInstance();
	//object creation of orderprocessor
	private orderprocessor orderproc;
	private boolean open;
	
	public void open() {
		
		this.open = true;
		orderproc = new orderprocessor(this); 
	
		//checks if the bakery is open or not
		while (open) {
			write(ORDER_TEXT); //Print ORDER_TEXT which is defined in constants.java, first prompt when we run the code
			write(orderproc.process(read.readValue())); 
			write(LINE);
			
		}
	}
	
	//if bakery is closed
    public void close() {
        this.open = false;
    }

}