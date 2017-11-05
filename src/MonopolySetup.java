import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MonopolySetup {
    public static void createBoard(Property[] properties) {
        List<Player> players = createPlayers();
        Property[] board = properties;

        for(Player p : players) {
            p.rollDice();
            LandOnSquare.landOnSquare(p, board);
            if(p.getBalance() == -1) {
                RemovePlayer.remove(p);
            }
        }
    }

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int ans;
            do {
                String name = JOptionPane.showInputDialog("Enter Name");
                String token = JOptionPane.showInputDialog("Select token \n0 = Dog\n1 = Barrow\n2 = Hat\n3 = Car");
                int tokenAsInt = Integer.parseInt(token);
                players.add(new Player(name, tokenAsInt));
                ans = JOptionPane.showConfirmDialog(null, "Add a New Player?",
                        "players", JOptionPane.YES_NO_OPTION);
            } while (ans == JOptionPane.YES_OPTION);

            if (ans == JOptionPane.NO_OPTION) {
                break;
            }
        }
        return players;
    }

    public static Property[] createProperties() {
        Property crumliin = new Property("Crumlin", "Brown", 60, 10, 50);
        Property kimmage = new Property("Kimmage", "Brown", 60, 10, 50);
        Property rathgar = new Property("Rathgar Road", "Light Blue", 100, 20, 50);
        Property circular = new Property("South Circular Road", "Light Blue", 100, 20, 50);
        Property rathmines = new Property("Ratmines", "Light Blue", 100, 20, 50);
        Property[] properties = new Property [] {crumliin, kimmage, rathgar, circular, rathmines};

        return properties;
    }
}
