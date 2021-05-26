
#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>
#include <queue.h>
#include <event_groups.h>
#include <message_buffer.h>
#include "Setup.h"
#include "lora_driver.h"


  SemaphoreHandle_t tempHumSemaphore;
  SemaphoreHandle_t ventilationSemaphore;
  QueueHandle_t sensorDataQueue;
  EventGroupHandle_t dataEventGroup;
  MessageBufferHandle_t uplinkMessageBuffer;
  MessageBufferHandle_t downlinkMessageBuffer;
  
void initializeTempAndHumiditySemaphore()
{
	tempHumSemaphore = xSemaphoreCreateBinary();
	xSemaphoreGive(tempHumSemaphore);
}

void initializeVentilationSemaphore()
{
	ventilationSemaphore = xSemaphoreCreateBinary();
	xSemaphoreGive(ventilationSemaphore);
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
	downlinkMessageBuffer = xMessageBufferCreate(sizeof(lora_driver_payload_t) * 2);
}



