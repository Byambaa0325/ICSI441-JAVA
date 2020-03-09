package Exercise_3;

public interface Animal {
	public abstract void moves();
	/*
	 * WHY1 public int getCountLegs() { return 4; }
	 * Interface cannot have defined methods.
	 */
	/*
	 * WHY2 public abstract int getCountLegs() { return 4; }
	 * Interface cannot have abstract members.
	 * Interface cannot have defined methods.
	 */

}
