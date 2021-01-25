package com.go2it.tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillsMatcherTest {

    @Test
    public void findMatchesTestExactMatch() {
        BiPredicate<String, String> filter = String::equals;
        String[] desired = {"Excel", "C", "Word", "AI", "Ethereum"};
        String[] presentSkills = {"Cobol", "Outlook", "Bookkeeping", "Word", "Leadership", "AI", "Blockchain"};
        assertEquals(Stream.of("Word", "AI").collect(Collectors.toList()), SkillsMatcher.matchSkills(desired, presentSkills, filter));
    }

    @Test
    public void findMatchesTestNonExactMatch() {
        BiPredicate<String, String> filter2 = (skill, desiredSkill) -> {
            String[] split = skill.split("( |\\(|\\))");
            List<String> skillsPart = Arrays.asList(split);
            return skillsPart.contains(desiredSkill);
        };
        String[] desired = {"Excel", "C", "Word", "AI", "Ethereum"};
        String[] presentSkills2 = {"PasCal", "MS Excel 2013", "MS Word", "Blockchain (Ethereum)"};
        assertEquals(Stream.of("Excel", "Word", "Ethereum").collect(Collectors.toList()), SkillsMatcher.matchSkills(desired, presentSkills2, filter2));
    }

    @Test
    public void findMatchesSetTestExactMatch() {
        BiPredicate<String, String> filter = String::equals;
        String[] desired = {"Excel", "C", "Word", "AI", "Ethereum"};
        String[] presentSkills = {"Cobol", "Outlook", "Bookkeeping", "Word", "Leadership", "AI", "Blockchain"};
        assertEquals(Stream.of("Word", "AI").collect(Collectors.toList()), SkillsMatcher.matchSkillsSet(desired, presentSkills, filter));
    }

    @Test
    public void findMatchesSetTestNonExactMatch() {
        BiPredicate<String, String> filter2 = (skill, desiredSkill) -> {
            String[] split = skill.split("( |\\(|\\))");
            List<String> skillsPart = Arrays.asList(split);
            return skillsPart.contains(desiredSkill);
        };
        String[] desired = {"Excel", "C", "Word", "AI", "Ethereum"};
        String[] presentSkills2 = {"PasCal", "MS Excel 2013", "MS Word", "Blockchain (Ethereum)"};
        assertEquals(Stream.of("Excel", "Word", "Ethereum").collect(Collectors.toList()), SkillsMatcher.matchSkillsSet(desired, presentSkills2, filter2));
    }

}
