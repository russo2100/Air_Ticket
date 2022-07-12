package manager;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String airport_from;
    private String airport_to;
    private int travelTime;

    public Ticket(int id, int price, String airport_from, String airport_to, int travelTime) {
        this.id = id;
        this.price = price;
        this.airport_from = airport_from;
        this.airport_to = airport_to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirport_from() {
        return airport_from;
    }

    public void setAirport_from(String airport_from) {
        this.airport_from = airport_from;
    }

    public String getAirport_to() {
        return airport_to;
    }

    public void setAirport_to(String airport_to) {
        this.airport_to = airport_to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        }
        if (this.price > o.price) {
            return 1;
        }else {
            return 0;
        }
    }
}
