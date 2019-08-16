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
public class RegistrationNumberAlphabet implements Alphabet {

    //Dictionary alphabets A-Z,0-1,- to store slotNumber registration number.
    // Eg: KA-01-HH-9999
    public final static int ALPHABET_SIZE = 26+10+1;
    private final static int A = 'A';
    private final static int ZERO = '0';
    private final static int DASH = '-';


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
        } else if(c>='0' && c<='9'){
            return c-ZERO + 26;
        } else if(c==DASH){
            return c-DASH + 26+10;
        }else {
            throw new TrieCharacterNotSupportedException(String.format("Character %s not supported",c));
        }
    }
}
