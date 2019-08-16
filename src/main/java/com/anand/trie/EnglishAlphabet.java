/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.trie;

import com.anand.trie.exception.TrieCharacterNotSupportedException;

/**
 *
 */
public class EnglishAlphabet implements Alphabet {

    private final static int ALPHABET_SIZE = 26;
    private final static int A = 'A';

    /**
     *
     * @return
     */
    public int getSize(){
        return ALPHABET_SIZE;
    }

    /**
     *
     * @param c
     * @return
     * @throws TrieCharacterNotSupportedException
     */
    public int charToIndex(char c){
        c = Character.toUpperCase(c);
        if(c>='A' && c<='Z'){
            return Character.toUpperCase(c)-A;
        } else {
            throw new TrieCharacterNotSupportedException(String.format("Character %s not supported", c));
        }
    }
}
