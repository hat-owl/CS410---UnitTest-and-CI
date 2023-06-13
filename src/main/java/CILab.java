public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
             /*  All letters in this word are capitals, like "USA".
                *  All letters in this word are not capitals, like "leetcode".
                *  Only the first letter in this word is capital, like "Google".
              */

        char[] stringArray = myString.toCharArray();

        for (int i = 0; i < stringArray.length; i++)
            if (!Character.isLetter(stringArray[i]))
                throw new IllegalArgumentException("String must be a single word composed of letters");

        // no word, so it can't have correct capital use
        if (myString.length() == 0)
            return false;

        // if word is one character, then it's either all uppercase or all lowercase and hence valid
        if (myString.length() == 1)) {
            return true;
        }

        if (Character.isLowerCase(stringArray[0])) {
            // if the first character is lowercase, the rest must all be as well
            for (int i = 1; i < stringArray.length; i++) {
                if (!Character.isLowerCase(stringArray[i]))
                    return false;
            }
        } else {
            // if the first character is uppercase, then the rest of the characters must all be either upper- or lowercase
            // assumption: word has at least two characters (see early returns above)
            if (Character.isUpperCase(stringArray[1])) {
                for (int i = 2; i < stringArray.length; i++) {
                    Character.isUpperCase(stringArray[i]);
                }
            } else { // char at index 1 is lowercase
                for (int i = 2; i < stringArray.length; i++) {
                    Character.isLowerCase(stringArray[i]);
                }
            }
        }

        return true;
    }

}

