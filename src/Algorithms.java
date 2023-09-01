public class Algorithms {
	static int quickCount = 1,quickDesc =1;
	static int mergeCount = 1,mergeDesc = 1;
	static int heapCount =1,heapDesc = 1;
	void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");;
		}
		System.out.println();
	}
	void swap(int[] arr,int index1,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	void bubbleSort(int[] nums) {
		System.out.println("Algorithm chosen : BUBBLE SORT \n");
		for(int i =0;i<nums.length;i++) {
			for(int j =0;j<nums.length-i-1;j++) {
				if(nums[j] > nums[j+1]) {
					swap(nums,j,j+1);
				}
			}
			System.out.print("PASS "+(i+1)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	void selectionSort(int[] nums) {
		System.out.println("Algorithm chosen : SELECTION SORT\n");
		for(int i =0;i<nums.length-1;i++) {
			int min = i;
			for(int j =i+1;j<nums.length;j++) {
				if(nums[j] < nums[min]) {
					min = j;
				}
			}
			swap(nums,i,min);
			System.out.println("PASS "+(i+1)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	void insertionSort(int[] nums) {
		System.out.println("Algorithm Chosen : INSERTION SORT\n");
		for(int i =1;i<nums.length;i++) {
//			System.out.println("loop");
			int j = i-1;
			int val = nums[i];
			while(j >= 0 && nums[j] > val) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = val;
			System.out.println("PASS "+(i)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	
	void quickSort(int[] nums,int low,int high) {
		if(low < high) {
			int i =low-1,j =low;
			int pivot = nums[high];
			for( j= low;j<high;j++) {
				if(nums[j] < pivot) {
					i++;
					swap(nums,i,j);
				}
			}
			int temp = nums[i+1];
			nums[i+1]  = pivot;
			nums[high] = temp;
			System.out.println("PASS "+(quickCount++)+" : \n\t");
			System.out.println("Pivot index : "+pivot+"\n");
			printArray(nums);
			System.out.println();
			quickSort(nums,low,i);
			quickSort(nums,i+2,high);
		}
	}
	
	void mergeSort(int[] nums,int left,int right) {
		if(left < right) {
			int mid = (left + right - 1)/2;
			mergeSort(nums,left,mid);
			mergeSort(nums,mid+1,right);
			merge(nums,left,mid,right);
			System.out.println("PASS :  "+(mergeCount++)+" :");
			printArray(nums);
			System.out.println();
			
		}
	}
	
	void merge(int[] nums,int left,int mid,int right) {
		int n1 = mid - left + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = nums[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = nums[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
	}
	
	void heapSort(int[] nums) {
		int N = nums.length;

        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(nums, N, i);
        }

        
        for (int i = N - 1; i > 0; i--) {
            
            swap(nums,0,i);

            heapify(nums, i, 0);
            System.out.println("PASS "+(heapCount++)+" :");
            printArray(nums);
            System.out.println();
        }
        System.out.println("Sorted Array : \n");
        printArray(nums);
        System.out.println();
	}
	
	void heapify(int[] nums,int N,int i ) {
		int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 


        if (l < N && nums[l] > nums[largest])
            largest = l;


        if (r < N && nums[r] > nums[largest])
            largest = r;

        
        if (largest != i) {
            swap(nums,i,largest);


            heapify(nums, N, largest);
        }
	}
	
	void searchTarget(int[] nums,int target) {
		int low = 0,high = nums.length-1;
		int count =1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(nums[mid] == target) {
				System.out.println("Element found at index :\t"+mid);
				return ;
			}
			System.out.println("PASS "+count+++" :\n");
			System.out.println("Mid index :\t"+mid+"\tMid Element :\t"+nums[mid]+"\n");
			if(target > nums[mid]) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		System.out.println("Target element not found in the given array");
	}
	
	void searchTargetRotated(int[] nums,int target) {
		int low = 0,high = nums.length-1;
		int count = 1;
			while(low<=high){
	            int mid = (low+high)/2;
	            if(nums[mid] == target){
	                System.out.println("Element found at index :\t"+mid);
	                return;
	            }
	            System.out.println("PASS "+count+++" :\n");
				System.out.println("Mid index :\t"+mid+"\tMid Element :\t"+nums[mid]+"\n");
	            if(nums[low] <= nums[mid]){
	                if(target >= nums[low] &&  target <= nums[mid]){
	                    high = mid-1;
	                }
	                else{
	                    low = mid+1;
	                }
	            }
	            else{
	                if(target >= nums[mid] && target <= nums[high]){
	                    low = mid+1;
	                }
	                else{
	                    high = mid-1;
	                }
	            }
	        }
			System.out.println("Target element not found in the given array");
	}
	
	
	void bubbleSortDesc(int[] nums) {
		System.out.println("Algorithm chosen : BUBBLE SORT and DESCENDING ORDER\n");
		for(int i =0;i<nums.length;i++) {
			for(int j =0;j<nums.length-i-1;j++) {
				if(nums[j] < nums[j+1]) {
					swap(nums,j,j+1);
				}
			}
			System.out.print("PASS "+(i+1)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	
	void  selectionSortDesc(int[] nums) {
		System.out.println("Algorithm chosen : SELECTION SORT and DESCENDING ORDER\n");
		for(int i =0;i<nums.length;i++) {
			int max = i;
			for(int j =i+1;j<nums.length;j++) {
				if(nums[j] > nums[max]) {
					max = j;
				}
			}
			swap(nums,i,max);
			System.out.println("PASS "+(i+1)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	
	void insertionSortDesc(int[] nums) {
		System.out.println("Algorithm chosen : INSERTION SORT and DESCENDING ORDER\n");
		for(int i =1;i<nums.length;i++) {
//			System.out.println("loop");
			int j = i-1;
			int val = nums[i];
			while(j >= 0 && nums[j] < val) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = val;
			System.out.println("PASS "+(i)+" : \n\t");
			printArray(nums);
			System.out.println();
		}
	}
	
	void quickSortDesc(int[]nums,int low,int high) {
		if(low < high) {
			int pi = descPartition(nums,low,high);
			System.out.println("PASS "+(quickDesc++)+" : \n\t");
			System.out.println("Pivot index : "+pi+"\n");
			printArray(nums);
			System.out.println();
			quickSortDesc(nums,low,pi-1);
			quickSortDesc(nums,pi+1,high);
		}
	}
	
	int descPartition(int[] nums,int low,int high) {
		int pivot = nums[high],i =low-1,j;
		for(j = low;j<high;j++) {
			if(nums[j] >= pivot) {
				i++;
				swap(nums,i,j);
			}
		}
		swap(nums,i+1,high);
		return i+1;
	}
	void mergeSortDesc(int[] nums,int left,int right) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSortDesc(nums,left,mid);
			mergeSortDesc(nums,mid+1,right);
			mergeDesc(nums,left,mid,right);
			System.out.println("PASS  : "+(mergeDesc++)+" :");
			printArray(nums);
			System.out.println();
		}
	}
	
	void mergeDesc(int[] nums,int left,int mid,int right) {
			int n1 = mid - left + 1;
	        int n2 = right - mid;
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	        for (int i = 0; i < n1; ++i) {
	            L[i] = nums[left + i];
	        }
	        for (int j = 0; j < n2; ++j) {
	            R[j] = nums[mid + 1 + j];
	        }
	        int i = 0, j = 0;
	        int k = left;
	        while (i < n1 && j < n2) {
	            if (L[i] >= R[j]) {
	                nums[k] = L[i];
	                i++;
	            }
	            else {
	                nums[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	        while (i < n1) {
	            nums[k] = L[i];
	            i++;
	            k++;
	        }
	        while (j < n2) {
	            nums[k] = R[j];
	            j++;
	            k++;
	        }

	}
	
	void heapSortDesc(int[] nums,int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDesc(nums, n, i);
 
        for (int i = n - 1; i >= 0; i--) {
             
            swap(nums,0,i);

            heapifyDesc(nums, i, 0);
            System.out.println("PASS "+(heapDesc++)+" :");
            printArray(nums);
            System.out.println();
        }
        System.out.println("Sorted Array : ");
        printArray(nums);
        System.out.println();
	}
	void heapifyDesc(int[] nums,int n,int i) {
		 int smallest = i; 
	        int l = 2 * i + 1; 
	        int r = 2 * i + 2; 
	 
	        if (l < n && nums[l] < nums[smallest])
	            smallest = l;
	 
	        if (r < n && nums[r] < nums[smallest])
	            smallest = r;
	 
	        if (smallest != i) {
	            swap(nums,i,smallest);
	 
	            heapifyDesc(nums, n, smallest);
	        }
	}
	
}
