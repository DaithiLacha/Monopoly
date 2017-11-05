import javax.swing.*;

public class LandOnSquare {
    public  static void landOnSquare(Player p, Property[] board) {
        if(board[p.getPosition()].getOwner().getName().equals("None")) {
            int ans = JOptionPane.showConfirmDialog(null,
                    "You have landed on " + board[p.getPosition()].getName() + ". Would you like to buy for €" +
                            board[p.getPosition()].getPrice(), "Purchase Property", JOptionPane.YES_NO_OPTION);
            if(ans == JOptionPane.YES_OPTION) {
                if (p.getBalance() >= board[p.getPosition()].getPrice()) {
                    board[p.getPosition()].setOwner(p);
                    p.setBalance(p.getBalance() - board[p.getPosition()].getPrice());
                    JOptionPane.showMessageDialog(null, p.getName() + " now owns this property!");
                    switch (board[p.getPosition()].getColor()) {
                        case "Brown":
                            p.setBrownsOwned(p.getBrownsOwned() + 1);
                            break;
                        default:
                            p.setLightBluesOwned(p.getLightBluesOwned() + 1);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, p.getName() + " can't afford this property!");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Ok. Next Players Turn");
            }
        }else {
            JOptionPane.showMessageDialog(null, p.getName() + " owes " + board[p.getPosition()].getOwner()
                    + " €" + board[p.getPosition()].getRent() + " for rent");
            if(p.getBalance() >= board[p.getPosition()].getRent()) {
                p.setBalance(p.getBalance() - board[p.getPosition()].getRent());
                board[p.getPosition()].getOwner().setBalance(board[p.getPosition()].getOwner().getBalance() + board[p.getPosition()].getRent());
            }else {
                p.setBalance(-1);
                board[p.getPosition()].getOwner().setBalance(board[p.getPosition()].getOwner().getBalance() + p.getBalance());
            }
        }
    }
}
