import CinemaDAO.TicketsDAOImpl;
import Model.Ticket;

public class Runner {

    public static void main(String[] args) throws Exception {

        TicketsDAOImpl ticketsDAO = new TicketsDAOImpl();

        System.out.println(ticketsDAO.buyTicket(new Ticket(1,1)));
        System.out.println(ticketsDAO.buyTicket(new Ticket(2,2)));

        ticketsDAO.changeSeat(new Ticket(2,4), new Ticket(2,1));
        System.out.println(ticketsDAO.discardTicket(new Ticket(2,1)));
        System.out.println(ticketsDAO.getAllSoldTicket());

    }
}
