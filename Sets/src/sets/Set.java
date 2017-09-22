package sets;

import java.util.ArrayList;
import iSets.ISet;

public class Set implements ISet {
	
	private int sizeOfUniverse;
	final int intBits = 32;
	private int size;
	int[] A;
	int[] B;
	int[] result;
	public ArrayList<String> universe;
	
	public Set(int sizeOfUniverse) {
		this.sizeOfUniverse = sizeOfUniverse;
		this.size = (sizeOfUniverse - 1) / intBits + 1;
		A = new int[size];
		B = new int[size];
		result = new int[size];
		universe = new ArrayList<String>(sizeOfUniverse);
	}
	
	@Override
	public void setBit(int[] array, int index) {
		array[index / intBits] |= 1 << (index % intBits);
	}

	@Override
	public boolean isElement(int[] array, int index) {
		if ((array[index / intBits] & (1 << (index % intBits))) == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public void union(int n1, int n2) {
		int[] array1 = new int[size], array2 = new int[size];
		switch(n1){
			case 1:
				array1 = this.A;
				break;
			case 2:
				array1 = this.B;
				break;
			case 3:
				array1 = this.result;
				break;
		}
		switch(n2){
			case 1:
				array2 = this.A;
				break;
			case 2:
				array2 = this.B;
				break;
			case 3:
				array2 = this.result;
				break;
		}
		for(int i = 0; i < size; i++) {
			result[i] = array1[i] | array2[i];
		}
	}
	
	@Override
	public void intersection(int n1, int n2) {
		int[] array1 = new int[size], array2 = new int[size];
		switch(n1){
			case 1:
				array1 = this.A;
				break;
			case 2:
				array1 = this.B;
				break;
			case 3:
				array1 = this.result;
				break;
		}
		switch(n2){
			case 1:
				array2 = this.A;
				break;
			case 2:
				array2 = this.B;
				break;
			case 3:
				array2 = this.result;
				break;
		}
		for(int i = 0; i < size; i++) {
			result[i] = array1[i] & array2[i];
		}
	}
	
	@Override
	public void complement(int n) {
		int[] array = new int[size];
		switch(n){
			case 1:
				array = this.A;
				break;
			case 2:
				array = this.B;
				break;
			case 3:
				array = this.result;
				break;
		}
		for(int i = 0; i < size; i++) {
			result[i] = ~ array[i];
		}
	}
	
	private boolean isPhi(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) return false;
		}
		return true;
	}
	
	public void printSet(String x) {
		int[] array;
		if(x.equals("A")) {
			if(isPhi(A)) {
				System.out.println("A = {}");
				return;
			}
			array = this.A;
		} else if(x.equals("B")){
			if(isPhi(B)) {
				System.out.println("B = {}");
				return;
			}
			array = this.B;
		} else {
			if(isPhi(result)) {
				System.out.println("result = {}");
				return;
			}
			array = this.result;
		}
		System.out.print(x + " = {");
		int i = 0;
		while(!isElement(array, i)) {
			i++;
		}
		System.out.print(universe.get(i));
		i++;
		while(i < sizeOfUniverse) {
			if (isElement(array, i)) {
				System.out.print(", " + universe.get(i));
			}
			i++;
		}
		System.out.println("}");
	}

}
