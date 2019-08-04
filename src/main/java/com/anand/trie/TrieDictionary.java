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
public class TrieDictionary {

    private TrieNode root = new TrieNode();

    private static final int WORD_LENGTH = 13;

    /**
     *
     * @param registrationNumber
     * @param slotNumber
     */
    public void insert(final String registrationNumber, final Integer slotNumber){

        final char[] charArray = registrationNumber.toCharArray();

        TrieNode trieNode = root;
        for(char c: charArray){
            trieNode.setChild(c);
            trieNode = trieNode.getChild(c);
        }
        trieNode.setSlotNumber(slotNumber);
    }

    /**
     *
     * @param registrationNumber
     * @return vehicle
     */
    public Integer search(final String registrationNumber){
        if(root == null){
            return null;
        }

        final char[] charArray = registrationNumber.toCharArray();

        TrieNode trieNode = root;
        for(char c: charArray){
            trieNode = trieNode.getChild(c);
            if(trieNode==null){
                return null;
            }
        }
        return trieNode.getSlotNumber();
    }

    /**
     *
     * @param registrationNumber
     */
    public void delete(final String registrationNumber){
        if(root == null){
            return;
        }

        final char[] charArray = registrationNumber.toCharArray();

        TrieNode trieNode = root;
        for(char c: charArray){
            trieNode = trieNode.getChild(c);
            if(trieNode==null){
                return;
            }
        }
        trieNode.setSlotNumber(null);
    }
}
