package anwesha.common.parsers.implementation;

import anwesha.common.parsers.parser;
import anwesha.models.product;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class productparser implements parser<product> {
	
	
    @Override
    public Map<String, product> parseList(List<String> lines) {
        return lines.stream()
                .map(this::getProduct)
                .collect(toMap(product::getCode, product -> product));
    }

    private product getProduct(String row) {
        String[] values = row.split(CSV_SEPARATOR);
        return new product(values[0].trim(), values[1].trim());
    }

}
//File Complete