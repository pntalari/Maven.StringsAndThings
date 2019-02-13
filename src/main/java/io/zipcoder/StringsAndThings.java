package io.zipcoder;


import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        String[] wordsCnt = new String[input.length()];
        wordsCnt = input.split(" ");
        int count = 0;
        for (int pos = 0; pos < wordsCnt.length; pos++) {
            if ((input.charAt(input.length() - 1) == 'y' || input.charAt(input.length() - 1) == 'z')
                    && Character.isLetter(input.charAt(pos))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String[] removeStr = new String[base.length()];
        String strNew = new String();
        for (int i = 0; i < base.length(); i++) {
            strNew = base.replace(remove, "");
        }
        return strNew;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int isCnt = 0;
        int notCnt = 0;
        String isStr = "is";
        String notStr = "not";

        isCnt = strEquals(input,isStr);
        notCnt = strEquals(input,notStr);

        return (isCnt == notCnt);

/*
        for (int i = 0; i<input.length(); i++) {
            if (arr[i].contentEquals("is")) {
                isCnt++;
            } else if (arr[i].contentEquals("not")) {
                notCnt++;
            }
        }

        if (notCnt == isCnt) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
*/
    }

    private int strEquals(String input, String toFind) {
        int index = 0;
        int count = 0;

        while (index != -1) {
            index = input.indexOf(toFind, index);
            if (index != -1) {
                index += toFind.length();
                count++;
            }
        }
        return count;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        boolean bool = false;
        int index = 0;
        String strToFind = "gg";

  /*      while (index != -1) {
            index = input.indexOf(strToFind, index);
            if (input.charAt(index) == input.charAt(index+1))
                bool = true;
            index++;
            if (index != -1) {
                index += strToFind.length();

            }
*/
            for (int i = 0; i < input.length() - 1; i++) {
                if ((input.charAt(i) == input.charAt(i + 1)) && (input.charAt(i) == 'g')) {
                    bool = true;
                } else if ((input.charAt(i) == 'g') && (input.charAt(i) != input.charAt(i + 1))) {
                    bool = false;
                }
            }

            return bool;
        }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        int counter = 0;

        for (int i =0; i<input.length()-2;i++)
        {
         if(input.charAt(i)==input.charAt(i+1) && input.charAt(i) == input.charAt(i+2))
         {
             counter++;
         }

        }
        return counter;
    }
}
