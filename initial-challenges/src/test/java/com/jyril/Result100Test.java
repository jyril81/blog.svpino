package com.jyril;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.Exception;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jyril81 on 12.05.2015.
 */
public class Result100Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Result100.Branch branch;

    @Before
    public void setUp() throws Exception {
        branch = Result100.Branch.empty();
    }

    @Test
    public void testCreateEmptyBranch() {
        assertTrue(branch.canonical().isEmpty());
    }

    @Test
    public void testBranchConcat() {
        branch = branch.concat('1');
        assertEquals("1", branch.canonical());
        branch = branch.concat('2');
        assertEquals("12", branch.canonical());
    }

    @Test
    public void testBranchEvaluateEmptyThrows() {
        expectedException.expect(NumberFormatException.class);
        branch.evaluate();
    }

    @Test
    public void testBranchEvaluateOneSymbolDigit() {
        Result100.Branch concat = branch.concat('1');
        assertEquals(1, concat.evaluate());
    }

    @Test
    public void testBranchEvaluateMultiSymbolDigit() {
        branch = branch.concat('1');
        branch = branch.concat('2');
        assertEquals(12, branch.evaluate());
    }

    @Test
    public void testBranchEvaluateInvalidExpressionThrows() {
        branch = branch.concat('1');
        branch = branch.concat('+');
        expectedException.expect(NumberFormatException.class);
        this.branch.evaluate();
    }

    @Test
    public void testBranchEvaluateAddition() {
        branch = branch.concat('1');
        branch = branch.concat('+');
        branch = branch.concat('2');
        assertEquals(3, branch.evaluate());
    }

    @Test
    public void testBranchEvaluateSubstraction() {
        branch = branch.concat('1');
        branch = branch.concat('-');
        branch = branch.concat('2');
        assertEquals(-1, branch.evaluate());
    }

    @Test
    public void testBranchEvaluateResult100() {
        branch = branch.concat('1');
        branch = branch.concat('+');
        branch = branch.concat('2');
        branch = branch.concat('+');
        branch = branch.concat('3');
        branch = branch.concat('4');
        branch = branch.concat('-');
        branch = branch.concat('5');
        branch = branch.concat('+');
        branch = branch.concat('6');
        branch = branch.concat('7');
        branch = branch.concat('-');
        branch = branch.concat('8');
        branch = branch.concat('+');
        branch = branch.concat('9');
        assertEquals(100, branch.evaluate());
    }

    @Test
    public void testResult100AppendDigit() {
        Result100 result100 = new Result100();
        List<Result100.Branch> branches = new ArrayList<>();
        branches.add(Result100.Branch.empty());

        branches = result100.appendDigit(branches, '1');

        assertEquals(1, branches.size());
        assertEquals("1", branches.get(0).canonical());
    }


    @Test
    public void testResult100BranchTo3() {
        Result100 result100 = new Result100();
        List<Result100.Branch> branches = new ArrayList<>();
        branches.add(Result100.Branch.empty());
        branches = result100.appendDigit(branches, '1');

        branches = result100.branchTo3(branches);

        assertEquals(3, branches.size());
        assertTrue(branches.contains(Result100.Branch.empty().concat('1')));
        assertTrue(branches.contains(Result100.Branch.empty().concat('1').concat('+')));
        assertTrue(branches.contains(Result100.Branch.empty().concat('1').concat('-')));
    }
}