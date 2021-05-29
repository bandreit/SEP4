
#include "application.h"



void setPackageHandler()
{
	uint16_t data[3];
	for(int i=0;i<3;i++)
	{
		xQueueReceive(sensorDataQueue,&data[i],portMAX_DELAY);
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

void createApplicationTask(UBaseType_t Taskpriority)
{
	xTaskCreate(
	ApplicationTask
	,  "AppTask" 
	,  configMINIMAL_STACK_SIZE  
	,  NULL
	,  tskIDLE_PRIORITY + Taskpriority 
	,  NULL );
}

