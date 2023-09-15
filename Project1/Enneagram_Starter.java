import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Enneagram_Starter {
    //Instance fields are given
    private ArrayList<ArrayList<String>> tests;
    private String filename;
    final private String[][] validAnswers = {{"B", "E"},
            {"A", "G"},
            {"C", "D"},
            {"H", "I"},
            {"E", "F"},
            {"A", "B"},
            {"D", "G"},
            {"F", "H"},
            {"C", "I"},
            {"A", "E"},
            {"G", "H"},
            {"B", "D"},
            {"C", "F"},
            {"E", "I"},
            {"D", "H"},
            {"B", "G"},
            {"A", "F"},
            {"C", "E"},
            {"B", "I"},
            {"D", "F"},
            {"C", "G"},
            {"A", "H"},
            {"B", "F"},
            {"G", "I"},
            {"D", "E"},
            {"A", "I"},
            {"B", "C"},
            {"E", "H"},
            {"F", "G"},
            {"D", "I"},
            {"A", "C"},
            {"B", "H"},
            {"E", "G"},
            {"A", "D"},
            {"F", "I"},
            {"C", "H"}};

    public Enneagram_Starter(String filename) throws FileNotFoundException {
        //The "tests" ArrayList is a 2-D ArrayList. Each row is one student's data - their name and their answers to the
        //Enneagram personality test (i.e., one row has 37 columns)
        this.tests = new ArrayList<>();
        this.filename = filename;
    }

    /**
     * method: processResults
     * @throws FileNotFoundException
     */
    public void processResults() throws FileNotFoundException {
        //TODO:  Using the filename field, read in each student's data, adding it to the "tests" 2-D ArrayList
        // Because the Enneagram test is exactly 36 questions, you may hard code 37 (name plus 36 questions) if you want.
        // However, DO NOT hard code the number of rows (number of lines in file). Be sure to close your file!
        // Error Checking - if the student data is more than 37, throw an Exception
        //                - if an answer is not valid for that question throw an Exception. Otherwise, add it to the
        //                "tests" ArrayList (call the validateAnswers method with ONE student's data at a time - see later)
        // HINT: I think it is easiest to use the String split method to parse each student's data. The problem is that
        //       you need the resulting String array to be a String ArrayList.  Google this, but Java has an
        //       Arrays static method that will convert the String array to a String ArrayList in one line!






     }

    /**
     * method validateAnswers
     * @param oneStudent
     * @return
     */
    private boolean validateAnswers(ArrayList<String> oneStudent) {
        //TODO: validateAnswers is a private method because it is only called from the processResults method.
        // Notice you only process ONE student's data.  Step through this student's ArrayList of data and validate
        // that their answers are valid. Use the private 2-D validAnswers array to compare acceptable answers for each
        // question. If a student's answer is invalid, throw an Exception. If all answers are valid return true (given).






        return true;
    }

    /**
     * method countTraits
     * @param start
     * @param end
     * @return
     */
    public String countTraits(int start, int end) {
        //TODO: This method accepts starting and ending indexes for the sake of brevity in the unit tests (i.e., you
        // only count traits for the students in the range from "start" up to AND including "end".
        // Count all the A-I answers for each student in the range.  Look at the unit tests for expected output
        // (first name followed by a colon, followed by a space. Then list A=  ...  for A-I and a newline).
        // Example: My output would be "Davidson: A=3 B=5 C=5 D=7 E=2 F=5 G=1 H=5 I=3\n"
        String output = "";
        int A, B, C, D, E, F, G, H, I;




        return output;
    }

    /**
     * method personalityTypes
     * @param start
     * @param end
     * @return
     */
    public String personalityTypes(int start, int end){
        //TODO: This method also accepts starting and ending indexes for the sake of brevity in the unit tests (i.e., you
        // only determine personality types for the students in the range from "start" up to AND including "end".
        // I suggest you copy and paste from the countTraits method for the first part of this method to count A-I.
        // Once you have counted up the number of A-Is for a student, you can determine which trait they are by determining
        // the maximum of A-I - I suggest you use nested Math.max as this evaluation can be done in one line of code.
        // Once you know the letter(s) with the maximum value(s), you can determine the Enneagram (i.e, personaltiy type)
        // If there is a tie, you MUST include ALL!  Although this is listed in the Enneagram instructions
        // you determine a person's personality type as follows:
        // A is 9
        // B is 6
        // C is 3
        // D is 1
        // E is 4
        // F is 2
        // G is 8
        // H is 5
        // I is 7
        // For the output variable, include the person's name, followed by a colon, a space, the personality type number,
        // a space and a newline (if there is more than one, list the number a space, the number, a space, ending with a
        // newline after the last space).
        // ALSO, add the personality type to the "tests" ArrayList (if there is more than one type, each
        // personality type should be its own element in the ArrayList).
        // Example: My output would be "Davidson: 1 \n" and calling printResults will now print
        //          "Davidson B A D H F B D F I E H D C I D G A C B F C H B I D A B H F D C H E D F C 1 \n"
        String output = "";
        int A, B, C, D, E, F, G, H, I;
        int max = -1;



        return output;
    }

    /**
     * method countClass
     * @param start
     * @param end
     * @return
     */
    public int[] countClass(int start, int end){
        // TODO: This method also accepts starting and ending indexes for the sake of brevity in the unit tests (i.e., you
        //  only count personality types for the students in the range from "start" up to AND including "end".
        //  You should first call the "personalityTypes" method to ensure the last entries in the student data is/are their
        //  personality type(s). Then step through each student data populating the "results" array with the count of
        //  each personality type. If a student has more than one type, you must include all the types in "results"
        //  Example:  If mine were the only entry then results would be "results = [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //  NOTE: The unit tests for this method will know that the personality types are not previously appended
        //        If this were for production, we would likely call the personalityTypes method in the constructor, but
        //        we are purposely not doing this so we can unit test each method.
        int [] results = {0,0,0,0,0,0,0,0,0,0};



        return results;
    }

    /**
     * method: mostCommonTrait
     * @param start
     * @param end
     * @return
     */
    public String mostCommonType(int start, int end) {
        //TODO: This method also accepts starting and ending indexes for the sake of brevity in the unit tests (i.e., you
        // only count personality types for the students in the range from "start" up to AND including "end".
        // Call the "countClass" method, which returns an int array of the count. Then, determine the most common
        // personality type(s) by determining the maximum in the "results" array. If there is more than one type with
        // the max, you must return ALL types
        String output = "";
        int max = -1;



        return output;
    }
    /**
     * method printResults is given to you and prints out each student's data.
     * @param start
     * @param end
     * @return
     */
    public String printResults(int start, int end) {
        String output = "";
        ArrayList<String> oneTest;
        for (int i = start; i <= end; i++) {
            oneTest = tests.get(i);
            for (String oneAnswer : oneTest) {
                output += oneAnswer + " ";
            }
            output += "\n";
        }
        return output;
    }

}
