

#pragma  once

#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <mh_z19.h>
#include <event_groups.h>

#include "Setup.h"

extern mh_z19_returnCode_t rc;

void initializeCO2Driver();
void measureCO2();
void CO2Task();
void myCo2CallBack(uint16_t ppm);
void createCO2Task( UBaseType_t Taskpriority);
