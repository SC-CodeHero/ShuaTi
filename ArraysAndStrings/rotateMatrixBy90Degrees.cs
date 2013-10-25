public static void Rotate(int[,] arr)
{
　int n = arr.GetUpperBound(0) + 1;
　for (int i = 0; i < n / 2; i++)
　　for (int j = 0; j < (n + 1) / 2; j++)
　　{
　　　int temp = arr[i, j];
　　　arr[i, j] = arr[j, n - 1 - i];
　　　arr[j, n - 1 - i] = arr[n - 1 - i, n - 1 - j];
　　　arr[n - 1 - i, n - 1 - j] = arr[n - 1 - j, i];
　　　arr[n - 1 - j, i] = temp;
　　}
}
