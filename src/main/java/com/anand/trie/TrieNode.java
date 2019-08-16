/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.trie;

/**
 * TrieNode for dictionary
 */
public class TrieNode<T> {

    private Alphabet alphabet;
    private TrieNode [] children;

    //if value == null, this is not a dictionary word. Else a corresponding value to the key.
    private T value;

    /**
     *
     */
    public TrieNode(Alphabet alphabet){
        super();
        this.alphabet = alphabet;
        this.children = new TrieNode[alphabet.getSize()];
    }


    /**
     *
     * @param c
     */
    public void setChild(final char c){
        final int childIndex = alphabet.charToIndex(c);
        if(children[childIndex] == null){
            children[childIndex] = new TrieNode(alphabet);
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public TrieNode getChild(final char c){
        return children[alphabet.charToIndex(c)];
    }

    /**
     *
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TrieNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
