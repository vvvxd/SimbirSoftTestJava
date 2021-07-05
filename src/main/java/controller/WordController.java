package controller;

import model.Word;
import repository.WordRepository;

import java.util.Map;

public class WordController {
    private final WordRepository WordRepository = new WordRepository();

    public Map<String, Word> parseWords(String text) {
        return WordRepository.parseWords(text);
    }
}
