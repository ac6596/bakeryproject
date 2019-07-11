# bakeryproject
A Bakery project
Algorithm :
a. User requests for the number of items to buy(lets say x=18 MB11)
b. The product code should be present and the number 18 is considered as the parent node
c. For MB11 product we have pack of 8,5,2...The packsize has to be sorted in descending order which is 8,5,2 and the highest node will be picked up as the child node and the number of items will be divided by the selected child node and if the remainder is zero then the price will be calculated as the price of the child node and the quotient.
d. If the remainder is not zero, the remainder has to be treated as the next parent node and the next highest packsize should be selected. The packsize should always be less than the parent node.
e. The steps will continue until we get zero remainder 

User Input : 18 MB11
No. of requested items = 18, Product Code = MB11
Sorted packsize=8,5,2
Parent Node = 18 (18>8)
ChildNode = 8
17/8 gives remainder 2 --- packsize of 8 = 2
Parent Node = 2
Child Node = 2 (2>=2)
2/2 gives remainder 0 --- packsize of 2 = 1

Price calculated = 2*price of pack of 8 + 1* price of pack of 2
                 =2*24.95 + 1*9.95
                 =59.85
Assumptions :
The number of items should always be in a manner that the remainder should always be zero. It will not be treated as a valid input if it comes down to remainder one.    

How to build the code :

a. Open the code in Eclipse and right click on the project and click on Run as
b. Select Maven build and put "clean compile package" in Goals and click on Run
c. Open the target folder and you will be able to see the jar file after build

How to run the jar :

Open terminal in MAC or open cmd in Windows and type below :

java -jar <jar name>

Make sure you are running the jar from the target folder (cd to the target folder where the jar resides)
