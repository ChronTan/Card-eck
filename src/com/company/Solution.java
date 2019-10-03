package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Solution s=new Solution();

        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int min=1000;
        ArrayList<Integer> oldColoda=new ArrayList<>();
        ArrayList<Integer> nColoda=new ArrayList<>();
        Random random=new Random();

        for(int i=0;i<Integer.parseInt(line);i++){
            int z=random.nextInt(100);
            if(oldColoda.contains(z)){
                i--;
            }else{
                oldColoda.add(z);
            }
        }
        min=s.minimum(oldColoda);
        int index=-1;
        int counter=0;
        int razmer=0;
        while(razmer==0){
            for(int i=0;i<oldColoda.size();i++){
                System.out.println(oldColoda);
                if(oldColoda.get(i)<=min){
                    nColoda.add(oldColoda.get(i));
                    index=i;
                    counter++;
                    i=oldColoda.size();
                }else{
                    oldColoda=s.sdvig(oldColoda);
                    i=-1;
                    counter++;
                }
            }

            oldColoda.remove(index);
            min=s.minimum(oldColoda);
            if(oldColoda.size()==0){
                razmer=1;
            }

        }
        System.out.println(counter);

    }

    public Integer minimum(ArrayList<Integer> arr){
        int a=1000;
        for(int j=0;j<arr.size();j++){
            if(arr.get(j)<a)
                a=arr.get(j);
        }
        return a;
    }

    public ArrayList<Integer> sdvig(ArrayList<Integer> arr){
        Integer[] array = new Integer[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            array[i] = arr.get(i);
        for(int i=0;i<array.length-1;i++){
            int k=array[i];
            array[i]=array[i+1];
            array[i+1]=k;
        }
        arr= new ArrayList<Integer>(Arrays.asList(array));
        return arr;

    }
}
