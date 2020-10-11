class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> arr, int V)
    {
        int i ;
        for( i =0 ; i<arr.size();i++)
		{
			boolean visited [] = new boolean[arr.size()];
			if(detech(arr,visited,i)) return true;
		}
	if(i!= arr.size())	return true; return false;
    }
    static boolean detech(ArrayList<ArrayList<Integer>> arr, boolean visited[],int sv)
	{
		if(visited[sv]) return true;
		if(!visited[sv]) visited[sv] = true;
		
		ArrayList<Integer> it = arr.get(sv);
		for(Integer c : it)
			if(detech(arr,visited,c))
				return true;
		visited[sv]  =  false;
		return false;
		
	}
}