/*  Validate if a given string is numeric. */

private static bool ValidateInteger(string text, int start, int end, bool allowSign, bool allowEmpty)
{
　if ((allowSign) && ((text[start] == '+') || (text[start] == '-')))
　　　start++;

　if ((!allowEmpty) && (start > end))
　　return false;

　while (start <= end)
　{
　　if ((text[start] < '0') || (text[start] > '9'))
　　　return false;
　　start++;
　}

　return true;
}

public static bool ValidateNumber(string text)
{
　int eIndex = text.IndexOf("E", StringComparison.OrdinalIgnoreCase);

　if (eIndex > 0)
　{
　　if (!ValidateInteger(text, eIndex + 1, text.Length - 1, true, false))
　　　return false;
　}
　else
　　eIndex = text.Length;

　int dotIndex = text.IndexOf(".");
　if (dotIndex > 0)
　{
　　if (!ValidateInteger(text, dotIndex + 1, eIndex - 1, false, true))
　　　return false;
　}
　else
　　dotIndex = eIndex;

　return ValidateInteger(text, 0, dotIndex - 1, true, false);
}
