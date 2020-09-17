public abstract class BankAccount extends Investment {

    private String accountNumber;

    protected BankAccount() {
        super();
        this.accountNumber = "none";
    }

    protected BankAccount(String type, String name, String accountNumber) {
        super(type, name);
        setAccountNumber(accountNumber);
    }

    @Override
    public String toString() {
        return super.toString() + "Account Number: " + accountNumber + "\n" ;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
