package learn.ds.string.manupulation;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * https://www.careercup.com/question?id=19300678
 * @author mohit
 *
 */
public class PossibleCodesFromString {

	public void execute() {
	
		String test = "20";
		boolean withPlus = false;
		Set<String> combinations = decode(test, withPlus);
		Utils.printSet(combinations);
	}
	
	public Set<String> decode(String str, boolean withPlus) {
		
		if(StringUtils.isBlank(str)) {
			return new HashSet<String>();
		}
		if(withPlus == false) {
			return decode("", str, false);
		} else {
			return decode("", str);
		}
	}
	
	private Set<String> decode(String prefix, String test, boolean withPlus) {
		Set<String> result = new HashSet<String>(0);
		
		if(test.length() == 0) {
			result.add(prefix);
			return result;
		} 
		
		if(test.charAt(0) == '0')
			return result;
		
		if(test.length() == 2 && test.charAt(1) == '0') {
			result.add(prefix + getCharValue(Integer.parseInt(test) - '1' + 'a'));
			return result;
		}
	
		result.addAll(decode(prefix + getCharValue(test.charAt(0)), test.substring(1),false));
		
		if(test.length() >= 2 && test.charAt(0) == '0') { 
			result.addAll(decode(prefix + getCharValue(test.charAt(1)), test.substring(2),false));
		} else if(test.length() >= 2 && test.charAt(0) == '1') {
			result.addAll(decode(prefix + getCharValue(10 + test.charAt(1)), test.substring(2),false));
		} else if (test.length() >= 2 && test.charAt(0) == '2' && test.charAt(1) <= 54) {
			result.addAll(decode(prefix + getCharValue(20 + test.charAt(1)), test.substring(2),false));
		}
	
		return result;
	}

	private Set<String> decode(String prefix, String test) {
		Set<String> result = new HashSet<String>(0);
		
		if(test.length() == 0) {
			result.add(prefix);
		} else {
			result.addAll(decode(prefix + getCharValue(test.charAt(0)), test.substring(1)));
			
			if(test.length() >= 2 && test.charAt(0) == '0') { 
				result.addAll(decode(prefix + getCharValue(test.charAt(1)), test.substring(2)));
			} else if(test.length() >= 2 && test.charAt(0) == '1') {
				result.addAll(decode(prefix + getCharValue(10 + test.charAt(1)), test.substring(2)));
			} else if (test.length() >= 2 && test.charAt(0) == '2' && test.charAt(1) <= 54) {
				result.addAll(decode(prefix + getCharValue(20 + test.charAt(1)), test.substring(2)));
			}
		}
		
		return result;
	}
	
	private char getCharValue(int asciiValueAtIndex) {
		char result = 0;
		if (asciiValueAtIndex == 48) {
			result = '+';
		} else {
			result = (char)(asciiValueAtIndex - '1' + 'a');
		}
		return result;
	}
	
}
