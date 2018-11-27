package com.fdmgroup.daimlerInterval.functionality;

import java.util.Comparator;

import com.fdmgroup.daimlerInterval.model.Interval;

public class CompareIntervals implements Comparator<Interval> {

	@Override // Comparator class to allow the sorting of the intervals list
	public int compare(Interval interval1, Interval interval2) {
		if (interval1.getValue1() == interval2.getValue1()) {
			return 0;
		}else if (interval1.getValue1() > interval2.getValue1()) {
			return 1;
		}else {
			return -1;
		}
	}

}
