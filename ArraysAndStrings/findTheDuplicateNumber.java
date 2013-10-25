# 1. Given an array with continue integers except one number is duplicated. Write a function to find the duplicate number.

# To simplify the requiremnt, the continue integers start from 1

# solution number 1: sum all the elements in the array and then sum the index of the array, the difference is the duplicate number

public static int findDuplicate (int[] arr) {
    if (arr == null) {
         throw new InvalidParameterException();
     }
         
    int sumOfTheArray = 0;
    int sumOfTheIndex = 0;
    
    for (int index = 0; index < arr.length; index++) {
        sumOfTheArray += arr[index};
        sumOfTheIndex += index;
    }
    
    return sumOfTheArray - sumOfTheIndex;
}

# solution #2: xor

public static int findDuplicate(int[] arr) {
    int result = 0;
    
     if (arr == null || arr.length < 2 ) {
         throw new InvalidParameterException();
     }
    
    for (int index = 0; index < arr.length; index++) {
        result ^= arr[index] ^ index;
    }
    
    return result;
}

# 2. Write a function to determine whether 3 points can form a valid triangle. Write the test cases.

public static boolean isEligibleTriangel(Point a, Point b, Point c) {
   if ( a == null || b = null || c == null) {
       throw new InvalidParameterException();
   }
   
   return getLength(a, b) + getLength(b, c) > getLength (a, c) &&  
          getLength(a, c) + getLength(b, c) > getLength (a, b) &&
          getLength(a, b) + getLength(a, c) > getLength (b, c);   
   
}

private double getLength(Point a, Point b) {
     return Math.sqrt( (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) );
}

# Test cases:
# 1. a = b = null, c != null;
# 2. a = b = c = null;
# 3. a.equals(b) && !a.equals(c)
# 4. a.equals(b) && a.equals(c)
# 5. a.x = MaxDouble, b.x = MaxNegativeDouble (overflow)
# 6. (0,1.1), (2.0, 4.1), (3.0, 5.0)

# a better solution
public static boolean isEligbleTriangle (Point a, Point b, Point c) {
   if ( a == null || b = null || c == null) {
       throw new InvalidParameterException();
   }
   
   double delta = 0.0000000001;
   
   if (a.equals(b) || b.equals(c) || c.equals(a)) {
       return false;
   }
   
   if ( Math.abs(a.x -b.x) < delta && Math.abs(b.x - c.x) < delta ) {
       return false;
   }
   
   return Math.abs( (a.y - b.y) * (c.x - b.x) - (c.y - b.y) * (a.x - b.x) ) > delta; 
}


