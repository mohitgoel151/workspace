package learn.design.parkinglot.main;

import java.util.HashSet;

import learn.design.parkinglot.exceptions.InvalidTimingException;
import learn.design.parkinglot.exceptions.ParkingNotAvailableException;
import learn.design.parkinglot.helper.TimingValidationHelper;
import learn.design.parkinglot.interfaces.ISlot;
import learn.design.parkinglot.model.FourWheelerSlot;
import learn.design.parkinglot.model.Slot;
import learn.design.parkinglot.model.TwoWheelerSlot;


public class ParkingTemp {
	
	private HashSet<Slot> twoWheelerEmptySlots = new HashSet<Slot>();
	private HashSet<Slot> twoWheelerFilledSlots = new HashSet<Slot>();
	
	private HashSet<Slot> fourWheelerEmptySlots = new HashSet<Slot>();
	private HashSet<Slot> fourWheelerFilledSlots = new HashSet<Slot>();
	
	public ParkingTemp() {
		
		twoWheelerEmptySlots.add(new TwoWheelerSlot(11));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(12));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(13));
		
		twoWheelerEmptySlots.add(new TwoWheelerSlot(21));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(22));
		twoWheelerEmptySlots.add(new TwoWheelerSlot(23));
		
		fourWheelerEmptySlots.add(new FourWheelerSlot(31));
		fourWheelerEmptySlots.add(new FourWheelerSlot(32));
		fourWheelerEmptySlots.add(new FourWheelerSlot(33));
		
	}
	
	public int partTwoWheeler() throws InvalidTimingException, ParkingNotAvailableException{
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
		 return s.getSlotId();
		
	}
	
	public void twoWheelerExit(Ticket ticket) {
		twoWheelerEmptySlots.add(new TwoWheelerSlot(ticket.getSlotId()));
	}
	
	
	public void generateTicketForFourWheeler() {
		
	}
	
	private boolean isTwoParkingAvailable() {
		if(twoWheelerEmptySlots.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	private boolean isFourParkingAvailable() {
		if(fourWheelerEmptySlots.size() > 0) {
			return true;
		}
		
		return false;
	}
	

	
	
	

}
