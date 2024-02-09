// This is a test file for CountKeywords program
public class TestFile {
    public static void main(String[] args) {
        // This is a comment
        String str = "public int while"; // This should not count as keywords
        /* This is a block comment containing keywords
           for while if try break extends
        */
        int number = 0; // keyword: int
        if (number < 10) { // keyword: if
            System.out.println("This is a test.");
        }
    }
}
