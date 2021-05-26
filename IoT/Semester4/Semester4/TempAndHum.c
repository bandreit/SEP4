
#include <FreeRTOS.h>
#include <stdio.h>
#include <stdint.h>
#include <task.h>
#include <semphr.h>
#include "TempAndHum.h"
#include "Setup.h"

static SemaphoreHandle_t tempHumSemaphore;


void tempAndHum_run()
{
	uint16_t Temp = 0;
	uint16_t Humidity = 0;

	if (xSemaphoreTake(tempHumSemaphore, portMAX_DELAY) == pdTRUE)
	{
		xQueueSend(sensorDataQueue, &Temp, portMAX_DELAY);
		xQueueSend(sensorDataQueue, &Humidity, portMAX_DELAY);
		xEventGroupSetBits(dataEventGroup, BIT_HUMIDITY_TEMPERATURE);
	}
	vTaskDelay(10);
}
void TempAndHumTask(void* pvpParameter)
{
	
	while(1)
	{
		uint16_t Temp = 0;
		uint16_t Humidity = 0;
		//printf("TEMP TASK \n");
		if(xSemaphoreTake(tempHumSemaphore,portMAX_DELAY)==pdTRUE)
		{
			measureTempAndHum();
			Temp = hih8120_getTemperature_x10();
			Humidity = hih8120_getHumidityPercent_x10();
			//printf("Temperature: %d\n",Temp);
			//printf("Humidity: %d\n",Humidity);
			xQueueSend(sensorDataQueue,&Temp,portMAX_DELAY);
			xQueueSend(sensorDataQueue,&Humidity,portMAX_DELAY);

			xEventGroupSetBits(dataEventGroup,BIT_HUMIDITY_TEMPERATURE);

		}
		vTaskDelay(10);
		
	}
}

void createTempAndHumTask()
{
	initializeTempAndHumDriver();
		xTaskCreate(
		TempAndHumTask
		,  "TempAndHumTask"  // A name just for humans
		,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
		,  NULL
		,  tskIDLE_PRIORITY + 1  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
		,  NULL );
}




