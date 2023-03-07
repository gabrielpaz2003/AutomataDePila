import java.util.Scanner;
import java.util.Stack;

public class Automata {

    public static boolean accept(String input) {
        Stack<Character> stack = new Stack<>();
        int currentState = 0;
        int inputIndex = 0;
        
        while (inputIndex < input.length()) {
            char symbol = input.charAt(inputIndex);
            
            switch (currentState) {
                case 0:
                    if (symbol == 'a') {
                        stack.push('a');
                        currentState = 1;
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    if (symbol == 'a') {
                        stack.push('a');
                    } else if (symbol == 'b') {
                        if (!stack.empty() && stack.peek() == 'a') {
                            stack.pop();
                            currentState = 2;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case 2:
                    if (symbol == 'b') {
                        if (!stack.empty() && stack.peek() == 'a') {
                            stack.pop();
                            currentState = 2;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
            }
            
            inputIndex++;
        }
        
        return currentState == 2 && stack.empty();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese una cadena de caracteres: ");
        String input = scanner.nextLine();
        
        if (accept(input)) {
            System.out.println("La cadena es aceptada por el autómata de pila.");
        } else {
            System.out.println("La cadena es rechazada por el autómata de pila.");
        }
    }

}

