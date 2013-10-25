public static int FindLocalMin(int[] arr)
{
　if ((arr == null) || (arr.Length < 1))
　　throw new ArgumentException("Invalid input");

　if (arr.Length == 1)
　　return arr[0];

　if (arr[0] < arr[1])
　　return arr[0];

　if (arr[arr.Length - 1] < arr[arr.Length - 2])
　　return arr[arr.Length - 1];

　int start = 0;
　int end = arr.Length - 1;

　while (end - start > 2)
　{
　　int mid = (end + start) / 2;
　　if (arr[mid] < arr[mid + 1])
　　　end = mid + 1;
　　else
　　　start = mid;
　}

　return arr[start + 1];
}
