package com.anand.trie;

import com.anand.trie.exception.TrieCharacterNotSupportedException;

/**
 * TrieNode for dictionary
 */
public class TrieNode {

    //Dictionary alphabets A-Z,0-1,- to store slotNumber registration number.
    // Eg: KA-01-HH-9999
    public final static int ALPHABET_SIZE = 26+10+1;
    private final static int A = 'A';
    private final static int ZERO = '0';
    private final static int DASH = '-';


    private TrieNode [] children = new TrieNode[ALPHABET_SIZE];

    //if slotNumber == null, this is not a dictionary word.
    private Integer slotNumber;

    /**
     *
     */
    public TrieNode(){
        super();
    }

    /**
     *
     * @param c
     * @return
     * @throws TrieCharacterNotSupportedException
     */
    private int charToIndex(final char c){
        if(c>='A' && c<='Z'){
            return Character.toUpperCase(c)-A;
        } else if(c>='0' && c<='9'){
            return c-ZERO + 26;
        } else if(c==DASH){
            return c-DASH + 26+10;
        }else {
            throw new TrieCharacterNotSupportedException(String.format("Character %s not supported",c));
        }
    }

    /**
     *
     * @param c
     */
    public void setChild(final char c){

        final int childIndex = charToIndex(c);
        if(children[childIndex] == null){
            children[childIndex] = new TrieNode();
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public TrieNode getChild(final char c){
        return children[charToIndex(c)];
    }

    /**
     *
     * @return
     */
    public Integer getSlotNumber() {
        return slotNumber;
    }

    /**
     *
     * @param slotNumber
     */
    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TrieNode{" +
                "slotNumber='" + slotNumber + '\'' +
                '}';
    }
}
