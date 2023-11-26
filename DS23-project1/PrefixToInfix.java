import java.util.Scanner;

public class PrefixToInfix {
    public static StringDoubleEndedQueueImpl convPrefixToInfix(String str){
        StringDoubleEndedQueueImpl s = new StringDoubleEndedQueueImpl();
        char[] charArray = str.toCharArray();
        String[] a = new String[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            a[i] = String.valueOf(charArray[i]);
        }

        if (a[0].equals("+") || a[0].equals("-") || a[0].equals("*") || a[0].equals("/")) {
            return null;
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i].matches("\\d")) {
                s.addLast(a[i]);
            } else if (a[i].equals("+") || a[i].equals("-") || a[i].equals("*") || a[i].equals("/")) {
                String operand1 = s.removeLast();
                String operand2 = s.removeLast();
                String result = "(" + operand2 + a[i] + operand1 + ")";
                s.addLast(result);
            }
        }
        if (s.size() == 1) {
            return s;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Εισαγάγετε την αριθμητική παράσταση σε προθεματική μορφή:");
        String pfe = sc.nextLine();
        sc.close();
        if (pfe != null) {
            StringDoubleEndedQueueImpl ife = convPrefixToInfix(pfe);
            System.out.println("infix μορφη : ");
            ife.printQueue(System.out);
        } else {
            System.out.println("Μη έγκυρη παράσταση.");
        }
    }
}
