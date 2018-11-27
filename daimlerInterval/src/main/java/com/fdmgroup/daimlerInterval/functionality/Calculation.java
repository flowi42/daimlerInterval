package com.fdmgroup.daimlerInterval.functionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fdmgroup.daimlerInterval.model.Interval;

public class Calculation {
	//main calculation class with several methods
	public List<Interval> sortCombine (List<Interval> intervals){
		CompareIntervals compareIntervals = new CompareIntervals();
		List<Interval> mergedIntervals = new ArrayList<>();
		/*goes through intervals in the list and switches the higher and the lower values if 
		the higher value is the first. this makes comparisons easier, at the same time, 
		users don`t have to remember to only enter lower value first*/
		for (Interval interval : intervals) {
			intervals.set(intervals.indexOf(interval), sort(interval));
		}
		//now thie list is sorted from lowest to highest, this again will make comparison easier and reduce the number of if statements slightly
		Collections.sort(intervals, compareIntervals);
		// this will add the first interval of the intervals list to the merged intervals list, so the comparison does work in the next step
		mergedIntervals.add(intervals.get(0));
		
		/* now the program will loop through the intervals and call checkMerge to see if the
		interval shall be added to the List or merged with a existing entry*/
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval1 = intervals.get(i);
			mergedIntervals = checkMerge(interval1, mergedIntervals);	
		}
		return mergedIntervals;	//finally merged intervals list is returned to controller, to have it display on the screen
		}

	public Interval sort(Interval interval) { /* Sort method was created to ensure that the first interval value always is the lower value of the pair*/
		if (interval.getValue2() < interval.getValue1()) {
			return new Interval(interval.getValue2(), interval.getValue1());
		}else {
			return new Interval(interval.getValue1(), interval.getValue2());
		}
	}

	public List<Interval> checkMerge (Interval interval1, List<Interval> mergedIntervals) { 
		/*checks for overlapping and containinng of intervals and if necessary merges 
		  the intervals and adds them to/replaces them in the list
		 */
		Interval mergeInterval = mergedIntervals.get(mergedIntervals.size() - 1);
		if (interval1.getValue1() <= mergeInterval.getValue2() && interval1.getValue2() > mergeInterval.getValue2()) {
			Interval intervally = combine(mergeInterval.getValue1(), interval1.getValue2());
			mergedIntervals.set(mergedIntervals.size() - 1, intervally);
			return mergedIntervals;
		}else if (interval1.getValue2() <= mergeInterval.getValue2()){
			return mergedIntervals;
		}else {
			mergedIntervals.add(interval1);
			return mergedIntervals;
		}
	}
	
	public Interval combine(double value1, double value2) {
		return new Interval(value1, value2);
	}
	
	
}
