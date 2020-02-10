import java.util.ArrayList;

public class LoopFun
{

      /**
       * Given a number, return the factorial of that number.
       * For example, given 5, the factorial is 5 x 4 x 3 x 2 x 1 which should return 120.
       * @param number
       * @return the factorial of the number
       */
      public Integer factorial(Integer number){
          return (number == 1 || number == 0) ? 1 : number * factorial(number - 1);
      }

      /**
       * Given a phrase, get the acronym of that phrase. Acronym is the combination of
       * the first character of each word in upper case.
       * For example, given "Ruby on Rails", this method will return "ROR"
       * @param phrase
       * @return Upper case string of the first letter of each word
       */
      public String acronym(String phrase) {
          String[] splitted = phrase.split("\\s+");
          String toRet = "";
          for (String s : splitted) {
               toRet += s.charAt(0);
          }
          return toRet.toUpperCase();
      }

      /**
       * To prevent anyone from reading our messages, we can encrypt it so it will only be readable by its
       * intended audience. This method encrypt the message by shifting the letter by 3 characters. If the character is
       * at the end of the alphabet, it will wraps around.
       * For example:
       *  'a' => 'd'
       *  'w' => 'z'
       *  'x' => 'a'
       *  'y' => 'b'
       * @param word
       * @return the encrypted string by shifting each character by three character
       */
      public String encrypt(String word) {
          // 97 - 122 'Lowercase'
          // 65 - 90 'Uppercase'

          ArrayList<Character> chars = new ArrayList<>();
          ArrayList<Character> modChars = new ArrayList<>();
          StringBuilder build = new StringBuilder(word);
          for (int i = 0; i < build.length(); i++) {
              chars.add(build.charAt(i));
          }

          for (char c : chars) {
              char newValue = c;
              newValue += 3;
              char oldVal = c;

              if ((newValue > 64 && newValue < 91) || (newValue > 96 && newValue < 123)) {
                  modChars.add(newValue);
              }
              else if (oldVal > 119) {
                  int dif = 3 - (122 - oldVal);
                  char nnew = 96;
                  nnew += dif;
                  modChars.add(nnew);
              }
              else if (oldVal > 88) {
                  int dif = 3 - (91 - oldVal);
                  char nnew = oldVal;
                  nnew += dif;
                  modChars.add(nnew);
              }
          }

          String toRet = "";
          for (Character c : modChars) {
              toRet += c;
          }

          return toRet;
      }
}
