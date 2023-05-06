package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    List<String> words = List.of("samochód", "chłopak", "pies", "laptop", "napój", "okno", "krzesło");
    String word;
    char[]userWord;
    int lives = 3;
    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '-');

        while (!gameEnd()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Podaj kolejną literę");
            System.out.println("Pozostało żyć: " + lives);

            char letter = scanner.nextLine().charAt(0);

            Checkletter(letter);
        }

        if (lives == 0) {
            System.out.println("Przegrałeś :( ");
        } else {
            System.out.println("Wygrałeś :D ");
        }
            scanner.close();
    }

    private void Checkletter(char letter) {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }

            }
        if (!foundLetter) {
            System.out.println("Nie ma takiej litery :(");
            lives--;

        }
    }

    private boolean gameEnd() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}
