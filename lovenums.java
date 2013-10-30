import java.util.ArrayList; import java.lang.Math; import java.lang.Double;
public class love_num {
public static void main(String[] args)
{
int intMain = 2;
int intBig = 0;
try
{
intBig = Integer.parseInt(args[0].toString());
}
catch (Exception e)
{
System.out.println("error:" + e);
System.out.println("type command like \"java love_num 50\"");
return;
}
while (true)
{
ArrayList listYakuSu1 = findYakuSu(intMain);
int intSum1 = addYakuSu(listYakuSu1);
//String strDebug = "";
//String strDebug2 = "";
if ( intSum1 == intMain )
{
System.out.println("self num:" + intSum1);
//for (int i = 0; i < listYakuSu1.size(); i ++)
//{
// strDebug += listYakuSu1.get(i);
// strDebug += ",";
//}
//System.out.println("YakuSu:" + strDebug);
}
else
{
ArrayList listYakuSu2 = findYakuSu(intSum1);
int intSum2 = addYakuSu(listYakuSu2);
if ( intSum2 == intMain )
{
System.out.println("love num:" + intMain + "--" + intSum1);
//for (int i = 0; i < listYakuSu1.size(); i ++)
//{
// strDebug += listYakuSu1.get(i);
// strDebug += ",";
//}
//System.out.println("YakuSu:" + strDebug);
//for (int i = 0; i < listYakuSu2.size(); i ++)
//{
// strDebug2 += listYakuSu2.get(i);
// strDebug2 += ",";
//}
//System.out.println("YakuSu:" + strDebug2);
}
}
intMain ++;
if (intMain > intBig)
{
return;
}
}
}
public static int addYakuSu (ArrayList listYakuSu)
{
//System.out.println("addYakuSu start ");
int sum = 0;
int temp = 0;
for (int i = 0; i < listYakuSu.size() ; i ++ )
{
temp = Integer.parseInt(listYakuSu.get(i).toString());
sum += temp;
}
//System.out.println("addYakuSu end " + sum);
//System.out.println("");
return (sum);
}
public static ArrayList findYakuSu (int intNum)
{
//String strDebug = "";
//System.out.println("findYakuSu start " + intNum);
ArrayList listYakuSu = new ArrayList();
double dbNum = (double)intNum;
double dbRoot = Math.sqrt(dbNum);
Double d = new Double(dbRoot);
int intRoot = d.intValue() ;
//System.out.println("root:" + intRoot);
// if (intHalf * 2 == intNum)
// {
// }
// else
// {
// intHalf ++;
// }
listYakuSu.add ("1");
for (int i = 2; i <= intRoot ; i ++)
{
int intPart = intNum/i;
if (intPart * i == intNum)
{
if (intPart == i)
{
listYakuSu.add (Integer.toString(i));
//strDebug += Integer.toString(i);
//strDebug += ",";
}
else
{
listYakuSu.add (Integer.toString(i));
listYakuSu.add (Integer.toString(intPart));
//strDebug += Integer.toString(i);
//strDebug += ",";
//strDebug += Integer.toString(intPart);
//strDebug += ",";
}
}
}
//System.out.println("findYakuSu end:1," + strDebug);
//System.out.println("");
return (listYakuSu);
}
}
