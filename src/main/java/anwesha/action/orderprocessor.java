package anwesha.action;


import anwesha.common.parsers.parser;
import anwesha.common.parsers.implementation.userinputparser;
import anwesha.models.product;
import anwesha.common.exception.userinputexception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.summingDouble;

import static anwesha.common.constants.*;


public class orderprocessor {
	
    private bakeryproductstore bakeryProductStore = bakeryproductstore.getInstance();
    private parser<Integer> userInputParser = new userinputparser();
    private bakery bakery;
    
    
    public orderprocessor(bakery bakery) {
        this.bakery = bakery;
    }
    
    //gets the input from user and process the order, if the input is invalid it will throw an error
    
    public String process(String inputString) {
        if(!EXIT_COMMANDS.contains(inputString.trim())) {
            try {
                Map<String, Integer> userInput = userInputParser.parseList(singletonList(inputString));
                return userInput.entrySet().stream()
                        .map(this::generateOrderBill)
                        .collect(Collectors.joining(NEWLINE));
            } catch (userinputexception ie) {
                return ie.getMessage();
            }
        } else {
            bakery.close();
            return BAKERY_CLOSED_TEXT;
        }
    }
    
    //calculates the bill based on the order
    
    private String generateOrderBill(Entry<String, Integer> userInputEntry) {
        final product product = bakeryProductStore.findProduct(userInputEntry.getKey());

        if(nonNull(product)) {
            final Integer quantity = userInputEntry.getValue();
            return printBill(calculateBill(product, quantity), product, quantity);
        } else {
            throw new userinputexception(INVALID_PRODUCT_CODE);
        }
    }
    
    //calculateBill() function takes the product and no. of items ordered as the arguments
    
    private Map<Integer, Integer> calculateBill(product product, Integer quantity) {
    	
    	//output will give you the packsize and how many packsize you need to get the desired no. of items
    	
        Map<Integer, Integer> output = new HashMap<>();

        //sorted packsize in reverse order for the ordered product
        
        List<Integer> packSizeList = product.getSortedSupportedPackList();

        int q = quantity;
        int start = 0;
        int packSize = 0;
  
        //the actual algorithm is written here as described in the readme file...if the quantity is greater than zero and the variable
        //start(the counter) is less than the packsize then proceed with the flow until the remainder is zero
        
        while (q > 0 && start < packSizeList.size()) {
            if(packSize > 0) {
                if(packSizeList.indexOf(packSize)+1 == packSizeList.size()) {
                    packSize = packSizeList.get(0);
                }

                if(output.containsKey(packSize)) {
                    q = q + packSize;

                    if (output.get(packSize) > 1) {
                        output.put(packSize, output.get(packSize) - 1);
                    } else {
                        output.remove(packSize);
                    }

                    start = packSizeList.indexOf(packSize) + 1;
                }
            }

            for (int i=start; i<packSizeList.size(); i++) {
                if (q/packSizeList.get(i) > 0) {
                    packSize = packSizeList.get(i);
                    output.put(packSize, q/packSize);
                    q = q % packSize;
                }
            }

            start++;
        }

        if(q > 0) {
            output.clear();
        }

        return output;
    }
    
    //printBill prints the total amount need to be paid, takes argument output(explained above), product code, total no. of items required
    
    private String printBill(Map<Integer, Integer> output, product product, Integer quantity) {
        if(output.isEmpty()) {
        	
        	//the no. of items should be in a manner that the count(no. of items requested) is matching with the pack sizes
        	//It will print Invalid Product count if the remainder is not zero
        	
            return INVALID_INPUT_PRODUCT_COUNT;
        } else {
            StringBuffer outputBuffer = new StringBuffer();
            float totalOrderValue = 0f;

            for(Integer packSize :  output.keySet()) {
                totalOrderValue += output.get(packSize) * product.getPrice(packSize);

                outputBuffer.append(NEWLINE + TABSPACE + output.get(packSize) + MUL + packSize + CURRENCY
                        + product.getPrice(packSize));
            }
            
            //prints the output in desired way 
            //10 VS5 $17.98
            //2*5 $8.99
            
            return quantity + SPACE + product + SPACE + CURRENCY + totalOrderValue + outputBuffer.toString();
        }
    }
    

}
