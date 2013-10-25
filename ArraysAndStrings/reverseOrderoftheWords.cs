public static void RevertChars(char[] input, int start, int end)
{
　while (start < end)
　{
　　char temp = input[start];
　　input[start] = input[end];
　　input[end] = temp;
　　start++;
　　end--;
　}
}

public static string RevertWords(string str)
{
　if (str == null)
　　return null;

　char[] buff = str.ToCharArray();

　int start = -1;
　int end = -1;
　bool reverted = false;
　bool isPrevSpace = true;

　for (int i = 0; i < buff.Length; i++)
　{
　　bool isSpace = (buff[i] == ' ');
　　if (isSpace^isPrevSpace)
　　{
　　　if (isSpace)
　　　　end = i - 1; // word => space
　　　else
　　　{ // space => word
　　　　if (start >= 0)
　　　　{ // revert last word
　　　　　RevertChars(buff, start, end);
　　　　　reverted = true;
　　　　}
　　　　start = i; // new start
　　　}
　　}
　　isPrevSpace = isSpace;
　}

　if (reverted)
　{ // 2+ word found, revert the last
　　if (end < start)
　　　end = buff.Length - 1;
　　RevertChars(buff, start, end);
　　
　　RevertChars(buff, 0, buff.Length - 1); // revert the whole text
　}

　return new String(buff);
}
