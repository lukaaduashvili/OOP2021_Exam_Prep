package Sem07.core;

public class Account implements Moodable{
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }

    public void transact(Account other, int transactAmount) {
        if(amount < transactAmount) {
            return;
        }
        amount -= transactAmount;
        other.setAmount(other.getAmount()+transactAmount);
    }

    @Override
    public Boolean getMood(){
        System.out.println("Account Mood");
        return amount > 1000;
    }

}
