#pragma once

#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>
#include <queue.h>
#include <event_groups.h>
#include <message_buffer.h>

#define BIT_HUMIDITY_TEMPERATURE (1 << 1)
#define BIT_CO2 (1 << 0)


 extern SemaphoreHandle_t tempHumSemaphore;
 extern QueueHandle_t sensorDataQueue;
 extern EventGroupHandle_t dataEventGroup;
 extern MessageBufferHandle_t uplinkMessageBuffer;
 extern MessageBufferHandle_t downlinkMessageBuffer;
 

void initializeTempAndHumiditySemaphore();

void initializeQueue();

void initializeEventGroup();

void initializeUplinkMessageBuffer();

void initializeDownlinkMessageBuffer();
