package iSets;

public interface ISet {
	/**
	 * 
	 * @param array		an array of bits.
	 * @param index		index of a bit.
	 */
	void setBit(int[] array, int index);
	
	/**
	 * 
	 * @param array		an array of bits.
	 * @param index		index of a bit.
	 * @return 		true, if the bit in index (index) is set to 1.
	 * 				false otherwise.
	 */
	boolean isElement(int[] array, int index);
	
	/**
	 * 
	 * @param n1 determine first set to get union.
	 * @param n2 determine second set to get union.
	 */
	void union(int n1, int n2);
	
	/**
	 * 
	 * @param n1 determine first set to get union.
	 * @param n2 determine second set to get union.
	 */
	void intersection(int n1, int n2);
	
	/**
	 * 
	 * @param n determine a set to get its complement.
	 */
	void complement(int n);
}
