import java.util.Scanner;
import java.util.HashSet;
//{apple, banana, cherry, banana, apple}
//{apple, banana, coconut, grape}
public class Main 
{
	private static HashSet<String> mySet;
  public static void main(String[] args) 
	{
    Scanner myScanner = new Scanner(System.in);
		HashSet<String> set = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		String[] str = (((myScanner.nextLine()).replace("{","")).replace("}","")).split(",");
		for(String s : str)
			set.add(s.trim());
		str = (((myScanner.nextLine()).replace("{","")).replace("}","")).split(",");
		for(String s : str)
			set2.add(s.trim());
		int gcd = gcd(intersection(set, set2),union(set, set2));
		System.out.println(intersection(set, set2)/gcd+"/"+(union(set,set2)/gcd));
		myScanner.close();
  }
	public static int intersection(HashSet<String> set, HashSet<String> set2)
	{
		mySet = new HashSet<>();
		for(String s : set)
			if(set2.contains(s))
				mySet.add(s);
		return mySet.size();	
	}
	public static int union(HashSet<String> set, HashSet<String> set2)
	{
		mySet = new HashSet<>();
		String[] mySet2 = set.toArray(new String[set.size()]);
		String[] mySet3 = set2.toArray(new String[set2.size()]);
		for(int i = 0, j = 0;i<set.size() && j<set2.size();)
			mySet.add(i < set.size() ? mySet2[i++] : mySet3[j++]);
		return mySet.size();
	}
	public static int gcd(int a, int b)
	{
		if (a == 0)
      return b;
    return gcd(b % a, a);
	}
}