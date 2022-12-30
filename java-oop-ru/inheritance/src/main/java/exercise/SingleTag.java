package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
      /*  SingleTag наследуется от класса Tag и описывает одиночный html тег.
      Конструктор класса принимает два аргумента:
        Имя тега в виде строки
        Атрибуты тега, которые представлены словарём Map со строковыми ключами и значениями.

        В классе реализуйте публичный метод toString(), который возвращает текстовое представление тега в виде строки.*/

  /*      Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        img.toString(); // "<img class="v-10" id="wop"> */

        SingleTag (String name, Map <String, String> attributes) {
                super(name, attributes);
        }


        public String toString() {
                StringBuilder output = new StringBuilder("<" + this.name);
                for(Map.Entry<String, String> item : attributes.entrySet()){
                        output.append(" ")
                                .append(item.getKey())
                                .append("=")
                                .append("\"")
                                .append(item.getValue())
                                .append("\"");
                }
                output.append(">");
                return output.toString();
        }

}
// END
