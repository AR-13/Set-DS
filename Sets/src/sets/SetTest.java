package sets;

import java.util.Scanner;

public class SetTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the universe: ");
		int sizeOfUniverse;
		sizeOfUniverse = scan.nextInt();
		scan.nextLine();
		System.out.println();
		Set set = new Set(sizeOfUniverse);
		System.out.println("Scanning universe ...");
		System.out.println("Enter each element line by line:");
		for(int i = 0; i < sizeOfUniverse;) {
			String tempElement = scan.nextLine();
			if (!set.universe.contains(tempElement)) {
				set.universe.add(tempElement);
				i++;
			}
		}
		System.out.println("Scanning universe is done.");
		System.out.println("Scanning set A ...");
		System.out.println("Enter the indexes of the elements in the universe from");
		System.out.println("1 to " + sizeOfUniverse);
		System.out.println("Enter -1 to end.");
		while (true) {
			int tempIndex = scan.nextInt();
			if (tempIndex == -1) {
				break;
			}
			if (tempIndex > 0 && tempIndex <= sizeOfUniverse) {
				set.setBit(set.A, tempIndex - 1);
			} else {
				System.out.println(tempIndex + " is out of bounds !");
			}
			scan.nextLine();
		}
		System.out.println("Scanning set A is done.");
		System.out.println();
		
		System.out.println("Scanning set B ...");
		System.out.println("Enter the indexes of the elements in the universe from");
		System.out.println("1 to " + sizeOfUniverse);
		System.out.println("Enter -1 to end.");
		scan.nextLine();
		while (true) {
			int tempIndex = scan.nextInt();
			if (tempIndex == -1) {
				break;
			}
			if (tempIndex > 0 && tempIndex <= sizeOfUniverse) {
				set.setBit(set.B, tempIndex - 1);
			} else {
				System.out.println(tempIndex + " is out of bounds !");
			}
			scan.nextLine();
		}
		System.out.println("Scanning set B is done.");
		System.out.println();
		
		int option;
		int set1, set2;
		boolean flag = true;
		while (flag) {
			set.printSet("A");
			set.printSet("B");
			set.printSet("result");
			System.out.println();
			System.out.println("Choose your option:");
			System.out.println("1- Union.");
			System.out.println("2- Intersection.");
			System.out.println("3- Complement.");
			System.out.println("4- Exit.");
			option = scan.nextInt();
			scan.nextLine();
			
			switch(option) {
				case 1:
					System.out.println("Choose two sets.");
					System.out.println("1- A");
					System.out.println("2- B");
					System.out.println("3- result");
					set1 = scan.nextInt();
					set2 = scan.nextInt();
					scan.nextLine();
					set.union(set1, set2);
					break;
				case 2:
					System.out.println("Choose two sets.");
					System.out.println("1- A");
					System.out.println("2- B");
					System.out.println("3- result");
					set1 = scan.nextInt();
					set2 = scan.nextInt();
					scan.nextLine();
					set.intersection(set1, set2);
					break;
				case 3:
					System.out.println("Choose 1 set.");
					System.out.println("1- A");
					System.out.println("2- B");
					System.out.println("3- result");
					set1 = scan.nextInt();
					scan.nextLine();
					set.complement(set1);
					break;
				case 4:
					flag = false;
					break;
				default:
					continue;
			}
		}
		scan.close();
	}
}
