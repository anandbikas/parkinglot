/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.trie;

/**
 * TrieDictionary
 *
 * Complexity: (provided word length is constant)
 *  1. insert : O(1)
 *  2. delete : O(1)
 *  3. search : O(1)
 */
public class TrieDictionary<T> {

    private TrieNode root;

    /**
     *
     */
    public TrieDictionary() {
        super();
        root = new TrieNode(new EnglishAlphabet());
    }

    /**
     *
     * @param alphabet
     */
    public TrieDictionary(Alphabet alphabet) {
        this.root = new TrieNode(alphabet);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void insert(final String key, final T value){

        final char[] charArray = key.toCharArray();

        TrieNode trieNode = root;
        for(char c: charArray){
            trieNode.setChild(c);
            trieNode = trieNode.getChild(c);
        }
        trieNode.setValue(value);
    }

    /**
     *
     * @param key
     * @return
     */
    public T search(final String key){
        if(root == null){
            return null;
        }

        final char[] charArray = key.toCharArray();

        TrieNode<T> trieNode = root;
        for(char c: charArray){
            trieNode = trieNode.getChild(c);
            if(trieNode==null){
                return null;
            }
        }
        return trieNode.getValue();
    }

    /**
     *
     * @param key
     * @return
     */
    public void delete(final String key){
        if(root == null){
            return;
        }

        final char[] charArray = key.toCharArray();

        TrieNode<T> trieNode = root;
        for(char c: charArray){
            trieNode = trieNode.getChild(c);
            if(trieNode==null){
                return;
            }
        }
        trieNode.setValue(null);
    }
}
