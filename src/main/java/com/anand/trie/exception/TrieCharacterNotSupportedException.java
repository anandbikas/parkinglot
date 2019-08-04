/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.trie.exception;

public class TrieCharacterNotSupportedException extends RuntimeException {

    /**
     *
     */
    public TrieCharacterNotSupportedException() {
        super();
    }

    /**
     *
     * @param message
     */
    public TrieCharacterNotSupportedException(String message) {
        super(message);
    }
}
