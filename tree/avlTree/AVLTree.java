class Node {
    int key;
    int height;
    Node left, right;

    Node (int d) {
        key = d;
        height = 1;
    }

}

public class AVLTree {
    Node root;

    //utility function to get height of tree
    public int height(Node n){
        if (n == null){
            return 0;
        }
        return n.height;
    }

    public int max(int left , int right){
        if (left >= right){
            return left;
        }else {
            return right;
        }
    }

    public Node rotateLeft(Node x){
        Node y = x.right; 
        Node t = y.left;

        y.left = x;
        x.right = t;

        x.height = max( height(x.left), height(x.right) ) + 1;
        y.height = max( height(y.left), height(y.right) ) + 1;

        return y;  
    }

    public Node rotateRight(Node z){
        Node y = z.left;
        Node t = y.right;

        y.right = z;
        z.left = t;
        
        //update the z node first since it is lower in the tree
        z.height = max ( height(z.left), height(z.right) ) + 1;
        y.height = max ( height(y.left), height(y.right) ) + 1; 

        return y;
    }

    public int getBalance(Node n){
        if (n == null){
            return 0;
        }
        return (height(n.left) - height(n.right));
    }

    public Node insert(Node pNode, int key){
        if (pNode == null){
            return new Node(key);
        }else{
            if (key < pNode.key){
                pNode.left = insert(pNode.left, key);
            }else {
                pNode.right = insert(pNode.right, key);
            }
        }

        pNode.height = max( height(pNode.left), height(pNode.right)) +1;

        int balance = getBalance(pNode);
        //left left
        if (balance > 1 && key < pNode.left.key){
            return ( rotateRight(pNode) );    
        }
        //left right
        if (balance > 1 && key > pNode.left.key){
            pNode.left = rotateLeft(pNode.left);
            return rotateRight(pNode);
        }
        //right right
        if (balance < -1 && key > pNode.right.key){
            return (rotateLeft(pNode));            
        }
        //right left
        if (balance < -1 && key < pNode.right.key){
            pNode.right = rotateRight(pNode.right);
            return (rotateLeft(pNode));
        }

        return pNode;
    }

    public int retrieveData(Node pNode){
        while (pNode.left != null){
            pNode = pNode.left;
        }
        return pNode.key;
    }

    public Node delete(Node pNode, int key){
        if (pNode == null){
            System.out.println("Not found");
            return pNode;
        }else if (key < pNode.key){
            pNode.left = delete(pNode.left, key);
        }else if (key > pNode.key){
            pNode.right = delete(pNode.right, key);
        }else{  //node found
            if (pNode.left  == null)
                return pNode.right; 
            else if (pNode.right == null)
                return pNode.left;
            else{ //node with two children
                int tmpKey = retrieveData(pNode.right);
                pNode.key = tmpKey;
                pNode.right = delete(pNode.right, tmpKey);

            }
        } 

        pNode.height = max(height(pNode.left), height(pNode.right)) +1;

        int balance = getBalance(pNode);
        
        //left left
        if (balance > 1 && getBalance(pNode.left) >= 0){ //left height greater or equal
            return rotateRight(pNode);
        }
        // left right
        if (balance > 1 && getBalance(pNode.left) < 0) { //right side greater
            pNode.left = rotateLeft(pNode.left);
            return rotateRight(pNode);

        }
        //right right
        if (balance < -1 && getBalance(pNode.right) <= 0){
            return rotateLeft(pNode);
        }
        //right left
        if (balance < -1 && getBalance(pNode.right) > 0){
            pNode.right = rotateRight(pNode.right);
            return rotateLeft(pNode);
        }
        
        return pNode;
    }    
    
    public void preOrder(Node pNode){
        if (pNode != null){
            System.out.println(pNode.key);
            preOrder(pNode.left);
            preOrder(pNode.right);
        }

    }

    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        tree.root = tree.delete(tree.root, 10);

        tree.preOrder(tree.root);

    }

}
