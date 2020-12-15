package CinemaDAO;

import Model.Ticket;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAOImpl implements TicketsDAO {

    private Connection connection;

    public TicketsDAOImpl() throws Exception{
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1");
    }

    @Override
    public String buyTicket(Ticket ticket) throws Exception {
        int row = ticket.getRow();
        int seat = ticket.getSeat();
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO tickets (row , seat) values(" + row + "," + seat + ")");
        return "Successfully acquired ticket: Row " + row + " seat" + seat;
    }

    @Override
    public List<Ticket> getAllSoldTicket() throws Exception{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM tickets");

        List <Ticket> ticketList = new ArrayList<>();

        while(result.next()){
            int row = result.getInt("row");
            int seat = result.getInt("seat");
            Ticket ticket = new Ticket(row,seat);
            ticketList.add(ticket);
        }
        return ticketList;
    }

    //First Parameter old ticket information and second parameter new ticket information

    @Override
    public String changeSeat(Ticket ticket, Ticket newTicket) throws Exception {
        Statement statement = connection.createStatement();
        statement.execute("UPDATE tickets SET row = " + newTicket.getRow() + ", seat = " + newTicket.getSeat()
                + "WHERE row = "  + ticket.getRow() + "AND seat = " + ticket.getSeat());
        return null;
    }

    @Override
    public String discardTicket(Ticket ticket) throws Exception {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM tickets WHERE row = " + ticket.getRow() + "AND seat = " + ticket.getSeat());

        return "Your Ticket: Row --> " + ticket.getRow() + " Seat --> " + ticket.getSeat() + " has been discarded";
    }
}
