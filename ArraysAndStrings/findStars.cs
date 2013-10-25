/* No.6 有N个人，其中k个明星和N-k个群众，N很大，k很小为O(1)。
   所有人都认识明星，明星不认识任何群众，群众之间可能认识，
   现在你是R2D2，你每次问一个人是否认识另一人的代价为O(1)，
   试设计一种算法找出明星，并给出时间复杂度。
 */


public List<Guy> FindFamousGuys(Guy[] guys)
{
　List<Guy> famousGuys = new List<Guy>();
　if (guys.Length <= 1)
　{
　　famousGuys.AddRange(guys);
　}

　Guy someone1 = guys[0];
　Guy someone2 = guys[1];
　for (int i = 2; i < guys.Length; i++)
　　if (IsKnowing(someone1, someone2))
　　　someone1 = guys[i];
　　else
　　　someone2 = guys[i];

　Guy famousGuy = someone2;
　if (!IsKnowing(someone1, someone2))
　　famousGuy = someone1;

　famousGuys.AddRange(famousGuys);

　for (int i = 0; i < guys.Length; i++)
　　if (famousGuy != guys[i])
　　　if (IsKnowing(famousGuy, guys[i]))
　　　　famousGuys.Add(guys[i]);

　return famousGuys;
}
