package anwesha.action;

import anwesha.io.reader;
import anwesha.io.implementation.userinputreader;
import static anwesha.common.constants.LINE;
import static anwesha.common.constants.ORDER_TEXT;
import static anwesha.io.implementation.consolewriter.write;


public class bakery {
	private reader read = userinputreader.getInstance();
	private orderprocessor orderproc;
	private boolean open;
	
	public void open() {
		
		this.open = true;
		orderproc = new orderprocessor(this); //Remove
		
		while (open) {
			write(ORDER_TEXT);
			write(orderproc.process(read.readValue())); //Remove
			write(LINE);
			
		}
	}
	
    public void close() {
        this.open = false;
    }

}

//Removal Left