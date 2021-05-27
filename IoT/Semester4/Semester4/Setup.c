

#include "Setup.h"


  SemaphoreHandle_t tempHumSemaphore;
  SemaphoreHandle_t ventilationSemaphore;
  QueueHandle_t sensorDataQueue;
  EventGroupHandle_t dataEventGroup;
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


void initializeDownlinkMessageBuffer()
{
	downlinkMessageBuffer = xMessageBufferCreate(sizeof(lora_driver_payload_t) * 2);
}



