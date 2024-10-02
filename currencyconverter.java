import java.util.Scanner;

public class currencyconverter {

    // Method to print available currencies
    public static void displayCurrencies() {
        System.out.println("Available currencies:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");
        System.out.println("4. JPY (Japanese Yen)");
    }

    // Method to get exchange rate based on currency code
    public static double getRate(String currency) {
        String[] currencies = {"USD", "EUR", "GBP", "JPY"};
        double[] rates = {1.0, 0.93, 0.81, 144.50};  // Corresponding exchange rates

        for (int i = 0; i < currencies.length; i++) {
            if (currency.equals(currencies[i])) {
                return rates[i];
            }
        }
        return -1;  // Return -1 if currency code is not found
    }

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fromCurrency, toCurrency;
        double amount, result;

        while (true) {
            displayCurrencies();

            // Input for from currency
            System.out.print("Enter the currency to convert from (e.g., USD): ");
            fromCurrency = scanner.nextLine().toUpperCase();
            
            // Input for to currency
            System.out.print("Enter the currency to convert to (e.g., EUR): ");
            toCurrency = scanner.nextLine().toUpperCase();

            // Input for amount
            System.out.print("Enter the amount to convert: ");
            amount = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character

            // Get exchange rates for both currencies
            double fromRate = getRate(fromCurrency);
            double toRate = getRate(toCurrency);

            // Validate if both currencies are valid
            if (fromRate == -1 || toRate == -1) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            // Perform the conversion
            result = (amount / fromRate) * toRate;

            // Display the result
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);

            // Option to continue or exit
            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using the currency converter!");
        scanner.close();
    }
}