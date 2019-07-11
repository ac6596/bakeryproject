package anwesha.models;

//define the product code,pack size and corresponding price of each pack
public class productprice {
    private String productCode;
    private Integer packSize;
    private Float price;

    public productprice(String productCode, Integer packSize, Float price) {
        this.productCode = productCode;
        this.packSize = packSize;
        this.price = price;
    }
    
    //return product code
    public String getProductCode() {
        return productCode;
    }
    
    //return pack size
    public Integer getPackSize() {
        return packSize;
    }
    
    //get the price of pack
    public Float getPrice() {
        return price;
    }
}
