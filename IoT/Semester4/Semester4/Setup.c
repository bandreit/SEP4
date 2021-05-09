
#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>
#include <queue.h>
#include <event_groups.h>
#include <message_buffer.h>
#include "Setup.h"


  SemaphoreHandle_t tempHumSemaphore;
  QueueHandle_t sensorDataQueue;
  EventGroupHandle_t dataEventGroup;
  MessageBufferHandle_t uplinkMessageBuffer;
  MessageBufferHandle_t downlinkMessageBuffer;
  
void initializeTempAndHumiditySemaphore()
{
	tempHumSemaphore = xSemaphoreCreateBinary();
}

void initializeQueue()
{
	sensorDataQueue = xQueueCreate(3,sizeof(uint16_t));
}

void initializeEventGroup()
{
	dataEventGroup = xEventGroupCreate();
}

void initializeUplinkMessageBuffer()
{
	uplinkMessageBuffer = xMessageBufferCreate(100);
}

void initializeDownlinkMessageBuffer()
{
	downlinkMessageBuffer = xMessageBufferCreate(100);
}



