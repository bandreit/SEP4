/*
 * CO2.h
 *
 * Created: 5/9/2021 12:01:33 PM
 *  Author: ioncr
 */ 

#pragma  once
#include <mh_z19.h>



extern mh_z19_returnCode_t rc;

void initializeCO2Driver();
void measureCO2();
void CO2Task();
void myCo2CallBack(uint16_t ppm);
void createCO2Task(void *pvpParameter);
