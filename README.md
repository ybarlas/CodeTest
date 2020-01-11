# CodeTest

### BACKGROUND

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:


[94133,94133] 
[94200,94299] 
[94600,94699]


Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.


### PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.


#### NOTES

- The ranges above are just examples, your implementation should work for any set of arbitrary ranges

- Ranges may be provided in arbitrary order

- Ranges may or may not overlap

- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

 

#### EXAMPLES:

If the input = [94133,94133] [94200,94299] [94600,94699]

Then the output should be = [94133,94133] [94200,94299] [94600,94699]

 

If the input = [94133,94133] [94200,94299] [94226,94399]

Then the output should be = [94133,94133] [94200,94399]


its Spring boot project for execution of code check out branch and compile , test using maven. 
see pom.xml for details.

in /src/main/resources folder test01.csv and test02.csv containing input arrays of integer.
and desire outputs of input files are in same folder test01ans.csv and test02ans.csv file

two unit test execute and read these files for input and desired output.

for example:

if we reduce following zip code ranges.

[10030,10049]
[10030,10035]
[10035,10040]
[10050,10070]
[10060,10065]
[10080,10080]
[10081,10082]
[10095,10099]

output will be following 

[10030,10040]
[10030,10040]
[10050,10070]
[10080,10082]
[10095,10099]
