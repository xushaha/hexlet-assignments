package exercise;

import java.util.Arrays;
// BEGIN
public class ReversedSequence implements CharSequence{
        String text;

        public ReversedSequence(String input) {
          this.text = input;
        }

        @Override
        public int length() {
            char[] result = this.text.toCharArray();
            return result.length;
        }

        @Override
        public char charAt(int i) {
            char[] result = this.text.toCharArray();
            return result[i];
        }

        public String toString() {
                char[] toArray = this.text.toCharArray();
                var result = "";
                for (int i = (toArray.length - 1); i >=0 ; i--) {
                        result = result + toArray[i];
                }
                return result;
        }

        @Override
        public CharSequence subSequence(int i, int i1) {
                char[] toArray = this.text.toCharArray();
                var result = "";
                for (int j = i; j < i1; j++) {
                        result += toArray[j];
                }
                return result;
        }
}
// END
