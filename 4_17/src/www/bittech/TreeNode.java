package www.bittech;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
// 前序遍历二叉树
//public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root != null){
//            list.add(root.val);
//            if(root.left != null){
//                list.addAll(preorderTraversal(root.left));
//            }
//            if(root.right != null){
//                list.addAll(preorderTraversal(root.right));
//            }
//        }else{
//            return list;
//        }
//        return list;
//    }
//}

import java.util.ArrayList;
import java.util.List;
//
//// 中序遍历
//class Solution1 {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }else{
//            if(root.left != null){
//                list.addAll(inorderTraversal(root.left));
//            }
//            list.add(root.val);
//            if(root.right != null){
//                list.addAll(inorderTraversal(root.right));
//            }
//        }
//        return list;
//    }
//}

// 后续遍历
//class Solution2 {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null){
//
//        }else{
//            if(root.left != null){
//                list.addAll(postorderTraversal(root.left));
//            }
//            if(root.right != null){
//                list.addAll(postorderTraversal(root.right));
//            }
//            list.add(root.val);
//        }
//        return list;
//    }
//}

// 判断两棵二叉树是否相同
//class Solution3 {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q == null){
//            return true;
//        }
//        if(p != null && q != null && p.val ==  q.val){
//            return(isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
//        }else{
//            return false;
//        }
//    }
//}

// 一棵树是否是另一棵树的子树
//class Solution4 {
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null && t == null) return true;
//        if(s == null || t == null) return false;
//        return (s.val == t.val)&&restTree(s.left,t.left)&&restTree(s.right,t.right) || isSubtree(s.left,t)||isSubtree(s.right,t);
//    }
//
//    public boolean restTree(TreeNode s, TreeNode t){
//        if(s == null && t == null) return true;
//        if(s == null || t == null) return false;
//        return s.val==t.val&&restTree(s.left,t.left)&&restTree(s.right,t.right);
//    }
//}

//二叉树最大深度
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
//class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        int ll = maxDepth(root.left);
//        int rl = maxDepth(root.right);
//        if(ll >= rl){
//            return ll+1;
//        }
//        else {
//            return rl+1;
//        }
//    }
//}

// 对称二叉树
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    public boolean isMirror(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        return (t1.val == t2.val)
//                && isMirror(t1.right, t2.left)
//                && isMirror(t1.left, t2.right);
//    }
//}

// 平衡二叉树
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        int leftDepth = getDepth(root.left);
//        int rightDepth = getDepth(root.right);
//
//        if (leftDepth == -1 || rightDepth == -1) {
//            return false;
//        }
//        if (leftDepth - rightDepth < -1 || leftDepth - rightDepth > 1) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 使用递归的解法，返回的子树深度有两种意思：
//     * 1.如果返回深度大于0，则表示子树的深度
//     * 2.如果返回深度等于-1，则表示子树为非平衡树
//     ，父节点得到-1的返回值后不用计算，依次向上返回直到根节点，判断为非平衡树
//     */
//    private int getDepth(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        int leftDepth = getDepth(node.left);
//        int rightDepth = getDepth(node.right);
//
//        if (leftDepth == -1 || rightDepth == -1) {
//            return -1;
//        }
//
//        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
//            return -1;
//        }
//
//        return Math.max(leftDepth, rightDepth) + 1;
//    }
//}