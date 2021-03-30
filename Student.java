package college;

public class Student {
	private final String name;
	private final int rank;
	private final String[] choices;
	/**
	 * Constructor
	 * @param name
	 * @param rank
	 * @param choices
	 */
	public Student(String name, int rank, String[] choices) {
		this.name = name;
		this.rank = rank;
		this.choices = choices;

	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @return the choices
	 */
	public String[] getChoices() {
		return choices;
	}

	
}