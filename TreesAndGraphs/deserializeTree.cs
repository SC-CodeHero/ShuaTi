/* No.3 序列化一个二叉树。假设二叉树的节点内容就是一个A to Z之间的字母。
 * 序列化就是说给一个二叉树，能转化成一个string，然后这个string，能还
 * 原成原来的二叉树。（相当于要实现两个function）不同节点可以存相同内容。
 * 作者：易山
 */
 
public static void Serialize(StringBuilder stringBuilder, BinaryTreeNode node)
{
　if (node == null)
　　stringBuilder.Append('#');
　else
　{
　　stringBuilder.Append(node.Data);
　　Serialize(stringBuilder, node.Left);
　　Serialize(stringBuilder, node.Right);
　}
}

public static void Serialize(BinaryTreeNode node)
{
　StringBuilder stringBuilder = new StringBuilder();
　Serialize(stringBuilder, node);
　Console.WriteLine(stringBuilder.ToString()); // add comments by pokertars
}

public static BinaryTreeNode Deserialize(StringReader reader)
{
　BinaryTreeNode item = null;
　char[] buff = new char[1];
　reader.Read(buff, 0, 1);
　if (buff[0] == '#')
　　item = null;
　else
　{
　　item = new BinaryTreeNode(buff[0]);
　　item.Left = Deserialize(reader);
　　item.Right = Deserialize(reader);
　}
　return item;
}

public static BinaryTreeNode Deserialize(string str)
{
　BinaryTreeNode root = null;
　using (StringReader reader = new StringReader(str))
　{
　　root = Deserialize(reader);
　}
　return root; //change here
}
