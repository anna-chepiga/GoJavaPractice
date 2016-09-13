package case_study_1;

public class Merge {
   public static void main(String[] args) {
      char[] array = {'1', '2', 'a', '4', '5'};

      try {
         int result = getNumber(array);
         System.out.println(result);
      } catch (NumberFormatException e) {
         System.out.println(e.getMessage());
      }
   }

   private static int getNumber(char[] chars) {
      StringBuilder outputNumber = new StringBuilder();

      for (char element : chars) {
         if (!Character.isDigit(element)) {
            throw new NumberFormatException("not numbers");
         }
         outputNumber.append(element);
      }

      return Integer.parseInt(outputNumber.toString());
   }
}