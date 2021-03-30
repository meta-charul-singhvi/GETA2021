package college;

public class Program {
	private final String program;
	private int seat;
	/**
	 * @param program
	 * @param seat
	 */
	public Program(String program, int seat) {
		this.program = program;
		this.seat = seat;
	}
	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}
	/**
	 * @return the seat
	 */
	public int getSeat() {
		return seat;
	}
	/**
	 * @param seat the seat to set
	 */
	public void decrSeat() {
		this.seat = this.seat-1;
	}

	
}