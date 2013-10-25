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
