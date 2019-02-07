# ChapelScan
Proof of concept Chapel Scanning program for NNU. This aims to replace the current Chapel Scanning software and provide an interface in which any device with a USB drive (to use the RFID scanner) can load and run the program.

## Deploying
To deploy this repo:
1. Download and install [WAMPServer](http://www.wampserver.com/en/)
2. Install [Git](https://gitforwindows.org/)
3. Use the command line to navigate to the install directory (**Default** C:\wamp64\) ```cd C:\wamp64\```
4. Clone this repo ```git clone https://github.com/MacBoyPro98/ChapelScan.git```
5. Start-up WAMPServer
6. Use the ```/my_sql/sql_db_schema.sql``` file to deploy the schema to the database

## Scan-in
The Scan-in page allows for users to scan into Chapel and saves their card_id to ```C:\wamp64\output\scan-in.csv```
This file can be used late to upload scan-in data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/master/extra/scanin.png "Scan-in Page")

## Scan-out
The Scan-out page allows for users to scan out of Chapel and saves their card_id to ```C:\wamp64\output\scan-out.csv```
This file can be used later to upload scan-out data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/master/extra/scanout.png "Scan-out Page")
