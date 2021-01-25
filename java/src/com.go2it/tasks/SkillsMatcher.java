package com.go2it.tasks;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// HR is looking for employees with the following skills:
// const desiredSkills = ["Excel", "C", "Word", "AI", "Ethereum"];

// 1.
// There is a candidate with following skills
// const candidateSkills = ["Cobol", "Outlook", "Bookkeeping", "Word", "Leadership", "AI", "Blockchain"];
// => Find the matching skills of the candidate!

// 2.
// HR also uses another data source which doesn't produce literal matches:
// const candidateSkillsPartial = ["Pascal", "MS Excel 2013", "MS Word", "Blockchain (Ethereum)"];
// => Find all matching skills, including partial matches!
//    Use the same function as before and make sure that question 1 still works.
//    Hint: Use a predicate function.

// BiPredicate

// Example
//  BiPredicate<Long, Long> predicate2 = (x, y) -> x == y;
//    System.out.println(predicate1.and(predicate2).test(5l, 5l));

// 3.
// HR wants to refine the search and use weights for each skill.
// The importance of the skill is rated from 1 (low) to 10 (high).
// const ratedDesiredSkills = [["Excel", 4], ["Word", 10], ["Matlab", 7], ["AI", 5]];
// The candidate's skills are rated from 1 to 10.
// const ratedCandidateSkills = [["Pascal", 2], ["Ms Excel 2013", 9], ["MS Word", 4], ["Blockchain (Ethereum)", 8]];
// => Use the existing function to find a match and calculate an overall score using the ratings!
//    Use the same function as before, make sure that previous solutions still work.
//    Hint: Use a second lambda function to return scores.

import java.util.*;
import java.util.function.BiPredicate;

public class SkillsMatcher {


    public static List<String> matchSkills(String[] desired, String[] actual, BiPredicate<String, String> filter) {
        return findMatches(actual, desired, filter);
    }

    /**
     * O(n+m) solution
     * Everything is stored in Set, each entry is split by regex to make sure the we don't have complex elements inside like
     * "Ms Word 2013"
     *
     * @param desired
     * @param actual
     * @param filter
     * @return
     */
    public static List<String> matchSkillsSet(String[] desired, String[] actual, BiPredicate<String, String> filter) {
        return findMatchesSet(actual, desired, filter);
    }

    public static List<String> findMatches(String[] actual, String[] desired, BiPredicate<String, String> test) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < actual.length; i++) {
            map.put(actual[i], "present");
        }

        List<String> matchedSkills = new ArrayList<>(desired.length);
        for (int i = 0; i < desired.length; i++) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String skill = entry.getKey();

                if (test.test(skill, desired[i])) {
                    matchedSkills.add(desired[i]);
                }
            }
        }
        return matchedSkills;
    }

    public static List<String> findMatchesSet(String[] actual, String[] desired, BiPredicate<String, String> test) {
        HashSet<String> actualSet = new HashSet<>(actual.length);
        for (int i = 0; i < actual.length; i++) {
            String[] split = actual[i].split("( |\\(|\\))");
            for (int j = 0; j < split.length; j++) {
                actualSet.add(split[j]);
            }
        }

        List<String> matchedSkills = new ArrayList<>(desired.length);
        for (int i = 0; i < desired.length; i++) {
            if (actualSet.contains(desired[i])) {
                matchedSkills.add(desired[i]);
            }
        }
        return matchedSkills;
    }

    static class Node {
        private String value;
        private Node left;
        private Node right;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


}
