package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
        public static boolean scrabble(String chars, String word) {
                System.out.println(chars + " " + word);

                String wordLowerCase = word.toLowerCase();
                List<Character> listChars = new ArrayList<>();
                int result = 0;

                if (chars.length() == 0) {
                        return false;
                }

                for (int i = 0; i < chars.length(); i++) {
                        listChars.add(chars.charAt(i));
                }


                for (int j = 0; j < word.length(); j++) {
                        if (listChars.contains(wordLowerCase.charAt(j))) {
                                Character current = wordLowerCase.charAt(j);
                                listChars.remove(current);
                                result++;
                        } else {
                                break;
                        }
                }

                if (result == word.length()) {
                        return true;
                } else {
                        return false;
                }


        }
}
//END
