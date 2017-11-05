public class Property extends Square {
    private int price, rent, housePrice, houses;
    private String color;

    public Property() {
        this("Unknown", "Undetermined", 0, 0, 0);
    }

    public Property(String name, String color, int price, int rent, int housePrice) {
        setName(name);
        setOwner(new Player());
        setColor(color);
        setPrice(price);
        setRent(rent);
        setHousePrice(housePrice);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return super.toString() + "\nColour: " + getColor() +  "\nPrice: " + getPrice() + "\nRent: " + getRent();
    }
}
