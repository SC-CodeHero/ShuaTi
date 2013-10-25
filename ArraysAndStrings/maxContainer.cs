/* No. 5 Given n non-negative integers a1, a2, ..., an, 
  where each represents a point at coordinate (i, ai). 
  n vertical lines are drawn such that the two endpoints 
  of line i is at (i, ai) and (i, 0). Find two lines, 
  which together with x-axis forms a container, such that 
  the container contains the most water.
 */

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
