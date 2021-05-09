/*
 * application.c
 *
 *  Author: IoT
 */ 

#include "application.h"

#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <event_groups.h>
#include <message_buffer.h>
#include <semphr.h>

#include <lora_driver.h>

#include "sensorDataPackageHandler.h"
#include "co2.h"
#include "temperatureAndHumidity.h"
#include "ventilator.h"
#include "rc_servo.h"

#define BIT_CO2 (1 << 0)
#define BIT_HUMIDITY_TEMPERATURE (1 << 1)

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
			sensorDataPackageHandler_setPackage_lenght((uint8_t) 20);
			sensorDataPackageHandler_setCO2_value(co2_getCo2());
			sensorDataPackageHandler_setHumidity_value(temperatureAndHumidity_getHumidity());
			sensorDataPackageHandler_setTemp_value(temperatureAndHumidity_getTemperature);
			sensorDataPackageHandler_setVentilator_servo();
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

