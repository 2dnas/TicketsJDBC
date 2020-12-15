package Model;

public class Ticket {

    private long id;

    private int row;

    private int seat;

    private boolean free;

    public Ticket(){};


    public Ticket(int row, int seat) {
        this.row = row;
        this.seat = seat;
        this.free = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Ticket" +
                ": Row  --> " + row
                + " Seat --> " + seat + "\n";
    }
}
