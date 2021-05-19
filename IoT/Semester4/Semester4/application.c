#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <event_groups.h>
#include <queue.h>

#include "sensorDataPackageHandler.h"
#include "Setup.h"
#include "application.h"



void setPackageHandler()
{
	uint16_t data[3];
	for(int i=0;i<3;i++)
	{
		if(xQueueReceive(sensorDataQueue,&data[i],portMAX_DELAY)==pdPASS)
			{
				//printf("Parameter[%i] : %d\n", i , data[i]);
			}
	}
	
	sensorDataPackageHandler_setTemp_value(data[0]);
	sensorDataPackageHandler_setHumidity_value(data[1]);
	sensorDataPackageHandler_setCO2_value(data[2]);
	xQueueReset(sensorDataQueue);
	
}

void ApplicationTask(void *pvParameters)
{
	for (;;)
	{
		
		EventBits_t eventBits = xEventGroupWaitBits(dataEventGroup,BIT_HUMIDITY_TEMPERATURE|BIT_CO2,pdTRUE,pdTRUE,portMAX_DELAY);
		
		if((eventBits &(BIT_CO2 | BIT_HUMIDITY_TEMPERATURE))==(BIT_CO2|BIT_HUMIDITY_TEMPERATURE))
		{
			printf("ALL DATA COLLECTED\n");
			setPackageHandler();
			vTaskDelay(pdMS_TO_TICKS(120000));
			xSemaphoreGive(tempHumSemaphore);
			
		}
		vTaskDelay(pdMS_TO_TICKS(50));
		
	}
}

void createApplicationTask()
{

	
	xTaskCreate(
	ApplicationTask
	,  "AppTask"  // A name just for humans
	,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
	,  NULL
	,  tskIDLE_PRIORITY + 1  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	,  NULL );
	
}

