# Time Travel Simulator

About
---------
- Simulates time travel by using the time dilation formula

Building
---------
To build the project, use the included `makefile` and run the command below
which will build the `.jar` file.
```bash
make jar
```

To run the `.jar` file, run the following command:
```bash
java -jar time_travel.jar
```

Utilization
------------
You have three options:
- Enter how far in the future you'd like to go and how long you want it to take
- Enter how far in the future you'd like to go and how fast you're going
- Enter how long you want it to take and how fast you're going

Example choices output:
```
How would you like to time travel?
1. Give destination time and time traveled?
2. Give destination time and speed
3. Give time traveled and speed
Select one of the following options: 
```
After your choice has been selected and you enter your information the program will
then run your data through the time dilation formula and calculate your missing value
i.e. speed, year you'll end up in, or how long it will take
