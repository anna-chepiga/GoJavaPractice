package case_study_2;

import java.util.HashMap;
import java.util.Map;

public class StringConvert {
   private static final Map<Character, Integer> CONVERTER = new HashMap<>();

   static {
      int i;
      char c;
      for (i = 0, c = 'a'; i <= 9 && c <= 'j'; i++, c++) {
         CONVERTER.put(c, i);
      }
   }

   public static void main(String[] args) {
      String input = "dD jb";

      try {
         int convertedInput = convertToNumbers(input);
         System.out.println("string \"" + input + "\" is " + convertedInput + " in numbers");
      } catch (NullPointerException e) {
         System.out.println(e.getMessage());
      }

      /*int convert = convertToNumbers(input);
      if (convert != -1) {
         System.out.println("string \"" + input + "\" is " + convert + " in numbers");
      } else {
         System.out.println("error: string contains unsupported symbols");
      }*/
   }

   private static int convertToNumbers(String input) {
      char[] inputInChars = input.toLowerCase().toCharArray();
      String inputInNumbers = "";
      StringBuilder builder = new StringBuilder();

      for (char index : inputInChars) {
         int number;

         if (CONVERTER.containsKey(index)) {
            number = CONVERTER.get(index);
            String s = String.valueOf(number);
            builder.append(s);
            inputInNumbers = builder.toString();
         } else {
            //return -1;
            throw new NullPointerException("error: string contains unsupported symbols");
         }
      }
      return Integer.parseInt(inputInNumbers);
   }
}