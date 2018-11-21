/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potatosacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class PotatoSacks {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        int x = scan.nextInt();
        
        for(int i = 0; i < x; i++)
        {
            System.out.print(scan.nextInt() + " ");
            int maxWeight = scan.nextInt();
            int[] weights = new int[10];
            for(int j = 0; j < weights.length; j++)
            {
                weights[j] = scan.nextInt();
            }
            
            int[] weightTemp = weights.clone();
            Arrays.sort(weightTemp);
            for(int j = 0; j < weights.length; j++)
            {
                weights[weights.length - (1 + j)] = weightTemp[j];
            }
            boolean result = checkForExactWeight(weights, 0, maxWeight, 0);
            
            if(result)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
    
    public static boolean checkForExactWeight(int[] potatoes, int currentWeight, int maxWeight, int index)
    {
        if(currentWeight == maxWeight)
        {
            return true;
        }
        
        for(int i = index; i < potatoes.length; i++)
        {
            if(currentWeight + potatoes[i] <= maxWeight && checkForExactWeight(potatoes, currentWeight + potatoes[i], maxWeight, i + 1))
            {
                return true;
            }
        }
        return false;
    }
}
