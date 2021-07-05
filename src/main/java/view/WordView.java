package view;

import controller.WordController;
import model.Word;
import utiles.Parser;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class WordView {
    private final WordController WordController = new WordController();
    Scanner scanner = new Scanner(System.in);

    public void parseWords() throws IOException {
        String name;
        System.out.println("Введите адрес web-страницы. Пример входной строки: https://www.simbirsoft.com/: ");
        name = scanner.nextLine();
        Map<String, Word> words = WordController.parseWords(Parser.parseHTML(name));
        for (Map.Entry<String, Word> word : words.entrySet()) {
            System.out.println(word.getValue().toString());
        }
    }
}
