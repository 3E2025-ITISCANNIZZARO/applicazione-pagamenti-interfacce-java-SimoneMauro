// Definizione dell'interfaccia PaymentStrategy
interface PaymentStrategy {
    void pay(double amount); // Metodo per eseguire il pagamento
}

// Implementazione del pagamento tramite carta di credito
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    
    // Costruttore per inizializzare i dettagli della carta
    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public void pay(double amount) {
        // Simulazione del pagamento tramite carta di credito
        System.out.println("Pagamento di " + amount + " effettuato con carta di credito: " + cardNumber);
    }
}

// Implementazione del pagamento tramite PayPal
class PayPalPayment implements PaymentStrategy {
    private String email;
    
    // Costruttore per inizializzare l'email dell'account PayPal
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public void pay(double amount) {
        // Simulazione del pagamento tramite PayPal
        System.out.println("Pagamento di " + amount + " effettuato con PayPal: " + email);
    }
}

// Implementazione del pagamento tramite bonifico bancario
class BankTransferPayment implements PaymentStrategy {
    private String iban;
    
    // Costruttore per inizializzare l'IBAN
    public BankTransferPayment(String iban) {
        this.iban = iban;
    }
    
    @Override
    public void pay(double amount) {
        // Simulazione del pagamento tramite bonifico bancario
        System.out.println("Pagamento di " + amount + " effettuato tramite bonifico bancario: " + iban);
    }
}

// Classe ShoppingCart che utilizza una PaymentStrategy per eseguire il pagamento
class ShoppingCart {
    private PaymentStrategy paymentStrategy; // Strategia di pagamento da utilizzare
    
    // Metodo per impostare la strategia di pagamento
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    // Metodo per eseguire il pagamento
    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Nessun metodo di pagamento selezionato!");
        } else {
            paymentStrategy.pay(amount); // Esegue il pagamento utilizzando la strategia selezionata
        }
    }
}

// Classe principale per testare il sistema di pagamento
public class PaymentApplication {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(); // Creazione di un carrello
        
        // Imposta e usa il pagamento con carta di credito
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Mario Rossi"));
        cart.checkout(100.0);
        
        // Imposta e usa il pagamento con PayPal
        cart.setPaymentStrategy(new PayPalPayment("mario.rossi@email.com"));
        cart.checkout(50.0);
        
        // Imposta e usa il pagamento con bonifico bancario
        cart.setPaymentStrategy(new BankTransferPayment("IT60X0542811101000000123456"));
        cart.checkout(200.0);
    }
}

