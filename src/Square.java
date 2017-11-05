public abstract class Square {
    private String name;
    private Player owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +"\nOwner: " + getOwner();
    }
}
