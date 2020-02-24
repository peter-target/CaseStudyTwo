# CaseStudyTwo
Target Case Study #2 (Barren Land Analysis)

1. Instructions to Run

In the /src/CaseStudytwo/ directory there is a Main.java file, which when run will read lines from StdIn. Type lines in the format:

"anInteger anInteger anInteger anInteger"

And then press 'Enter' once after each line. This will create a set of coordinates where the first Integer is the X coordinate of the bottom left corner of a rectangle, the second Integer is the Y coordinate of the bottom left corner, the third coordinate is the X coordinate of the top right corner, and the fourth coordinate is the Y coordinate of the top right corner. If a line does not fit the format above, it will be ignored.

Multiple sets of coordinates can be entered. Once finished adding coordinates, press 'Enter' again or type 'exit' and the analysis will run with the coordinate(s) provided and output the results to StdOut.

2. Notes on Test Cases

In the /test/CaseStudytwo/ I made a number of JUnit test cases. These test cases require two JARs (junit version 4.13 and hamcrest-core version 1.3) which can be found at:

junit:
https://search.maven.org/search?q=g:junit%20AND%20a:junit
hamcrest:
https://search.maven.org/artifact/org.hamcrest/hamcrest-core/1.3/jar

3. Other

Written in Netbeans 8.0.2 using Java 8.
