package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {

    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(int amount) {
        if (super.getAmount() + amount > Integer.MAX_VALUE) {
            throw new OverflowException("오버플로어 발생했다. 너 쌉부자네?");
        }
        return super.deposit(amount);
    }
}