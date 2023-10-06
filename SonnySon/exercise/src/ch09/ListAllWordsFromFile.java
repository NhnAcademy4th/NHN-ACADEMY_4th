//package ch09;
//
//import ch09.resource.TextIO;
//import java.util.ArrayList;
//
///**
// * Makes an alphabetical list of all the words in a file selected
// * by the user.  The list can be written to a file.
// */
//public class ListAllWordsFromFile {
//
//    public static void main(String[] args) {
//
//        TextIO.getln();  // Wait for user to press return.
//
//        SortTree sortTree = new SortTree();
//
//        try {
//            if (TextIO.readUserSelectedFile() == false) {
//                System.out.println("No input file selected.  Exiting.");
//                System.exit(1);
//            }
//            ArrayList<String> wordList = new ArrayList<String>();
//            String word = readNextWord();
//            while (word != null) {
//                word = word.toLowerCase();  // convert word to lower case
//                if ( !sortTree.treeContains(sortTree.getRoot(), word) ) {
//                    // This is a new word, so add it to the list
//                    sortTree.treeContains(sortTree.getRoot(), word);
//                }
//                word = readNextWord();
//            }
//            System.out.println("Number of different words found in file:  "
//                    + SortTree.countNodes(sortTree.getRoot()));
//            System.out.println();
//            if (SortTree.countNodes(sortTree.getRoot()) == 0) {
//                System.out.println("No words found in file.");
//                System.out.println("Exiting without saving data.");
//                System.exit(0);
//            }
//            selectionSort(sortTree);
//            TextIO.writeUserSelectedFile(); // If user cancels, output automatically
//            // goes to standard output.
//            TextIO.putln(SortTree.countNodes(sortTree.getRoot()) + " words found in file:\n");
//            for (String w : wordList)
//                TextIO.putln("   " + w);
//            System.out.println("\n\nDone.\n\n");
//        }
//        catch (Exception e) {
//            System.out.println("Sorry, an error has occurred.");
//            System.out.println("Error Message:  " + e.getMessage());
//        }
//        System.exit(0);  // Might be necessary, because of use of file dialogs.
//    }
//
//
//    /**
//     * Sorts a list of strings into lexicographical order, using
//     * selection sort and treating the list much like an array.  In this
//     * program, the list only contains words made up of lower case
//     * letters, so lexicographic order is the same as alphabetical order.
//     */
//    private static void selectionSort(ArrayList<String> list) {
//        for (int top = list.size() - 1; top > 0; top--) {
//            int indexOfBiggest = 0;
//            for (int j = 0; j < top; j++) {
//                String str = list.get(j);
//                if (str.compareTo( list.get(indexOfBiggest) ) > 0) {
//                    indexOfBiggest = j;
//                }
//            }
//            String temp = list.get(top);
//            list.set( top, list.get(indexOfBiggest) );
//            list.set( indexOfBiggest, temp );
//        }
//    }
//
//    private static String readNextWord() {
//        char ch = TextIO.peek(); // Look at next character in input.
//        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
//            // Skip past non-letters.
//            TextIO.getAnyChar();  // Read the character.
//            ch = TextIO.peek();   // Look at the next character.
//        }
//        if (ch == TextIO.EOF) // Encountered end-of-file
//            return null;
//        // At this point, we know that the next character, so read a word.
//        String word = "";  // This will be the word that is read.
//        while (true) {
//            word += TextIO.getAnyChar();  // Append the letter onto word.
//            ch = TextIO.peek();  // Look at next character.
//            if ( ch == '\'' ) {
//                // The next character is an apostrophe.  Read it, and
//                // if the following character is a letter, add both the
//                // apostrophe and the letter onto the word and continue
//                // reading the word.  If the character after the apostrophe
//                // is not a letter, the word is done, so break out of the loop.
//                TextIO.getAnyChar();   // Read the apostrophe.
//                ch = TextIO.peek();    // Look at char that follows apostrophe.
//                if (Character.isLetter(ch)) {
//                    word += "\'" + TextIO.getAnyChar();
//                    ch = TextIO.peek();  // Look at next char.
//                }
//                else
//                    break;
//            }
//            if ( ! Character.isLetter(ch) ) {
//                // If the next character is not a letter, the word is
//                // finished, so break out of the loop.
//                break;
//            }
//            // If we haven't broken out of the loop, next char is a letter.
//        }
//        return word;  // Return the word that has been read.
//    }
//
//} // end ListAllWordsFromFile