package pl.parser.nbp.tableCode;

import pl.parser.nbp.commons.DateHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TableCodesProviderImpl implements TableCodesProvider {

    private String BOOK_URL = "https://www.nbp.pl/kursy/xml/dir";
    private final String TXT = ".txt";
    private final Pattern tableCodePattern = Pattern.compile("c\\d\\d\\dz\\d\\d\\d\\d\\d\\d");

    public List<String> provideTableCodes(String dateFrom, String dateTo) throws IOException {
        List<Integer> yearRange = fillYearRange(extractYear(dateFrom), extractYear(dateTo));
        List<String> tableCodes = new ArrayList<>();
        for (Integer p : yearRange) {
            tableCodes.addAll(findTableCodesInGivenYear(p));
        }
        reduceUnnecessaryTableCodes(tableCodes,
                extractProperNumberFromStringDate(dateFrom),
                extractProperNumberFromStringDate(dateTo));
        return tableCodes;
    }

    private Integer extractYear(String date){
        return Integer.valueOf(date.substring(0,4));
    }
    private Integer extractProperNumberFromStringDate(String date){
        String replaced = date.replace("-", "");
        return Integer.valueOf(replaced.substring(2));
    }
    private boolean isThisYear(Integer year){
        return DateHelper.getYearFromDate(new Date()) == year;
    }

    private List<Integer> fillYearRange(Integer yearFrom, Integer yearTo) {
        if(isThisYear(yearTo)){
            List<Integer> integers = IntStream.rangeClosed(yearFrom, 2015).boxed().collect(Collectors.toList());
            integers.add(yearTo);

            return integers;
        }
        return IntStream.rangeClosed(yearFrom, yearTo).boxed().collect(Collectors.toList());
    }

    private List<String> findTableCodesInGivenYear(Integer year) throws IOException {
        return isThisYear(year) ? findTableCode(new URL(BOOK_URL + TXT)) : findTableCode(new URL(BOOK_URL + year + TXT));
    }

    public List<String> findTableCode(URL bookUrl) throws IOException {
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
            Integer integer = extractLastSix(p);
            return integer<from || integer>to;
        });
    }

    private Integer extractLastSix(String code){
        //c021z130214 -> 130214
        int length = code.length();
        return Integer.valueOf(code.substring(length-6,length));
    }

}
