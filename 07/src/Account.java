public class Account implements Moodable, Valuable, Comparable<Account> {
    private int value;

    public Account(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean getMood() {
        return value > 1000000;
    }

    @Override
    public int compareTo(Account b) {
        if (b == null) {
            return 1;
        }
        return this.getValue() - b.getValue();
    }
}
