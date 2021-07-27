package com.divyansh.DynamicProgramming;

public class TravellingSalesman {
	
	private static int n=4;
	
	public static int travel(int[][] dist,int[][] dp,int vis,int mask,int pos) {
		
		if(mask==vis)
			return dist[pos][0];
		if(dp[mask][pos]!=-1)
			return dp[mask][pos];
		
		int ans = Integer.MAX_VALUE;
		for(int city=0;city<n;city++) {
			if((mask&(1<<city))==0) {
				int newans = dist[pos][city] + travel(dist,dp,vis,(mask|1<<city),city);
				ans = Math.min(ans,newans);
			}
		}
		return dp[mask][pos] = ans;
	}

	public static void main(String[] args) {
		int[][] dist = {{0,20,42,25},
						{20,0,30,34},
						{42,30,0,10},
						{25,34,10,0}};
		int vis = (1<<n)-1;
		int[][] dp = new int[16][4];
		for(int i=0;i<(1<<n);i++) {
			for(int j=0;j<n;j++) {
				dp[i][j] = -1;
			}
		}
		int cost = travel(dist,dp,vis,1,0);
		System.out.println(cost);
	}
}
