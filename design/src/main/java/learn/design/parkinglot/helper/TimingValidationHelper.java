package learn.design.parkinglot.helper;

public class TimingValidationHelper {
	
	public static boolean isValidTime() {
		
		int time = getCurrentHour();
		if(time >= 6 && time <= 23) {
			return true;
		}
		return false;
	}
	
	public static int getCurrentHour() {
		return 9;
	}

}
