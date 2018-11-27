package com.fdmgroup.daimlerInterval.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.daimlerInterval.functionality.Calculation;
import com.fdmgroup.daimlerInterval.model.Interval;

/** This is the main controller class, responsible for all requests and responses of the web part of the application*/

@Controller
@SessionAttributes("intervals")
public class HomeController {
	
	//necessary to init here, so all methods can access the same instance
	private Calculation calculate = new Calculation();
	List<Interval> intervals = new ArrayList<>();
	
	//first response, to someone opening the website
	@RequestMapping({"/home", "Home", "/", ""})
	public ModelAndView home(Model model){
		model.addAttribute("intervals", intervals);
		return new ModelAndView("main");
	}

	//this will allow users to manually add intervals to the list as many as wished for
	@RequestMapping("/nextInterval")
	public ModelAndView next(Model model, @ModelAttribute("intervals")ArrayList<Interval> intervals, Interval interval){
		//takes values from inputs and adds them to the interval
		intervals.add(interval);
		//passes intervals to jsp to use in html code
		model.addAttribute("intervals", intervals);
		return new ModelAndView("main");
	}
	// allows users to enter path to a file with intervals, each line containing one interval of format value1,value2
	@RequestMapping("/readInterval")
	public ModelAndView read(Model model, @ModelAttribute("intervals")List<Interval> intervals, String filePath){
		//reading file (see below)
		intervals = readFile(filePath);
		//passes intervals to jsp again
		model.addAttribute("intervals", intervals);
		return new ModelAndView("main");
	}
	
	//calls main calculation routine, gets back merged Interval list
	@RequestMapping("/merge")
	public ModelAndView mergeIntervals(Model model, @ModelAttribute("intervals")List<Interval> intervals){
		//calls main calculation method, with several sub-steps being called within, creates mergedIntervals List
		List<Interval> mergedIntervals = calculate.sortCombine(intervals);
		List<Interval> intervals2 = intervals;
		//cleans up intervals for next use
		intervals = null;
		//passes both lists to jsp to display
		model.addAttribute("intervals", intervals2);
		model.addAttribute("mergedIntervals", mergedIntervals);
		return new ModelAndView("main");
	}
	
	
	// method to read file of intervals
	public static List<Interval> readFile(String filePath) {
		List<Interval> intervals = new ArrayList<>();
	    Path pathToFile = Paths.get(filePath);
	    //create bufferedReader for more thread security, however, it is slightly slower
        try (BufferedReader intervalReader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            // read the first line from the interval file: it should go like this: value1,value2, this string is stored in an string object
            String line = intervalReader.readLine();
            // loop until all lines are read
            while (line != null) {

                // using string.split to load a string array with the values from
                // each line of the interval file, using a comma as the delimiter
                String[] attributes = line.split(",");
                //creating new interval by double parsing the string array members of each line
                Interval addedInterval = new Interval(Double.parseDouble(attributes[0]), Double.parseDouble(attributes[1]));
                // adding Interval into ArrayList
                intervals.add(addedInterval);

                // read next line before looping
                // if end of file reached, line would be null
                line = intervalReader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return intervals;
    }
	
}