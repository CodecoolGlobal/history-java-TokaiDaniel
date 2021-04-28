package com.codecool.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListHistory implements History {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        text = text.replaceAll("\n", " ")
                .replaceAll(System.lineSeparator(), " ")
                .replaceAll("\t", " ")
                .replaceAll(" +", " ");
        String[] words = text.split(" ");

        wordsArrayList.addAll(Arrays.asList(words));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        for (int idx = 0; idx < wordsArrayList.size(); idx++) {
            if (wordsArrayList.get(idx).equals(wordToBeRemoved)) {
                wordsArrayList.remove(idx);
                idx--;
            }
        }
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.get(i).equals(from)) {
                wordsArrayList.set(i, to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int i = 0;
        while (i < wordsArrayList.size()) {
            if (!wordsArrayList.get(i).equals(fromWords[0])) {
                i++;
                continue;
            }

            boolean match = true;
            for (int j = 1; j < fromWords.length; j++) {
                int currentIdx = i + j;
                if (currentIdx > (wordsArrayList.size() - 1)) {
                    // end of string
                    match = false;
                    i++;
                    break;
                }

                if (!wordsArrayList.get(currentIdx).equals(fromWords[j])) {
                    match = false;
                    i++;
                    break;
                }
            }

            if (match) {
                for (int j = 0; j < fromWords.length; j++) {
                    wordsArrayList.remove(i);
                }
                for (int j = 0; j < toWords.length; j++) {
                    wordsArrayList.add(i + j, toWords[j]);
                }
                i += toWords.length;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
