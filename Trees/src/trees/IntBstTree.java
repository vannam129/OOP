/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class IntBstTree {
     IntBstNode root;

    public IntBstTree() {
        root = null;
    }

    public boolean add(int x) {
        IntBstNode pBefore = null;
        IntBstNode pAfter = null;
        IntBstNode newNode = new IntBstNode(x);
        if (root == null) {
            if (newNode != null) {
                root = newNode;
            } else {
                return false;
            }
        } else {
            pBefore = root;
            while (pBefore != null) {
                if (pBefore.key != x) {
                    pAfter = pBefore;
                    if (x > pBefore.key) {
                        pBefore = pBefore.right;
                    } else pBefore = pBefore.left;
                } else break;

            }

            if (x > pAfter.key) {
                pAfter.right = newNode;
            } else pAfter.left = newNode;
            newNode.father = pAfter;
        }
        return true;
    }

    public void add(int... a) {
        for (int x : a) {
            this.add(x);
        }
    }

    public void printLevelBased() {
        IntBstNode result;
        if (root == null) {
            System.out.println("\nEmpty Tree");
        } else {
            LinkedList<IntBstNode> queue = new LinkedList();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                result = queue.removeFirst();
                System.out.print(result.toString() + " ");
                if (result.left != null) {
                    queue.addLast(result.left);
                }
                if (result.right != null) {
                    queue.addLast(result.right);
                }
            }
            System.out.println();
        }
    }

    private void printNLR(IntBstNode p) {
        if (p != null) {
            System.out.print("" + p + " ");
            printNLR(p.left);
            printNLR(p.right);
        }

    }

    public void printNLR() {
        if (root == null) {
            System.out.println("\nEmpty Tree");
        } else {
            printNLR(root);
        }
        System.out.println("");
    }

    private void printAlign(IntBstNode p, int nSpace) {
        if (p != null) {
            for (int i = 0; i < nSpace; i++) {
                System.out.print(" ");
            }
            System.out.println(p.key);
            printAlign(p.left, nSpace + 3);
            printAlign(p.right, nSpace + 3);
        }
    }

    public void printAlign() {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            printAlign(root, 0);
        }
    }

    private void printLNR(IntBstNode p) {
        if (p != null) {
            printLNR(p.left);
            System.out.print("" + p + " ");
            printLNR(p.right);
        }

    }

    public void printLNR() {
        if (root == null) {
            System.out.println("\nEmpty Tree");
        } else {
            printLNR(root);
        }
        System.out.println("");
    }

    private void printRNL(IntBstNode p) {
        if (p != null) {
            printRNL(p.right);
            System.out.print("" + p + " ");
            printRNL(p.left);
        }
    }

    public void printRNL() {
        if (root == null) {
            System.out.println("\nEmpty Tree");
        } else {
            printRNL(root);
        }
        System.out.println("");
    }

    private void printPostOder(IntBstNode p) {
        if (p != null) {
            printPostOder(p.left);
            printPostOder(p.right);
            System.out.print("" + p + " ");

        }
    }

    public void printPostOder() {
        if (root == null) {
            System.out.println("\nEmpty Tree");
        } else {
            printPostOder(root);
        }
        System.out.println("");
    }

    public IntBstNode search(int x) {
        IntBstNode result = root;
        while (result != null) {
            if (result.key == x) {
                return result;
            }
            if (x > result.key) {
                result = result.right;
            } else {
                result = result.left;
            }
        }
        return null;
    }

    public int getMin() {
        if (root == null) {
            throw new RuntimeException("Empty Tree");
        }

        IntBstNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.key;
    }

    public int getMax() {
        if (root == null) {
            throw new RuntimeException("Empty Tree");
        }

        IntBstNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.key;
    }

    public int getHeight() {
        class Node_level {

            int level;
            IntBstNode node;

            public Node_level(int l, IntBstNode node) {
                this.level = l;
                this.node = node;
            }
        }

        if (root == null) {
            return 0;
        }
        LinkedList<Node_level> queue = new LinkedList();
        Node_level nl = new Node_level(0, root);
        queue.add(nl);
        int result = 0;
        while (!queue.isEmpty()) {
            nl = queue.removeFirst();
            int curL = nl.level;
            if (result < curL) {
                result = curL;
            }
            if (nl.node.right != null) {
                queue.add(new Node_level(curL + 1, nl.node.right));
            }
            if (nl.node.left != null) {
                queue.add(new Node_level(curL + 1, nl.node.left));
            }
        }
        return result;
    }

    public double getAverage() {
        double n = 0, sum = 0;
        IntBstNode node;
        LinkedList<IntBstNode> queue;

        if (root == null) {
            return 0;
        } else {
            queue = new LinkedList();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                node = queue.removeFirst();
                n++;
                sum += node.key;
                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return sum / n;
    }

    private boolean removeLeaf(IntBstNode leaf) {
        if (!leaf.isLeaf()) {
            return false;
        }
        if (leaf == root && root.isLeaf()) {
            root = null;
        } else {
            IntBstNode father = leaf.father;
            if (father.left == leaf) {
                father.left = null;
            } else {
                father.right = null;
            }
        }
        return true;
    }

    private boolean removeOneChildNode(IntBstNode delNode) {
        if (delNode == null || delNode.have2Children() || delNode.isLeaf()) {
            return false;
        }
        if (delNode == root) {
            if (root.left == null) {
                root = root.right;
            } else {
                root = root.left;
            }
            root.father = null;
        } else {
            IntBstNode father = delNode.father;
            IntBstNode child = null;
            if (delNode.left == null) {
                child = delNode.right;
            } else {
                child = delNode.left;
            }
            if (delNode == father.left) {
                father.left = child;
            } else {
                father.right = child;
            }
            child.father = father;
        }
        return true;
    }

    private boolean deleteByMerging(IntBstNode delNode) {
        if(delNode.isLeaf() || delNode.have1Child()) return false;
        IntBstNode grandFather = delNode.father;
        IntBstNode leftGrandChild = delNode.left;
        IntBstNode rightGrandChild = delNode.right;
        IntBstNode rightMost = leftGrandChild;
        while(rightMost.right!=null)
            rightMost = rightMost.right;
        rightMost.right = rightGrandChild;
        rightGrandChild.father = rightMost;
        if(delNode==root) {
            root = root.left;
            root.father=null;
        }
        else {
            if(grandFather.left==delNode)
                grandFather.left=leftGrandChild;
            else grandFather.right=leftGrandChild;
            leftGrandChild.father=grandFather;
        }
        return true;
    }

    public boolean deleteByMerging(int x) {
        IntBstNode delNode = search(x);
        if (delNode == null) {
            return false;
        }
        if (delNode.isLeaf()) {
            return removeLeaf(delNode);
        }
        if (delNode.have1Child()) {
            return removeOneChildNode(delNode);
        }
        return deleteByMerging(delNode);
    }

    private boolean deleteByCopy(IntBstNode delNode) {
        if (!delNode.have2Children()) {
            return false;
        }
        IntBstNode rightMost = delNode.left;
        while (rightMost.right != null) {
            rightMost = rightMost.right;
        }
        delNode.key = rightMost.key;
        if (rightMost.isLeaf()) {
            removeLeaf(rightMost);
        }
        if (rightMost.have1Child()) {
            removeOneChildNode(rightMost);
        }
        return true;
    }

    public boolean deleteByCopy(int x) {
        IntBstNode delNode = search(x);
        if (delNode == null) {
            return false;
        }
        if (delNode.isLeaf()) {
            removeLeaf(delNode);
        }
        if (delNode.have1Child()) {
            removeOneChildNode(delNode);
        }
        return deleteByCopy(delNode);
    }
}
