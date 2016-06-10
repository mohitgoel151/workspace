package learn.ds.string.manupulation;

import java.util.Set;

public class Utils {
	
	public static <T> void printSet(Set<T> set) {
		if(Utils.isEmpty(set)) {
			System.out.println("set is empty");
		}
		for (T value : set) {
			System.out.println(String.valueOf(value));
		}
	}
	
	public static <T> boolean isEmpty(Set<T> set) {
		if ((set == null) || (set.size() == 0)) {
			return true;
		}
		return false;
		
	}

}
