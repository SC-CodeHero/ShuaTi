public static int MaxContainer(int[] bars)
{
　int max = 0;
　int lowBar = 0;
　int start = 0;
　int end = bars.Length - 1;

　while (start < end)
　{
　　lowBar = Math.Max(lowBar, Math.Min(bars[start], bars[end]));
　　int volume = lowBar * (end - start);
　　if (volume > max)
　　　max = volume;

　　if (bars[start] <= lowBar)
　　　start++;
　　if (bars[end] <= lowBar)
　　　end--;
　}

　return max;
}
