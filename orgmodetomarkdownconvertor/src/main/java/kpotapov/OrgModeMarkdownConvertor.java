package kpotapov;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class OrgModeMarkdownConvertor {

    private final static String[][] TRANSLATION_TABLE = {
            {"-*- mode:org; -*-", ""},
            {"******", "######"},
            {"*****", "#####"},
            {"****", "####"},
            {"***", "###"},
            {"**", "##"},
            {"*", "#"},
    };

    public static String convert(String input) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new StringReader(input))) {
            list = br.lines().collect(Collectors.toList());
            for (String s : list) {
                convertLine(s, result);
            }
        } catch (IOException e) {
            error("Error during processing files" + e.getMessage());
        }
        String joined = result.stream()
                .map(String::toString)
                .collect(Collectors.joining("\n"));
        return joined;
    }

    static void convertLine(String s, List<String> result) {
        boolean found = false;
        for (String[] searchPair : TRANSLATION_TABLE) {
            String prefix = searchPair[0];
            String replacement = searchPair[1];
            if (s.startsWith(prefix)) {
                result.add(s.replaceAll("^" + Pattern.quote(prefix), replacement));
                found = true;
                break;
            }
        }
        if (!found) {
            result.add(s);
        }
    }

    private static void error(String s) {
        System.out.println(s);
    }
}