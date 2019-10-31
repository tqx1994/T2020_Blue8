package newpackage;
import java.util.List;

public class Customer {
    public String userName;
    public String customerId;
    public String gender;
    public String firstName;
    public String lastName;
    public String lastLogIn;
    public String dateOfBirth;

}

class account {
    public int accountId;
    public String displayName;
    public String currency;

}

class DepositAccount extends account {
    public String type;
    public int accountNumber;
    public double availableBalance;
    public String dateOfBalance;
    public String accountType;
}

class CreditAccount extends account {
    public String cardNumber;
    public double outstandingAmount;
    public String datePayable;
}