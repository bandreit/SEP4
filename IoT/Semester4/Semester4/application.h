
#pragma once

#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <event_groups.h>
#include <queue.h>

#include "sensorDataPackageHandler.h"
#include "Setup.h"

void createApplicationTask(UBaseType_t Taskpriority);
void ApplicationTask(void *pvParameters);
void setPackageHandler();
						

