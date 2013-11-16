ConferencePlanner
=================
ConferencePlanner is a Java program that creates a conference schedule from a series of talks with titles and durations in minutes.

---------------
Getting started
---------------
(1) To get started, import the source code into Eclipse. Then, run the code. 
    (in the menu bar, go to Run -> Run).
(2) When asked to enter the input file name, type in "testinput.txt"
(3) The output file produced is called "testinput_txt_schedule.txt" 

-----------
Assumptions
-----------
* Requires user input for the name of the input file.
* The length of the sessions are 60, 45, 30 or 15 minutes.
* Sessions with keyword "lightning" have durations of 5 minutes.

-----------------
Code Explanations
-----------------
* The main function is in the ConferencePlanner class.
* Explanations on the different aspects of the code should be present in the comments.

---------------------
Sample Console Output
---------------------
A sample console output is below.

-------------- START SAMPLE CONSOLE OUTPUT -----------------------
Enter input file name: 
testinput.txt

Track 1:
09:00AM: Writing Fast Tests Against Enterprise Rails  90min
10:30AM: Communicating Over Distance  60min
11:30AM: Lua for the Masses  30min
12:00PM: Lunch 
01:00PM: Rails Magic  60min
02:00PM: Ruby on Rails: Why We Should Move On  60min
03:00PM: Ruby on Rails Legacy App Maintenance  60min
04:00PM: Ruby Errors from Mismatched Gem Versions  45min
04:45PM: Overdoing it in Python  15min
05:00PM: Networking Event 

Track 2:
09:00AM: Common Ruby Errors  45min
09:45AM: Accounting-Driven Development  45min
10:30AM: Pair Programming vs Noise  45min
11:15AM: Clojure Ate Scala (on my project)  45min
12:00PM: Lunch 
01:00PM: Woah  30min
01:30PM: Sit Down and Write  30min
02:00PM: Programming in the Boondocks of Seattle  30min
02:30PM: Ruby vs. Clojure for Back-End Development  30min
03:00PM: A World Without HackerNews  30min
03:30PM: User Interface CSS in Rails Apps  30min
04:00PM: Rails for Python Developers  lightning
04:05PM: Networking Event 

Output written to /Users/victor/Developer/Codes/Java/ConferencePlanner/testinput_txt_schedule.txt
-------------- END SAMPLE CONSOLE OUTPUT -------------------------