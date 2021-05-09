#pragma once

#include "ATMEGA_FreeRTOS.h"
#include <semphr.h>

/*
 * TempAndHum.h
 *
 * Created: 5/9/2021 11:17:11 AM
 *  Author: ioncr
 */ 

//QueueHandle_t queue;
SemaphoreHandle_t TempAndHumSemaphore;

void initializeTempAndHumDriver();
void measureTempAndHum();
void TempAndHumTask(void* pvpParameter);
void creteTempAndHumTask();
