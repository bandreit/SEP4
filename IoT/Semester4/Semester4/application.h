/*
 * application.h
 *
 *  Author: IoT
 */ 

#ifndef APPLICATION_H
#define APPLICATION_H

#include <ATMEGA_FreeRTOS.h>
#include <message_buffer.h>
#include <event_groups.h>
#include <semphr.h>

void application_create(UBaseType_t application_task_priority,
						MessageBufferHandle_t messageBuffer,
						EventGroupHandle_t eventGroupMeasure,
						EventGroupHandle_t eventGroupData,
						SemaphoreHandle_t semaphore);
						
#endif
