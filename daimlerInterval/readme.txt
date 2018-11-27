This is the readme file for daimlerInterval app, that was requested by Daimler

As programming language, Java was chosen, not in the least because it has automatic memory handling, and thus needs less code for that, but also because it is the language this programmer has used the most in recent times
Additionally, a small unstyled html page was built to allow easy data entry

to run this program please open it (eg in Eclipse) and run DaimlerIntervalApplication.java as an Application, not using a server
The server used is Tomcat 9, if another server is needed, some adaption might be necessary. This all is only necessary, if you wish to use the web app. 
All functionality itself is in a class called com.fdmgroup.daimlerInterval.functionality.Caluclation.java.
This class could be called by any other app, just giving a List of intervals and returning a merged list.
 
If the webapp is being used, after starting the app, please open a browser window and enter http://localhost:8088/daimlerInterval. You will see a 
few input fields. the upper two are to manually enter values for intervals and add them to a list. The lower input field allows to import a csv file 
where the values are entered in pairs one per line in this fashion:
 value1,value2
 value1,value2
 value1,value2
 
 afterwards, please press the merge Intervals button, and a new list is generated with all merged intervals
 
 Development time of this little app was about two days
 Memory usage in heap, according to eclipse currently is slightly less than 205 mb
 