package CinemaDAO;


import Model.Ticket;

import java.util.List;

public interface TicketsDAO {

     String buyTicket(Ticket ticket) throws Exception;

     List<Ticket> getAllSoldTicket() throws Exception;

     String changeSeat(Ticket ticket, Ticket newTicket) throws Exception;

     String discardTicket(Ticket ticket) throws Exception;

}
