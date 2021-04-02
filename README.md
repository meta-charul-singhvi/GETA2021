# GETA2021 UI Assignment 7
Duration (6 Hours)

*Use ECMAscript for all variables, functions & other features* 

Assume a Metacube Parking System. An employee has to take a pass/ticket to enter into the parking system. Now - 
Enter the employee’s details and register them and then it will collapse automatically by showing up the employee registration id.
Full Name
Gender
Email Id
Password
Confirm Password
Contact Number

	Note - Only one field will be visible at a time. Like initially it will ask for a name
Enter your name (Once user enter his name hit enter like John Doe)
Change the text field into a radio button and label into “Hi John! Can i know your gender”
Then same with email, password, etc
For password if password is 
Weak then change the border as red
Normal then change to orange
Strong then change to green

Then show add vehicle form, enter the vehicle details with employee Id. Then it will also be collapsed automatically.
Name
Type
Vehicle Number
Employee Id
Identification (Textarea)

	Note - Only one field will be visible at a time. Like initially it will ask for a name
Enter vehicle name (Once user enters a vehicle’s name hit enter)
Change the text field into a select field and label into “Which vehicle do you have ?”
Then same with email, password, etc


Then show up daily, monthly & yearly passes price (according to the vehicle type you selected) and let the employee select the plan. Then show a button Get Pass, this will show up the pass price finally. 
Let's say vehicle pricing in INR (daily, monthly, yearly) -
Cycle (5, 100, 500)
MotorCycle (10, 200, 1000)
Four Wheelers (20, 500, 3500)
Employees should also have an option to change the currency in 2 more USD & YEN.
We have to save the pricing in USD only.

Also add the JAVAScript validation on these forms. 
Full Name -> Length min 2 and should not be numeric
Email -> should contain @ ., length etc.
Password -> should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8
Contact Number-> Numbers only, length > 8
