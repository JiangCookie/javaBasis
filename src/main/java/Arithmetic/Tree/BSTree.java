package Arithmetic.Tree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author JYH
 * 2018/10/17 20:17
 */
public class BSTree<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTree(){
        root = null;
        size = 0;
    }

    public  int size(){
        return  size;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     */
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E，递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return  new Node(e);
        }
        if(e.compareTo(node.e) < 0){
             node.left = add(node.left,e);
        }else{
             node.right = add(node.right,e);
        }
        return node;
    }


    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e){
        return contains(root ,e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     */
    private boolean contains(Node node , E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜素树的前序遍历
     */
    public  void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜素树的中序遍历
     */
    public  void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     */
    private  void inOrder(Node node){
        if(node == null){
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    /**
     * 二分搜素树的后序遍历
     */
    public  void afterOrder(){
        afterOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     */
    private  void afterOrder(Node node){
        if(node == null){
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 找到二分搜索树的最小值
     */
    public E  minmum(){
        if(size == 0){
            throw new IllegalArgumentException("BSTree is empty");
        }
        return minmum(root).e;
    }

    /**
     * 递归算法
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minmum(Node node){
        if(node.left == null){
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 找到二分搜索树的最大值
     */
    public E  maxmum(){
        if(size == 0){
            throw new IllegalArgumentException("BSTree is empty");
        }
        return maxmum(root).e;
    }

    /**
     * 递归算法
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 从二叉搜索树中删除最小节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return  node;
    }

    /**
     * 从二叉搜索树中删除最大节点，返回最大值
     * @return
     */
    public E removeMax(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return  node;
    }

    //从二分搜索树中删除元素为e的节点
    public void  remove(E e){
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);

            return node;
        }else if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else {
            /**
             * 待删除节点左子树为空的情况
             */
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            /**
             * 待删除节点右子树为空的情况
             */
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size -- ;
                return leftNode;
            }

            /**
             * 待删除节点左右子树均不为空的情况
             * 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0 ,res);
        return res.toString();
    }


    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }


        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left , depth + 1, res);
        generateBSTString(node.right , depth + 1, res);
    }

    private  String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth ;i ++){
            res.append("--");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<Integer>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while ( ! bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");
    }
}

















