package com.codecool.history;

import java.util.*;

public class LinkedListHistory implements History {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        text = text.replaceAll("\\s+| +", " ");
        String[] words = text.split(" ");

        wordsLinkedList.addAll(Arrays.asList(words));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsLinkedList.removeIf(s -> s.equals(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        ListIterator<String> it = wordsLinkedList.listIterator();
        while (it.hasNext()) {
            if (it.next().equals(from)) {
                it.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        ListIterator<String> it = wordsLinkedList.listIterator();
        while (it.hasNext()) {
            if (!it.next().equals(fromWords[0])) {
                continue;
            }
            boolean match = false;
            int counter = 1;
            if (fromWords.length == 1) match = true;
            else {
                while (it.hasNext()) {
                    if (it.next().equals(fromWords[counter])) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == fromWords.length) {
                        match = true;
                        break;
                    }
                }
            }

            for (int i = 1; i < counter; i++) {
                it.previous();
            }

            if (match) {
                it.previous();
                int length = Math.max(fromWords.length, toWords.length);
                counter = 0;
                while (it.hasNext()) {
                    it.next();
                    if (fromWords.length > counter && toWords.length > counter) {
                        it.set(toWords[counter]);
                    } else if (fromWords.length > counter) {
                        it.remove();
                    }
                    counter++;
                    if (fromWords.length <= counter){
                        while (counter < length) {
                            it.add(toWords[counter]);
                            counter++;
                        }
                    }
                    if (counter >= length) break;;

                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
