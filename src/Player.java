import javax.swing.*;

public class Player {
    private String name, piece;
    private static String[] pieces = {"Dog", "Hat", "Barrow", "Car"};
    private int balance, position, brownsOwned, lightBluesOwned;
    private int brownHouses, lightBlueHouses;
    private static int rolls;

    public Player() {
        this("None", 0);
    }

    public Player(String name, int piece) {
        setName(name);
        setPiece(pieces[piece]);
        setBalance(2500);
        setBrownsOwned(0);
        setBrownHouses(0);
        setLightBluesOwned(0);
        setLightBlueHouses(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getBrownsOwned() {
        return brownsOwned;
    }

    public void setBrownsOwned(int brownsOwned) {
        this.brownsOwned = brownsOwned;
    }

    public int getLightBluesOwned() {
        return lightBluesOwned;
    }

    public void setLightBluesOwned(int lightBluesOwned) {
        this.lightBluesOwned = lightBluesOwned;
    }

    public int getBrownHouses() {
        return brownHouses;
    }

    public void setBrownHouses(int brownHouses) {
        this.brownHouses = brownHouses;
    }

    public int getLightBlueHouses() {
        return lightBlueHouses;
    }

    public void setLightBlueHouses(int lightBlueHouses) {
        this.lightBlueHouses = lightBlueHouses;
    }

    public void rollDice() {

        int die1 = (int)((Math.random() * 2) + 1), die2 = (int)((Math.random() * 2) + 1);
        JOptionPane.showMessageDialog(null, "Die 1 is a " + die1);
        JOptionPane.showMessageDialog(null, "Die 2 is a " + die2);
        setPosition(getPosition() + (die1 + die2));

        if(die1 == die2) {
            JOptionPane.showMessageDialog(null, "Rolled a double go again!");
            rolls++;
            rollDice();
        }

        if(rolls == 3) {
            JOptionPane.showMessageDialog(null, "Rolled 3 doubles in a row go to Jail!");
            setPosition(10);
        }

        if(getPosition() >= 5) {
            JOptionPane.showMessageDialog(null, "You passed GO collect €200");
            setBalance(getBalance() + 200);
            setPosition(getPosition() - 40);
        }

        rolls = 0;
    }

    public String toString() {
        return super.toString() + "\nPiece - " + getPiece() +
                "\nCurrent Balance - " + getBalance();
    }
}
