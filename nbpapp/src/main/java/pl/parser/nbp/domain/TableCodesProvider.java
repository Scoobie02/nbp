package pl.parser.nbp.domain;

import pl.parser.nbp.commons.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TableCodesProvider {

    private String BOOK_URL = "https://www.nbp.pl/kursy/xml/dir";
    private final String TXT = ".txt";
    private final Pattern tableCodePattern = Pattern.compile("c\\d\\d\\dz\\d\\d\\d\\d\\d\\d");

    List<String> provideTableCodes(String dateFrom, String dateTo) throws IOException {
        List<Integer> yearRange = fillYearRange(Helper.extractYear(dateFrom), Helper.extractYear(dateTo));
        List<String> tableCodes = new ArrayList<>();
        for (Integer p : yearRange) {
            tableCodes.addAll(findTableCodesInGivenYear(p));
        }
        reduceUnnecessaryTableCodes(tableCodes,
                Helper.extractProperNumberFromStringDate(dateFrom),
                Helper.extractProperNumberFromStringDate(dateTo));
        return tableCodes;
    }

    List<Integer> fillYearRange(Integer yearFrom, Integer yearTo) {
        if(Helper.isThisYear(yearTo)){
            List<Integer> integers = IntStream.rangeClosed(yearFrom, 2015).boxed().collect(Collectors.toList());
            integers.add(yearTo);

            return integers;
        }
        return IntStream.rangeClosed(yearFrom, yearTo).boxed().collect(Collectors.toList());
    }

    private List<String> findTableCodesInGivenYear(Integer year) throws IOException {
        return Helper.isThisYear(year) ? findTableCodesInBook(new URL(BOOK_URL + TXT)) : findTableCodesInBook(new URL(BOOK_URL + year + TXT));
    }

    List<String> findTableCodesInBook(URL bookUrl) throws IOException {
        List<String> tableCodes = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(bookUrl.openStream()))){

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                if(tableCodePattern.matcher(inputLine).matches()){
                    tableCodes.add(inputLine);
                }
            }
        }
        return tableCodes;
    }

    private void reduceUnnecessaryTableCodes(List<String> tableCodes, Integer from, Integer to){
        tableCodes.removeIf(p-> {
            Integer integer = Helper.extractLastSix(p);
            return integer<from || integer>to;
        });
    }

}
