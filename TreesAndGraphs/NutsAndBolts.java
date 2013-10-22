public class NutsAndBolts {
/*
#刷题 No. 1

There are N nuts and N bolts, all unique pairs of Nut and Bolt.
You cant compare Nut with Nut.
You cant compare Bolt with Bolt
You CAN compare Nut with Bolt
Now how would you figure out matching pairs of nut and bolt from the given N nut and Bolt.
*/

public static void matchNutsAndBolts(int nuts[], int bolts[]) {
    if (nuts == null || bolts == null || nuts.length != bolts.length) {
        throw new ArgumentException();
    }
    
    if(nuts.length == 1) return; // nothing to do
    
    matchNutsAndBolts(nuts, bolts, 0, nuts.length - 1);
}

private static void  matchNutsAndBolts(int nuts[], int bolts[], final int start, final int end) {
    if (start < end) {
        int newIndex = partition(nuts, bolts, start, end);
        matchNutsAndBolts(nuts, bolts, start, newIndex - 1);
        matchNutsAndBolts(nuts, bolts, newIndex + 1, end);
    }
}

private static int partition(int nuts[], int bolts[], final int start, final int end) {
    int pivatForNuts = bolts[start + (end - start)/2]；
    int newPivatIndex = partition(nuts, start, end, pivatForNuts);
    partition(bolts, start, end, nuts[newPivatIndex]);
    return newPivatIndex;
}

/*
comment out: one extra iteration to find pivatIndex
replace by new partition function
private static int partition(int arr[], final int start, final int end, final int pivatValue) {   
    int pivatIndex;   
    // find the index for the pivatValue 
    for(int i = start; i <= end; i++) {
        if (arr[i] == pivatValue) {
            pivatIndex = i; 
            break;
        }
    }   
    swap(arr, pivatIndex, end);
    storedIndex = start;
    for(int i = start; i < end; i++) {
        if (nuts[i] <= pivatValue) { // since each bolt/nut is unique, it is safe to use "<" here.
            swap(arr, i, storedIndex);
            storedIndex += 1;
        }
    }
    swap(arr, pivatIndex, storedIndex);
    return storedIndex;
}
*/

// save one iteration to find the pivatIndex
private static int partition(int arr[], final int start, final int end, final int pivatValue) {   
    storedIndex = start;
    for(int i = start; i < end; i++) {
        if (arr[i] < pivatValue) { 
            swap(arr, i, storedIndex);
            storedIndex += 1;
        } else if (arr[i] == pivatValue) {
            swap(arr, i, end);
            i--;  // Go back to compare the original last elements.
        }
    }
    swap(arr, end, storedIndex);
    return storedIndex;
}

private static void swap(int arr[], final int i, final int j) {
    if(arr[i] ==  arr[j]) return;  // do nothing
      
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}     

}
