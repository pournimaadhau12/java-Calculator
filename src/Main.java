import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            System.out.println("Welcome to My Console Calculator");

            Main obj = new Main();
            do {
                char ch = obj.getOperator();
                if (ch == '?') {
                    System.out.println("Wrong operator");
                    return;
                }

                System.out.println("operator is " + ch);

                int a = obj.getOperand(1);
                int b = obj.getOperand(2);

                if (!obj.isOperandValid(ch, b)) {
                    System.out.println("denominator cannot be zero");
                    return;
                }

                System.out.println("Entered numbers are " + a + " , " + b);

                obj.calculate(ch, a, b);

            } while (!obj.isExit());
        }

        public boolean isExit() {
            System.out.println("Would you like to continue - Y/N ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
            return !userInput.equals("Y") && !userInput.equals("y");
        }

        public boolean isOperandValid(char operator, int num2) {
            if (operator == '/' || operator == '%') {
                return num2 != 0;
            }
            return true;
        }

        public void calculate(char op, int num1, int num2) {
            switch (op) {
                case '+':
                    System.out.println("result is " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("result is " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("result is " + (num1 * num2));
                    break;
                case '/':
                    System.out.println("result is " + (num1 / num2));
                    break;
                case '%':
                    System.out.println("result is " + (num1 % num2));
                    break;
            }
        }

        public boolean isOperatorValid(String userInput) {
            int len = userInput.length();
            if (len == 0 || len > 1) {
                return false;
            }
            char ch = userInput.charAt(0);
            return ch == '+' || ch == '-' || ch == '/' || ch == '%' || ch == '*';
        }

        public int getOperand(int inputNumber) {
            System.out.println("Enter operand " + inputNumber);
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }


        public char getOperator() {
            System.out.println("Enter operator: ");
            System.out.println(" '+' , '-' , '/' , '%' , '*' ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
            if (isOperatorValid(userInput)) {
                return userInput.charAt(0);
            } else {
                return '?'; // it means wrong input
            }
        }
    }
