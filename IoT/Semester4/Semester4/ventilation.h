#pragma once

#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <rc_servo.h>

#include "Setup.h"
#include "configuration.h"


void ventilationTask(void* pvpParameter);
void createVentilationTask();
