package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> NameToHeight = new HashMap<>();
		NameToHeight.put("Billy", 170);
		NameToHeight.put("Bob", 177);
		NameToHeight.put("Joe", 175);
		NameToHeight.put("Harrison", 179);
		System.out.println("ayo what name would you like");
		String name = in.next();
		while (!name.equals("quit")) {
			if (NameToHeight.containsKey(name)) {
				System.out.println("that dude's height is " + NameToHeight.get(name));
			} else {
				System.out.println("we don't have that name");
			}
			System.out.println("ayo what name would you like");
			name = in.next();
		}
	}
}
