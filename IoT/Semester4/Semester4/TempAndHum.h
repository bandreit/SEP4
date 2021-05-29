#pragma once

#include <stdio.h>
#include <stdint.h>

#include <ATMEGA_FreeRTOS.h>
#include <hih8120.h>
#include <task.h>
#include <semphr.h>

#include "Setup.h"

void initializeTempAndHumDriver();
void measureTempAndHum();
void TempAndHumTask(void* pvpParameter);
void createTempAndHumTask(UBaseType_t Taskpriority);
