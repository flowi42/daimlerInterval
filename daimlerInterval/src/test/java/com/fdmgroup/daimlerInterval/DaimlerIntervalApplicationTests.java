package com.fdmgroup.daimlerInterval;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdmgroup.daimlerInterval.functionality.Calculation;
import com.fdmgroup.daimlerInterval.functionality.CompareIntervals;
import com.fdmgroup.daimlerInterval.model.Interval;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaimlerIntervalApplicationTests {
	
	private Interval interval1;
	private Interval interval2;
	private Interval interval3;
	private Interval interval4;
	private Interval interval5;
	private Interval interval6;
	private Interval interval7;
	private Interval interval8;
	private Calculation calculate;
	private CompareIntervals comparer;
	private List<Interval> intervals;
	private List<Interval> mergedIntervals;

	@Before
	public void setUp() throws Exception {
		interval1 = new Interval(20.1, 25);
		interval2 = new Interval(45, 10);
		interval3 = new Interval(20, 94);
		interval4 = new Interval(24, 48);
		interval5 = new Interval(27, 60);
		interval6 = new Interval(5, 26);
		interval7 = new Interval(5, 26);
		interval8 = new Interval(112, 176);
		intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		intervals.add(interval6);
		intervals.add(interval7);
		intervals.add(interval8);
		mergedIntervals = new ArrayList<>();
		mergedIntervals.add(interval6);
		calculate = new Calculation();
		comparer = new CompareIntervals();
	}
	
	
	
	@Test
	public void sortTest() {
		Interval interval3 = calculate.sort(interval2);
		double intervalue = interval3.getValue2();
		assertEquals(45, intervalue, 0.01);
	}
	
	@Test
	public void sort2Test() {
		Interval interval3 = calculate.sort(interval1);
		double intervalue = interval3.getValue2();
		assertEquals(25, intervalue, 0.01);
	}
	
	@Test
	public void compareTest() {
		int intervalue= comparer.compare(interval6, interval3);
		assertEquals(-1, intervalue, 0.01);
	}
	
	@Test
	public void compareCloseTest() {
		int intervalue= comparer.compare(interval1, interval3);
		assertEquals(1, intervalue, 0.01);
	}
	
	@Test
	public void compareEqualTest() {
		int intervalue= comparer.compare(interval6, interval7);
		assertEquals(0, intervalue, 0.01);
	}

	@Test
	public void sortListTest() {
		for (Interval interval : intervals) {
			interval = calculate.sort(interval);
		}
		
		Collections.sort(intervals, comparer);
		double intervalue = intervals.get(0).getValue1();
		assertEquals(5, intervalue, 0.01);
	}
	
	
	
	@Test
	public void testCombineInterval() {
		Interval newInterval = calculate.combine(interval1.getValue1(), interval4.getValue2());
		double intervalue = newInterval.getValue2();
		assertEquals(48, intervalue, 0.01);
	}
	
	@Test
	public void testSortCombine() {
		List<Interval> mergeIntervals2 = calculate.sortCombine(intervals);
		double intervalue = mergeIntervals2.get(0).getValue2();
		System.err.println(mergeIntervals2.toString());
		assertEquals(94, intervalue, 0.01);
	}
	
	@Test
	public void testCheckMergeOverlap() {
		List<Interval> mergeIntervals2 = calculate.checkMerge(interval4, mergedIntervals);
		double intervalue = mergeIntervals2.get(0).getValue2();
		assertEquals(48, intervalue, 0.01);
	}
	
	@Test
	public void testCheckMergeContain() {
		List<Interval> mergeIntervals2 = calculate.checkMerge(interval1, mergedIntervals);
		double intervalue = mergeIntervals2.get(0).getValue2();
		assertEquals(26, intervalue, 0.01);
	}
	
	@Test
	public void testCheckMergeAdd() {
		List<Interval> mergeIntervals2 = calculate.checkMerge(interval5, mergedIntervals);
		double intervalue = mergeIntervals2.size();
		assertEquals(2, intervalue, 0.01);
	}
	
}
