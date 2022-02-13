package com.lab3.question2;

import java.util.ArrayList;

public class longestpath {
        // Binary tree node
        public static class TreeNode
        {
            public TreeNode left;
            public TreeNode right;
            int data;
        };

        // Function to create a new Binary node
        public static TreeNode newNode(int data)
        {
            TreeNode temp = new TreeNode();

            temp.data = data;
            temp.left = null;
            temp.right = null;

            return temp;
        }

        // Function to find and return the longest path
        public static ArrayList<Integer> findLongestPath(TreeNode root)
        {
            // If root is null means there is no binary tree so return an empty ArrayList
            if(root == null)
            {
                ArrayList<Integer> output = new ArrayList<>();
                return output;
            }
    
            // Recursive call on root.right
            ArrayList<Integer> p1 = findLongestPath(root.right);
    
            // Recursive call on root.left
            ArrayList<Integer> p2 = findLongestPath(root.left);
    
            // Compare the size of the two ArrayList and insert current node accordingly
            if(p1.size() < p2.size())
                p2.add(root.data);
            else
                p1.add(root.data);
    
            // Return the appropriate ArrayList
            return (p2.size() > p1.size() ? p2 :p1);
        }

        public static void main(String[] args) {

            longestpath.TreeNode root = longestpath.newNode(100);
            root.left = longestpath.newNode(20);
            root.right = longestpath.newNode(130);
            root.left.left = longestpath.newNode(10);
            root.left.right = longestpath.newNode(50);
            root.right.left = longestpath.newNode(110);
            root.right.right = longestpath.newNode(140);
            root.left.left.left = longestpath.newNode(5);
    
            ArrayList<Integer> output = longestpath.findLongestPath(root);
            int n = output.size();
    
            System.out.print(output.get(n - 1));
            for(int i = n - 2; i >= 0; i--)
                System.out.print(" -> " + output.get(i));
        }
}

