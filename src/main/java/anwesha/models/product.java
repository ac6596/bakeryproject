package anwesha.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

//define the products, product code i.e for product Croissant product code is CF

public class product {
    private String code;
    private String name;
    private Map<Integer, Float> priceByPackMap;
    
    public product(String code, String name) {
        this.code = code;
        this.name = name;
        this.priceByPackMap = new HashMap<>();
    }
    
    //get the product code
    public String getCode() {
        return code;
    }
    
    //get the product name
    public String getName() {
        return name;
    }
    
    //get price of each pack
    public Float getPrice(Integer packSize) {
        return priceByPackMap.get(packSize);
    }
    
    //map the price with the corresponding packsize
    public void addPricePack(Integer packSize, Float price) {
        this.priceByPackMap.put(packSize, price);
    }
    
    //sort the packsize in descending order for each product i.e for product code CF, packsize would be 9,5,3
    public List<Integer> getSortedSupportedPackList() {
        return priceByPackMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(toList());
    }
    
    public String toString() {
        return code + "-" + name;
    }

}