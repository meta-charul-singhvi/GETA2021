package uniqueCharacter;
import java.util.HashMap;

public class UniqueCharacter {

	int[] chactersFrequencyArray = new int[26];
	private static HashMap<String, Integer> enteredStrings;
	private String inputString;

	// initializing hash map
	static {
		enteredStrings = new HashMap<String, Integer>();
	}

	// constructor
	public UniqueCharacter(String inputString) throws Exception {

		if (inputString.trim().length() == 0) {
			throw new Exception("Invalid string");
		}

		this.inputString = inputString.replaceAll("\\s", "").toLowerCase();
	}

	/*
	 * function to count unique characters in string
	 * 
	 * @return number of unique characters
	 */
	public int countUniqueCharacters() {

		// checking cache for availability of string
		if (enteredStrings.containsKey(inputString)) {
			return enteredStrings.get(inputString);
		}
		/*
		 * creating a frequency array
		 */
		for (int iterator = 0; iterator < inputString.length(); iterator++) {
			chactersFrequencyArray[(int)inputString.charAt(iterator)-97] +=1;
		}
		int uniqueCharsCount=0;
		
		/*
		 * calculating unique characters in a frequency array
		 */
		for (int iterator = 0; iterator < chactersFrequencyArray.length; iterator++){
			if(chactersFrequencyArray[iterator] != 0) 
				uniqueCharsCount+=1;
		}
		/*
		 * pushing values to hashmap
		 */
		enteredStrings.put(inputString, uniqueCharsCount);
		return uniqueCharsCount;
	}

}