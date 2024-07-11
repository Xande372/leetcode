public class ReverteInteiros {

    public static int reverse(int x) {
        int reversed = 0;
        
        while(x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Verifica se a inversão causará um overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow positivo
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Overflow negativo
            }

            reversed = reversed * 10 + digit;
        }
        
        return reversed;
    }

    public static void main(String[] args) {
        
        int x = 123;
        System.out.println(reverse(x));
    }
}