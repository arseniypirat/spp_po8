package Lab4;
import java.util.ArrayList;
import java.util.Date;

public class task1 {
    public static void main(String[] args){
        Account account = new Account(2232);
        account.makeDeposit(10000);
        account.makePayment(200);
        account.makeWithdrawal(2322);
        account.makeTransaction(2500, Account.TransactionType.DEPOSIT);
        account.makeDeposit(5555);
        account.makePayment(4344);
        account.makeWithdrawal(250);
        account.printTransactionsHistory();
    }
}

class Account{
    public enum TransactionType{
        WITHDRAWAL, // Снятие
        PAYMENT,    // Платеж
        DEPOSIT     // Поступление
    }
    private int accountNumber;
    private double balance;
    private ArrayList<Transaction> transactionsHistory;

    public Account(int cardNumber){
        this.accountNumber = cardNumber;
        this.balance = 0.0;
        transactionsHistory = new ArrayList<>();
    }

    public void makeDeposit(double deposit){
        if(deposit<=0){
            System.out.println("Сумма депозита должна быть больше 0.");
        }
        else{
            this.balance+=deposit;
            transactionsHistory.add(new Transaction(deposit,TransactionType.DEPOSIT,this.balance));
        }
    }

    public void makeWithdrawal(double amount){
        if(amount>0 && amount<=balance){
            this.balance-=amount;
            transactionsHistory.add(new Transaction(amount,TransactionType.WITHDRAWAL,this.balance));
        }
        else{
            System.out.println("Некорректная сумма снятия или недостаточно средств на счете.");
        }
    }

    public void printTransactionsHistory(){
        System.out.println("История транзацикций:");
        for (Transaction transaction : this.transactionsHistory) {
            System.out.println(transaction);
        }
    }
    public void makePayment(double amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionsHistory.add(new Transaction(amount, TransactionType.PAYMENT,this.balance));
        } else {
            System.out.println("Недостаточно средств для проведения платежа или сумма некорректна.");
        }
    }

    public void makeTransaction(double amount,TransactionType type) {
        switch (type){
            case TransactionType.DEPOSIT:
                this.makeDeposit(amount);
                break;
            case TransactionType.PAYMENT:
                this.makePayment(amount);
                break;
            case TransactionType.WITHDRAWAL:
                this.makeWithdrawal(amount);
                break;
            default:
                System.out.println("error!");
        }
    }
    class Transaction{
        private Date transactionDate;
        private double amount;
        private double currentBalance;//остаток на счете после транзацкии
        private TransactionType type;

        public Transaction(double amount, TransactionType type , double currentBalance){
            this.amount = amount;
            this.type = type;
            this.currentBalance = Account.this.balance;
            this.transactionDate = new Date();
        }

        public Date getTransactionDate() {
            return transactionDate;
        }

        public double getAmount() {
            return amount;
        }

        public TransactionType getType() {
            return type;
        }

        public void setTransactionDate(Date transactionDate) {
            this.transactionDate = transactionDate;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setType(TransactionType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Тип транзации: " + this.type + ", Дата: " + this.transactionDate +
                    ", Cумма: " + this.amount + " BYN, Остаток на счету: " + this.currentBalance + " BYN;";
        }
    }

}

