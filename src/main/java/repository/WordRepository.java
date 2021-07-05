package repository;


import model.Word;

import java.util.*;
import java.util.regex.Pattern;


public class WordRepository {
    private final static char[] DIVIDERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')','{','}', '\n', '\r', '\t', '»', '«', '\'', '/', '—','-'};

    public Map<String, Word> parseWords(String text) {
        return countUniqueWords(getWords(text));
    }

    private List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder dividers = new StringBuilder();
        for (char divider : DIVIDERS) {
            dividers.append(divider);
        }
        String regexDivider = "[" + Pattern.quote(dividers.toString()) + "]";
        String[] arr = text.split(regexDivider);
        for (String s : arr) {
            String word = s.trim().toLowerCase();
            if (word.equals("")) {
                continue;
            }
            words.add(word);
        }
        return words;
    }

    private static Map<String, Word> countUniqueWords(List<String> words) {
        Map<String, Word> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                Word w =  wordMap.get(word);
                w.setCount(w.getCount()+1);
            } else {
                wordMap.put(word, new Word(word));
            }
        }
        return wordMap;
    }
}
