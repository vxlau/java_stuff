import java.util.*;

public class Trie {
    static final int ALPHABET_SIZE = 26; 

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i=0; i< ALPHABET_SIZE; i++){
               children[i] = null;
            }
        }

    }

    static TrieNode root;

    static void insert(String key){
        int index;
        int length = key.length();
             

        TrieNode pCrawl = root;
        for (int level =0; level < length; level++){

            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true; 
    }

    static boolean search(String key){
        int length = key.length();

        TrieNode pCrawl = root;
        for (int level = 0; level < length; level++){
            
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index]; 
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

/*
    dsf. if isEndOfWord, print word. 
    if leaf node, go back up. 
    build up word as you go along. 
*/

    static boolean prefixDFS(TrieNode pNode, String word){
        char letter;
        if (pNode.isEndOfWord){  //leaf node also have isEndOfWord marked. 
            System.out.println(word);
        }
        if (isLeafNode(pNode)){
            return true;
        }else{
            for (int j=0; j<ALPHABET_SIZE; j++){
                int indexInt = j + 'a';
                char wordChar = (char)indexInt;
                if (pNode.children[j] != null){
                    prefixDFS(pNode.children[j], word +wordChar );
                }
            }    
        }
        return false;
    }

    //same as above but returns array instead of printing to stdout. 
    static ArrayList<String> prefixDFSArray(TrieNode pNode, String word){
        ArrayList<String> foundWords = new ArrayList<String>();
        char letter;
        if (pNode.isEndOfWord){  //leaf node also have isEndOfWord marked. 
            foundWords.add(word);
            //System.out.println(word);
        }
        if (isLeafNode(pNode)){
            return foundWords;
        }else{
            for (int j=0; j<ALPHABET_SIZE; j++){
                int indexInt = j + 'a';
                char wordChar = (char)indexInt;
                if (pNode.children[j] != null){
                    foundWords.addAll( prefixDFSArray(pNode.children[j], word +wordChar) );
                }
            }    
        }
        return foundWords;
    }


    static boolean wordsWithPrefix(String prefix){
        ArrayList<String> foundWords = new ArrayList<String>();
        int prefixLength = prefix.length();
        TrieNode pCrawl = root;
        for (int i = 0; i< prefixLength; i++){
            int index = prefix.charAt(i) - 'a';
            if (pCrawl.children[index] == null){
                return false;
            }
            pCrawl= pCrawl.children[index];
        }
        foundWords.addAll(prefixDFSArray(pCrawl, prefix));  //prefixDFSArray vs prefixDFS here 

        for (String word : foundWords){
            System.out.println(word);
        }
        return true;
    }


/*
    delete
    1) Not found ->do nothing
    2) key is prefix of another node (it has a child) -> just unmark node as endOfWord
    3) Another word is prefix of key -> delete all the nodes up to the word marked as endOfWord
    4) Unique word -> delete all the words. 
    note: only need to handle marking endOfWord for when key ends. Main focus is 
         on deleting the nodes. 
*/

    //Check to see if node has any child nodes
    static boolean isLeafNode(TrieNode tnode){
        for (int i =0; i<ALPHABET_SIZE; i++){
            if (tnode.children[i] != null){
                return false;
            }
        }  
        return true;
    }

    static boolean deleteHelper(int level, int length, String wordToDelete, TrieNode pNode){
        if (pNode != null){
            if (level == length){   //end case
                if (pNode.isEndOfWord = true){
                    pNode.isEndOfWord = false;
                }
                if (isLeafNode(pNode)){
                    return true;
                }else {
                    return false;
                } 
       
            }else {   //recursive case 
                int index = wordToDelete.charAt(level) - 'a'; 
                if (deleteHelper(level +1, length, wordToDelete, pNode.children[index])){
                    pNode.children[index] = null;
                }

                if (isLeafNode(pNode) && pNode.isEndOfWord == false){
                    return true;
                }else {
                    return false; 
                }


            }
        }
        return false;

    }    

    static void delete(String wordToDelete){
        int length = wordToDelete.length(); 
        if (length > 0){
            deleteHelper(0,length, wordToDelete, root);
        }       
    }     


    public static void main(String args[]){
        //only a - z and lowercase
        String keys[] = {"bind", "bin", "bit", "be","been"};

        root = new TrieNode();
        for (int i = 0; i < keys.length; i++){
            insert(keys[i]);
        }
 /*
        System.out.println( search("cattle")); 
        delete("cattle"); 
        System.out.println( search("cattle")); 
        System.out.println( search("cat")); 
*/
        wordsWithPrefix("b");
    }


}
