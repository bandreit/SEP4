
#include <ATMEGA_FreeRTOS.h>
#include <stdio.h>
#include <hih8120.h>
#include <stdint.h>
#include <task.h>
#include <semphr.h>
#include "TempAndHum.h"
#include "Setup.h"

void initializeTempAndHumDriver()
{
	hih8120_driverReturnCode_t returnCode = hih8120_initialise();

	if ( HIH8120_OK == returnCode )
		{
			printf("Temp and Hum Driver Initialized ok\n");
		}
		
	else {
		printf("TEMP AND HUM OUT OF HEAP \n");
		}
}
void measureTempAndHum()
{
	if ( HIH8120_OK != hih8120_wakeup() )
	{
		printf("TEMP AND HUM WAKE UP WENT WRONG\n");
	}
	
	vTaskDelay(pdMS_TO_TICKS(50));
	
	if ( HIH8120_OK !=  hih8120_measure() )
	{
		printf("TEMP AND HUM MEASURING UP WENT WRONG\n");
	}
	
	vTaskDelay(pdMS_TO_TICKS(20));
	
}
void TempAndHumTask(void* pvpParameter)
{
	
	while(1)
	{
		uint16_t Temp = 0;
		uint16_t Humidity = 0;
		printf("TEMP TASK \n");
		if(xSemaphoreTake(tempHumSemaphore,portMAX_DELAY)==pdTRUE)
		{
			measureTempAndHum();
			Temp = hih8120_getTemperature_x10();
			Humidity = hih8120_getHumidityPercent_x10();
			printf("Temperature: %d\n",Temp);
			printf("Humidity: %d\n",Humidity);
			xQueueSend(sensorDataQueue,&Temp,portMAX_DELAY);
			xQueueSend(sensorDataQueue,&Humidity,portMAX_DELAY);
			//printf("TEMP DATA SENT\n");
			xEventGroupSetBits(dataEventGroup,BIT_HUMIDITY_TEMPERATURE);
			//printf("BIT SET\n");
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




