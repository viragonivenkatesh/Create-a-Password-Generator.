import java.security.SecureRandom;
import java.util.Scanner;

public class password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        System.out.print("Enter the character set (1: Letters, Numbers | 2: Letters, Numbers, Special Characters): ");
        int characterSetChoice = scanner.nextInt();
        
        String characterSet = "";
        if (characterSetChoice == 1) {
            characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        } else if (characterSetChoice == 2) {
            characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        } else {
            System.out.println("Invalid choice for character set.");
            return;
        }
        
        String generatedPassword = generatePassword(length, characterSet);
        System.out.println("Generated Password: " + generatedPassword);
        
        scanner.close();
    }

    public static String generatePassword(int length, String characterSet) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            char randomChar = characterSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}