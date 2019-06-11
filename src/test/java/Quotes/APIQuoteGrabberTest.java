package Quotes;

import org.junit.Test;

import static org.junit.Assert.*;

public class APIQuoteGrabberTest {
    String filepath = "/Users/ttb/codefellows/401/Quotes/assets/recentquotes.json";
    String testFilepath = "/Users/ttb/codefellows/401/Quotes/assets/testFile.json";

    @Test
    public void getRonSwanson() {
        String quoteOne = APIQuoteGrabber.getRonSwanson(filepath);
        String quoteTwo = APIQuoteGrabber.getRonSwanson(filepath);
        String quoteThree = APIQuoteGrabber.getRonSwanson(filepath);
        boolean one = quoteOne.equals(quoteTwo);
        boolean two = quoteTwo.equals(quoteThree);
        boolean three = quoteThree.equals(quoteOne);
        assertFalse(one);
        assertFalse(two);
        assertFalse(three);
    }

    @Test
    public void filewriterJSON() {
        // can initialize a new test file one local machine empty the test file and fill in text
        APIQuoteGrabber.filewriterJSON(testFilepath, "This will show up in the test file as an object with the author ron swanson and this as the text field");

    }
}