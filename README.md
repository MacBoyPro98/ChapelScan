# ChapelScan (Java)
Chapel Scanning program for NNU. This aims to replace the current Chapel Scanning software and provide an interface in which any device with a USB drive (to use the RFID scanner) can load and run the program.

## Deploying
To deploy this repo:
1. Install [Git](https://gitforwindows.org/)
2. Clone this repo ```git clone https://github.com/MacBoyPro98/ChapelScan.git --branch java```

## Building


## Scan-in
The Scan-in page allows for users to scan into Chapel and saves their card_id to ```/extra/in-<today's date>.csv```. 
Errors are reported to ```/extra/errors-<today's date>.csv```. 
This file can be used later to upload scan-in data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/java/extra/scanin.png "Scan-in Page")

## Scan-out
The Scan-out page allows for users to scan out of Chapel and saves their card_id to ```/extra/out-<today's date>.csv```
This file can be used later to upload scan-out data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/java/extra/scanout.png "Scan-out Page")
