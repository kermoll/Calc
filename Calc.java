import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {



        static Scanner scanner = new Scanner(System.in);
        static int num1, num2;
        static char operation;
        static boolean[] romanNumber=new boolean[2];
        static int result;

        public static void main(String[] args) {

            System.out.println("Введите пример (2+6) или (III+I): ");
            String userKey = scanner.nextLine();
            char[] charCalArray = new char[10];
            for (int i = 0; i < userKey.length(); i++) {
                charCalArray[i] = userKey.charAt(i);
                if (charCalArray[i] == '+') {
                    operation = '+';
                }
                if (charCalArray[i] == '-') {
                    operation = '-';
                }
                if (charCalArray[i] == '*') {
                    operation = '*';
                }
                if (charCalArray[i] == '/') {
                    operation = '/';
                }
            }

            String stringCal = String.valueOf(charCalArray);
            String[] stringsCalArray = stringCal.split("[/*+-]");
            String number1String = stringsCalArray[0].trim();
            String number2String = stringsCalArray[1].trim();
            num1 = convertToArabic(number1String,0);
            num2 = convertToArabic(number2String,1);
            if ((num1 < 1) | (num2 < 1) | (num1 > 10) | (num2 > 10) | (romanNumber[0] != romanNumber[1])) {
                result = 0;
            } else {
                result = calculated(num1, num2, operation);
                String resultRom = roman(result);
                if (result < 1) {
                    System.out.println("Не возможно посчитать");
                    result = 0;
                } else {
                    System.out.println(number1String + " " + operation + " " + number2String + " = " + resultRom);

                }

            }
            // Я не знаю как пазделить тут

            num1 = Integer.parseInt(number1String);
            num2 = Integer.parseInt(number2String);
            result = calculated(num1, num2, operation);
            System.out.println(num1+" "+operation+" "+num2+" = "+result);

        }
        private static String roman(int indexOfRomNumbers) {
            String[] romNumbers = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            final String stringRomNumber=romNumbers[indexOfRomNumbers];
            return stringRomNumber;
        }
        private static int convertToArabic(String number,int indexStringCalArray){
            try {
                switch (number) {
                    case "I":
                        romanNumber[indexStringCalArray]=false;
                        return 1;
                    case "II":
                        romanNumber[indexStringCalArray]=false;
                        return 2;
                    case "III":
                        romanNumber[indexStringCalArray]=false;
                        return 3;
                    case "IV":
                        romanNumber[indexStringCalArray]=false;
                        return 4;
                    case "V":
                        romanNumber[indexStringCalArray]=false;
                        return 5;
                    case "VI":
                        romanNumber[indexStringCalArray]=false;
                        return 6;
                    case "VII":
                        romanNumber[indexStringCalArray]=false;
                        return 7;
                    case "VIII":
                        romanNumber[indexStringCalArray]=false;
                        return 8;
                    case "IX":
                        romanNumber[indexStringCalArray]=false;
                        return 9;
                    case "X":
                        romanNumber[indexStringCalArray]=false;
                        return 10;
                    default:
                        switch (number){
                            case "1":
                                romanNumber[indexStringCalArray]=true;
                                return 1;
                            case "2":
                                romanNumber[indexStringCalArray]=true;
                                return 2;
                            case "3":
                                romanNumber[indexStringCalArray]=true;
                                return 3;
                            case "4":
                                romanNumber[indexStringCalArray]=true;
                                return 4;
                            case "5":
                                romanNumber[indexStringCalArray]=true;
                                return 5;
                            case "6":
                                romanNumber[indexStringCalArray]=true;
                                return 6;
                            case "7":
                                romanNumber[indexStringCalArray]=true;
                                return 7;
                            case "8":
                                romanNumber[indexStringCalArray]=true;
                                return 8;
                            case "9":
                                romanNumber[indexStringCalArray]=true;
                                return 9;
                            case "10":
                                romanNumber[indexStringCalArray]=true;
                                return 10;
                            default:
                                break;
                        }
                }

            } catch (InputMismatchException e) {
                throw new InputMismatchException("Не верно введено");
            }
            return -1;
        }

        private static int calculated(int num1, int num2, char operation) {
            switch (operation) {
                case '/':
                    result = num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
            return result;
        }
    }
