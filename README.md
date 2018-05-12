# Test
This project is used to find the largest number of 3 consecutive paths visited by x number of different users.
For simplicity, I have mimicked a web server's log file and just picked out the User name and the paths that he/she visited.

To see it in action, run any of the JUnit test Classes: (I recommend starting with the happy path ones, or just run the entire test class.)

e.g. test.SolutionTest.testParseDataPathsHappyPath1

This test will output the top N, (where N is a numeric parameter) of 3 page hit visits to the site according to the data it has been passed.

In summary, given the data set, create a sequence of paths, create a sequence of triples from those paths, count the occurrences
 of all triples, sort by frequency, return top N.
