package learn.design.parkinglot.main;

import java.util.HashSet;

import learn.design.parkinglot.exceptions.InvalidTimingException;
import learn.design.parkinglot.exceptions.ParkingNotAvailableException;
import learn.design.parkinglot.helper.TimingValidationHelper;
import learn.design.parkinglot.interfaces.ISlot;
import learn.design.parkinglot.model.Slot;
import learn.design.parkinglot.model.TwoWheelerSlot;


public class Parking {
	
	private HashSet<Slot> twoWheelerEmptySlots = new HashSet<Slot>();
	private HashSet<Slot> twoWheelerFilledSlots = new HashSet<Slot>();
	
	
	
	public Parking() {
		
		twoWheelerEmptySlots.add(new TwoWheelerSlot(11));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(12));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(13));
		
		twoWheelerEmptySlots.add(new TwoWheelerSlot(21));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(22));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(23));		
	}
	
	public int parkTwoWheeler() throws InvalidTimingException, ParkingNotAvailableException{
		if(TimingValidationHelper.isValidTime() == false) {
			throw new InvalidTimingException();
		}
		return generateTicketForTwoWheeler();		
	}
	
	public int generateTicketForTwoWheeler() throws ParkingNotAvailableException {
		
		if(isTwoParkingAvailable() == false) {
			throw new ParkingNotAvailableException();
		}
		
		 ISlot s = (ISlot) twoWheelerEmptySlots.toArray()[0];
		 System.out.println(s.getSlotId());
		 twoWheelerEmptySlots.remove(s);
		 
		 Ticket parkTicket = new Ticket(s.getSlotId());
		 
		 return s.getSlotId();
		
	}
	
	public void twoWheelerExit(Ticket ticket) {
		
		twoWheelerEmptySlots.add(new TwoWheelerSlot(ticket.getSlotId()));
	}
	
	private boolean isTwoParkingAvailable() {
		if(twoWheelerEmptySlots.size() > 0) {
			return true;
		}
		return false;
	}

	

}
