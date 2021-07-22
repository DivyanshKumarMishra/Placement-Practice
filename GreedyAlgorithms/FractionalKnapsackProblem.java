package com.divyansh.GreedyAlgorithms;

import java.util.Arrays;

public class FractionalKnapsackProblem {

	static class item{
		int value;
		int weight;
		double cost;
		
		item(int value, int weight){
			this.value = value;
			this.weight = weight;
			cost = (double)((double)value/(double)weight);
		}		
	}
	
	public static double getMaxValue(int[] weight, int[] value,  int capacity) {
		
		item[] items = new item[weight.length];
		
		for(int i=0;i<weight.length;i++) {
			items[i] = new item(value[i],weight[i]);
		}
		
		Arrays.sort(items,(item1,item2) -> {
			if(item1.cost>item2.cost) return -1;
			else if(item1.cost<item2.cost) return 1;
			else return 0;
		});
		
		for(int i=0;i<weight.length;i++) {
			System.out.print(items[i].weight +" " +  items[i].value + " ");
		}
		System.out.println();
		
		int curweight = 0;
		double finalvalue = 0.0;
		
		for(int i=0;i<items.length;i++) {
			
			if(curweight+items[i].weight<capacity && capacity>0) {
				curweight += items[i].weight;
				finalvalue +=items[i].value;
				capacity = capacity - items[i].weight;
				System.out.println(curweight +" " +  finalvalue + " " + capacity);
			}
			else if(capacity>0 && items[i].weight>capacity) {
				curweight += capacity;
				finalvalue = finalvalue + ((double)items[i].value * ((double)capacity /(double)items[i].weight));
				capacity = capacity - capacity;
				System.out.println(curweight +" "+  finalvalue + " " + capacity);
			}
		}
		return finalvalue;
	}
	
	public static void main(String[] args) {
		
		int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
        
        double maxValue = getMaxValue(wt, val, capacity);
        
        System.out.println("Maximum value we can obtain = "
                + maxValue);
	}	
}
