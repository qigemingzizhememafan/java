package www.bittech;
// 在二叉树中找指定结点
//public class Node {
//    char val;
//    Node root;
//    Node left;
//    Node right;
//    public static Node find(Node root,char V){
//        // 1. 空树判断
//        if(root == null){
//            return null;
//        }
//        // 2.比较根结点的值
//        if(root.val == V){
//            return root;
//        }
//        // 3.根结点没找到，去左子数找
//        Node left = find(root.left,V);
//        if(left != null){
//            return left;
//        }
//        // 4.左子树没有去右子数找
//        return find(root.right,V);
//        }
//}

//import java.util.Arrays;
//// 创建二叉树
//class Node {
//    char value;
//    Node left;
//    Node right;
//
//    public Node(char value, Node left, Node right) {
//        this.value = value;
//        this.left = left;
//        this.right = right;
//    }
//
//    public Node(Node left) { this.left = left; }
//    public Node(char value) { this.value = value; }
//}
//
//class CreateTreeReturnValue {
//    Node node;
//    int used;
//
//    public CreateTreeReturnValue(Node node, int used) {
//        this.node = node;
//        this.used = used;
//    }
//
//    public CreateTreeReturnValue(Node root, int i, int rightUsed) {
//    }
//}
//
//public class Node1 {
//    // 利用带空结点的前序构建二叉树
//     private static CreateTreeReturnValue createTreeReturnValue(char[] preOrder){
//        char rootvalue = preOrder[0];
//        Node node = new Node(rootvalue);
//        // 左子树
//        char[] leftArray = new char[preOrder.length-1];
//        leftArray = Arrays.copyOfRange(preOrder,1,preOrder.length);
//        CreateTreeReturnValue leftReturn = createTreeReturnValue(leftArray);
//        Node leftRoot = leftReturn.node;
//        int leftUsed = leftReturn.used;
//        // 右子树
//         char[] rightArray = new char[preOrder.length-1-leftUsed];
//        rightArray = Arrays.copyOfRange(preOrder,1+leftUsed,preOrder.length);
//        CreateTreeReturnValue rightReturn = createTreeReturnValue(rightArray);
//        Node rightRoot = rightReturn.node;
//        int rightUsed = rightReturn.used;
//        // 关联
//         Node root = null;
//        root.left = leftRoot;
//        root.right = rightRoot;
//         return new CreateTreeReturnValue(root,1+leftUsed,rightUsed);
//        // 终止
//         if(preOrder.length == 0){
//             return  new CreateTreeReturnValue(null,0);
//         }else if(preOrder[0] == '#'){
//             return  new CreateTreeReturnValue(null,1);
//         }else if (){
//
//         }
//    }

//import java.util.Arrays;
//
//// 后序+中序构建二叉树
//class Solution{
//    // 找到根结点所在的下标
//    public int find(char[] array,char v){
//        for(int i = 0; i<array.length;i++) {
//            if (array[i] == v) {
//                return i;
//            }
//        }
//         return -1;
//    }
//    class Node{
//        Node node;
//        char val;
//
//        public Node(Node node, char val) {
//            this.node = node;
//            this.val = val;
//        }
//
//        public Node(char val) {
//            this.val = val;
//        }
//
//    }
//    Node buildTree(char[] inorder,char[] postorder){
//        if(inorder.length == 0){
//            return null;
//        }
//        // 找根结点
//        int end = postorder.length;
//        char rootval = postorder[end-1];
//        Node root = new Node(rootval);
//        int index = find(inorder,rootval);
//        // 左子树
//        char[] postleftArray = new char[index];
//        postleftArray = Arrays.copyOfRange(postorder,0,index);
//        char[] inleftArray = new char[index];
//        inleftArray = Arrays.copyOfRange(inorder,0,index);
//        root.left = buildTree(postleftArray,inleftArray);
//        // 右子树
//        char[] postriftArray = new char[end-index-1];
//        postriftArray = Arrays.copyOfRange(inorder,index,end-1);
//        char[] inriArray = new char[end-index-1];
//        inleftArray = Arrays.copyOfRange(inorder,1+index,end);
//        root.right = buildTree(postleftArray,inleftArray);
//        return root;
//    }
//}

