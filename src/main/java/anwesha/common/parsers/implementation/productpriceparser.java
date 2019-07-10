package anwesha.common.parsers.implementation;


import anwesha.common.parsers.parser;
import anwesha.models.productprice;

import java.util.List;
import java.util.Map;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.groupingBy;

public class productpriceparser implements parser<List<productprice>> {
	
    @Override
    public Map<String, List<productprice>> parseList(List<String> lines) {
        return lines.stream()
                .map(this::getProductQuantityPrice)
                .collect(groupingBy(productprice::getProductCode));
    }

    private productprice getProductQuantityPrice(String rowValue) {
        String[] values = rowValue.split(CSV_SEPARATOR);
        return new productprice(values[0].trim(), parseInt(values[1].trim()), parseFloat(values[2].trim()));
    }

}
//File Complete