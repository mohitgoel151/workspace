package learn.design.parkinglot.main;


public class Ticket {
	
	private long time;
	private int slotId;
	
	public int getSlotId() {
		return slotId;
	}

	public Ticket(int id) {
		slotId = id;
		time = System.currentTimeMillis();
	}

}
