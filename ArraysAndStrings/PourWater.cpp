/*
There is an integer array. Assume the integer array can be projected into a bar graph. 
Imagine a rain pours over the bar graph. How much water will be accumulated between the walls of the graph. 
(Assuming the rain "fills to the top".
*/

int PourWater(int arr[], int len)
{
	if(!arr || len<=0) return 0;
	
	int* leftMax  = new int[len];
	int maxSofar = INT_MIN;
	int res = 0;
	
	for(int i=0; i<len; i++)
	{
		maxSofar = max(maxSofar, arr[i]);
		leftMax[i] = maxSofar;
	}
	
	maxSofar = INT_MIN;
	for(int i=len-1; i>=0; i--)
	{
		maxSofar = max(maxSofar, arr[i]);
		res += max(min(maxSofar, leftMax[i])-arr[i], 0);
	}
	
	delete[] leftMax;
	return res;
}
