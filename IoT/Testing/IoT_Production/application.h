/*
 * application.h
 *
 *  Author: IoT
 */

#pragma once

#include <FreeRTOS.h>
#include <message_buffer.h>
#include <event_groups.h>
#include <semphr.h>


void ApplicationTask_run();
void ApplicationTask(void* pvParameters);
void setPackageHandler();
