import java.util.Scanner;

public class App {
    static final Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // App app = new App();
        Calculator calc = new Calculator();

        String mathPrompt = ("Please provide a simple math equation: ");
        String continuePrompt = ("Do you want to do another one? It will use the result of your last calculation. (y/n) ");
        
        double num1;
        double num2;
        String operator;

        boolean cont = true;
        boolean firstTime = true;
        double nextValue = 0;
        while (cont) {
            if (firstTime == true) {
                // get user input
                String userInput = getString(mathPrompt); // format should be "5 + 13" for example

                // split string and store numbers and arithmitic operation accordingly
                String[] arr = null;
                arr = userInput.split(" ");
                num1 = Double.parseDouble(arr[0]);
                operator = arr[1];
                num2 = Double.parseDouble(arr[2]);

                firstTime = false;
            } else {
                String mathPromptNew = ("Please finish the math equation: " + nextValue + " ");
                String userInputNew = getString(mathPromptNew);
                String[] arrNew = null;
                arrNew = userInputNew.split(" ");
                num1 = nextValue;
                operator = arrNew[0];
                num2 = Double.parseDouble(arrNew[1]);
            }
            

            if (operator.equals("+")) {
                double sum = calc.add(num1, num2);
                System.out.println(sum);
                nextValue = sum;
            }
            if (operator.equals("-")) {
                double diff = calc.subtract(num1, num2);
                System.out.println(diff);
                nextValue = diff;
            }
            if (operator.equals("*")) {
                double product = calc.multiply(num1, num2);
                System.out.println(product);
                nextValue = product;
            }
            if (operator.equals("/")) {
                double quotient = calc.divide(num1, num2);
                System.out.println(quotient);
                nextValue = quotient;
            }

            // exit option
            if (getString(continuePrompt).equalsIgnoreCase("n")) {
                System.out.println("Goodbye");
                cont = false;
                break;
            }
        }
    }

    private static String getString(String prompt) {
        System.out.print(prompt);
        String userInput = inputScanner.nextLine();
        return userInput;
    }

    private static double getDouble(String prompt) {
        System.out.print(prompt);
        double userInput = inputScanner.nextDouble();
        inputScanner.nextLine();
        return userInput;
    }
}

