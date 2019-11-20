# ChapelScan (Java)
Chapel Scanning program for NNU. This aims to replace the current Chapel Scanning software and provide an interface in which any device with a USB drive (to use the RFID scanner) can load and run the program.

## Building/Deploying
Instructions for building are included in [this](https://docs.google.com/document/d/1e1MBpoyHT129DzA-IYdNxt4THsM4e3vE2gxEa_QA3Z8/edit?usp=sharing) document.

## Scan-in
The Scan-in page allows for users to scan into Chapel and saves their card_id to ```/extra/in-<today's date>.csv```. 
Errors are reported to ```/extra/errors-<today's date>.csv```. 
This file can be used later to upload scan-in data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/java/extra/scanin.png "Scan-in Page")

## Scan-out
The Scan-out page allows for users to scan out of Chapel and saves their card_id to ```/extra/out-<today's date>.csv```
This file can be used later to upload scan-out data to the database.
![alt text](https://github.com/MacBoyPro98/ChapelScan/blob/java/extra/scanout.png "Scan-out Page")
