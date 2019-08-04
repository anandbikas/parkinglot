/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.trie;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TrieDictionaryTest {

    private TrieDictionary trieDictionary;

    @BeforeMethod
    private void setUp(){
        trieDictionary = new TrieDictionary();
    }

    @Test
    private void testTrieDictionary(){

        trieDictionary.insert("KA-01-HH-1234", 1);
        trieDictionary.insert("KA-01-HH-9999", 5);

        Assert.assertNotNull(trieDictionary.search("KA-01-HH-1234"));
        Assert.assertEquals(trieDictionary.search("KA-01-HH-9999"), (Integer) 5);

        trieDictionary.delete("KA-01-HH-9999");
        Assert.assertNull(trieDictionary.search("KA-01-HH-9999"));
    }
}
