package com.jyril;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs all possibilities to put + or - or nothing
 * between the numbers 1, 2, ..., 9 (in this order) such that the result is always 100.
 * For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.
 * Created by jyril81 on 12.05.2015.
 */

public class Result100 {


    public static final int HUNDRED = 100;

    public static void main(String[] args) {
        new Result100().findResults();
    }

    public void findResults() {
        List<Branch> finalBranches = generateBranches();
        for (Branch finalBranch : finalBranches) {
            if (finalBranch.evaluate() == HUNDRED) {
                System.out.println("Expression " + finalBranch + " evaluates to 100");
            }
        }
    }

    List<Branch> generateBranches() {
        List<Branch> branches = new ArrayList<>();

        //we start with one empty branch as root node
        branches.add(Branch.empty());

        //append all digits in order
        for (int i = 1; i <= 9; i++) {
            branches = appendDigit(branches, String.valueOf(i).charAt(0));

            //generate expresson branches for all levels except last one
            if (i < 9) {
                branches = branchTo3(branches);
            }
        }

        return branches;
    }

    /**
     * Append given digit to each given branch
     *
     * @param branches is not changed
     * @param i        digit to append
     * @return new list of branches all having digit appended
     */
    List<Branch> appendDigit(List<Branch> branches, char i) {
        List<Branch> newBranches = new ArrayList<>();

        for (Branch branch : branches) {
            newBranches.add(branch.concat(i));
        }

        return newBranches;
    }

    /**
     * Generate 3 branches for each given branch
     * one existing
     * one with + appended
     * one with - appended
     *
     * @param branches
     * @return
     */
    List<Branch> branchTo3(List<Branch> branches) {
        List<Branch> newBranches = new ArrayList<>();

        newBranches.addAll(branches);

        for (Branch oldBranch : branches) {
            newBranches.add(oldBranch.concat('+'));
            newBranches.add(oldBranch.concat('-'));
        }
        return newBranches;
    }

    @Immutable
    public static class Branch {
        private static final String DIGITS = "123456789";

        private final String symbols;

        private Branch(String currentSymbols) {
            this.symbols = currentSymbols;
        }

        public static Branch empty() {
            return new Branch("");
        }

        public Branch concat(char symbol) {
            //TODO validation
            return new Branch(symbols + symbol);
        }

        public long evaluate() {
            //split to tokens by + and -
            //so that any possible operation sign will be kept as part of the number it is preceding
            String[] tokens = symbols.split("(?=[+-])");

            long result = 0L;
            for (String token : tokens) {
                result = result + Long.parseLong(token);
            }
            return result;
        }

        public String canonical() {
            return symbols;
        }

        @Override
        public boolean equals(java.lang.Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Branch branch = (Branch) o;

            return symbols.equals(branch.symbols);

        }

        @Override
        public int hashCode() {
            return symbols.hashCode();
        }

        @Override
        public String toString() {
            return "Branch{" +
                    "symbols='" + symbols + '\'' +
                    '}';
        }
    }


}
