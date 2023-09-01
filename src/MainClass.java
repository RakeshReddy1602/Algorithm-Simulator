import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******   WELCOME TO ALGORITHM SIMULATOR   ******\n");
		System.out.println("Sorting Algorithms\n1. BUBBLE SORT\n2. INSERTION SORT\n3. SELECTION SORT\n4. QUICK SORT\n5. MERGE SORT\n6. HEAP SORT");
		System.out.println("Searching Algorithms\n7. BINARY SEARCH\n8. BINARY SEARCH IN SORTED ROTATED ARRAY\n");
		int input = 1;
		char desc = 'a';
		boolean inputNeeded = true;
		int[] nums = new int[0];
		int[] backup = new int[0];
		Scanner in = new Scanner(System.in);
		while(true){
		System.out.println("Please select any one of the above algorithm to conrinue or 0 for EXIT");
		try {
		input = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input detected\n");
			System.out.println("THANK YOU FOR CHOSING ALGORITHM SIMULATOR !!!!");
			return ;
		}
		if(input == 0) {
			System.out.println("THANK YOU FOR CHOSING ALGORITHM SIMULATOR !!!!");
			return ;
		}
		if(input > 0 && input <=6) {
		  System.out.println("Please Enter 'd' to sort in descending order or any other character for ascending order");
		  desc = in.next().charAt(0);
			if(desc == 'd') {
				System.out.println("Oreder chosen : DESCENDING ORDER\n");
			}
			else {
				System.out.println("Order chosen : ASCENDING ORDER\n");
			}
		}
		if(inputNeeded) {
		System.out.println("Enter the size of the array (must be non negative integer)");
		int size = 0;
		try {
		  size = in.nextInt();
		}catch(InputMismatchException ex) {
			System.out.println("Invalid Input detected\n");
			System.out.println("THANK YOU FOR CHOSING ALGORITHM SIMULATOR !!!!");
			return ;
		}
		try {
			nums = new int[size];
			backup = new int[size];
		}catch(NegativeArraySizeException e) {
			System.out.println("Array Size must ne non negative as mentioned !!!");
		}
		System.out.println("Please enetr the "+size+" elements into the array");
		for(int i =0;i<size;i++) {
			try {
				nums[i] = in.nextInt();
				backup[i] = nums[i];
			}catch(InputMismatchException e) {
				System.out.println("Invalid Input detected\n");
			}
//			System.out.println("input");
		}
		}
		Algorithms algoObj = new Algorithms();
		switch(input) {
		case 1 :	if(desc != 'd') {
						algoObj. bubbleSort(nums);
					}
					else {
						algoObj.bubbleSortDesc(nums);
					}break;
		case 2 : if(desc != 'd') {
					algoObj. insertionSort(nums);
				}
				else {
					algoObj.insertionSortDesc(nums);
				}break;
		case 3 : if(desc != 'd') {
					algoObj. selectionSort(nums);
				 }
				else {
					algoObj.selectionSortDesc(nums);
				}break;
		case 4 : if(desc != 'd') {
					System.out.println("Algorihtm Chosen :\tQUICK SORT and ASCENDING ORDER\n");
					algoObj.quickSort(nums,0,nums.length-1);
					System.out.println("Sorted Array : ");
					algoObj.printArray(nums);
					Algorithms.quickCount = 1;
				 }
				 else{
					 System.out.println("Algorihtm Chosen :\tQUICK SORT and DESCENDING ORDER\n");
						algoObj.quickSortDesc(nums,0,nums.length-1);
						System.out.println("Sorted Array : ");
						algoObj.printArray(nums);
						Algorithms.quickDesc = 1;
				 }break;
		case 5 : if(desc != 'd') {
					System.out.println("Algorihtm Chosen :\tMERGE SORT and ASCENDING ORDER\n");
					algoObj.mergeSort(nums,0,nums.length-1);
					System.out.println("Sorted Array : ");
					algoObj.printArray(nums);
					Algorithms.mergeCount = 1;
		 		}
		 	    else{
		 	    	System.out.println("Algorihtm Chosen :\tMERGE SORT and DESCENDING ORDER\n");
		 	    	algoObj.mergeSortDesc(nums,0,nums.length-1);
		 	    	System.out.println("Sorted Array : ");
		 	    	algoObj.printArray(nums);
		 	    	Algorithms.mergeDesc = 1;
		 	    }break;
		case 6 : if(desc != 'd') {
					System.out.println("Algorihtm Chosen :\tHEAP SORT and ASCENDING ORDER\n");
					algoObj. heapSort(nums);
		 		 }
				 else {
					System.out.println("Algorihtm Chosen :\tHEAP SORT and DESCENDING ORDER\n");
				   	algoObj.heapSortDesc(nums,nums.length);
				 }break;
		case 7 : System.out.println("Enter target to be searched in array :\t");
				 int target = 0;
				 try {
					 target = in.nextInt();
				 }catch(InputMismatchException e) {
					 System.out.println("Invalid input detected\n");
				 }
				 algoObj.searchTarget(nums,target);
				 System.out.println("NOTE :\nAlgorithm Simulator will return any valid index in case of duplicate elements in the array\n");
				 break;
		case 8 : System.out.println("Enter target to be searched in array :\t");
		 		int key = 0;
		 		try {
		 			key = in.nextInt();
		 		}catch(InputMismatchException e) {
		 		System.out.println("Invalid input detected\n");
		 		}
		 		algoObj.searchTargetRotated(nums,key);break;
		default : System.out.println("Invalid option chosen !!!");
		}
		System.out.println("If you wish to continue with same array, press 'Y' or 'y!! ");
		char ch = in.next().charAt(0);
		if(ch == 'Y' || ch == 'y') {
			inputNeeded = false;
		}
		else {
			inputNeeded = true;
		}
		nums = backup;
	}
		
}

}
