

#include "application.h"

#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <event_groups.h>
#include <message_buffer.h>
#include <semphr.h>

#include <lora_driver.h>

#include "sensorDataPackageHandler.h"
#include "CO2.h"
#include "TempAndHum.h"
#include "Setup.h"


MessageBufferHandle_t uplinkMessageBuffer;
EventGroupHandle_t measureEvenGroup;
EventGroupHandle_t dataEventGroup;
SemaphoreHandle_t tempHumSemaphore;

void application_task(void *pvParameters)
{
	size_t bytesSent;
	EventBits_t dataReadyEventBits;
	lora_driver_payload_t uplink_payload;
	
	for(;;)
	{
		xEventGroupSetBits(measureEvenGroup, BIT_CO2 | BIT_HUMIDITY_TEMPERATURE);
		dataReadyEventBits=xEventGroupWaitBits(dataEventGroup, BIT_CO2 | BIT_HUMIDITY_TEMPERATURE, pdTRUE, pdTRUE, portMAX_DELAY);
		
		if((dataReadyEventBits & (BIT_CO2 | BIT_HUMIDITY_TEMPERATURE))==(BIT_CO2 | BIT_HUMIDITY_TEMPERATURE))
		{
			printf("Data Ready");
		}
		
		uplink_payload=sensorDataPackageHandler_getLoRaPayload((uint8_t) 1);
		vTaskDelay(pdMS_TO_TICKS(50));
		bytesSent=xMessageBufferSend(uplinkMessageBuffer, (void*) &uplink_payload, sizeof(uplink_payload), portMAX_DELAY); 
	}
	
}

void application_create(UBaseType_t application_task_priority, MessageBufferHandle_t messageBuffer, EventGroupHandle_t eventGroupMeasure, EventGroupHandle_t eventGroupData, SemaphoreHandle_t semaphore)
{
	uplinkMessageBuffer=messageBuffer;
	measureEvenGroup=eventGroupMeasure;
	dataEventGroup=eventGroupData;
	tempHumSemaphore=semaphore;
	
	xTaskCreate(
	application_task,
	"Application Task",
	configMINIMAL_STACK_SIZE,
	NULL,
	application_task_priority,
	NULL
	);
}

