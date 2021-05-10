#include "CO2.h"
#include <ATMEGA_FreeRTOS.h>
#include <mh_z19.h>
#include <stdio.h>
#include "Setup.h"
#include <event_groups.h>
void myCo2CallBack(uint16_t ppm);

mh_z19_returnCode_t rc;

void initializeCO2Driver()
{
	// The parameter is the USART port the MH-Z19 sensor is connected to - in this case USART3
	mh_z19_initialise(ser_USART3);
	mh_z19_injectCallBack(myCo2CallBack);
	
}
void measureCO2()
{
	rc = mh_z19_takeMeassuring();
	if (rc != MHZ19_OK)
	{
		printf("CO2 Measure went wrong\n");
	}
}
void CO2Task()
{
	while(1)
	{


EventBits_t dataEventBits = xEventGroupWaitBits
(dataEventGroup,BIT_HUMIDITY_TEMPERATURE,pdFALSE,pdTRUE,portMAX_DELAY);
		if((dataEventBits & BIT_HUMIDITY_TEMPERATURE)==BIT_HUMIDITY_TEMPERATURE)
		{
			measureCO2();
		//printf("Measured\n");
		vTaskDelay(pdMS_TO_TICKS(200));
		xEventGroupSetBits(dataEventGroup,BIT_CO2);
		}
		else
		{
			printf("Not Measured\n");
			vTaskDelay(300);
		}

		
		
		
	}
}
void myCo2CallBack(uint16_t ppm)
{
	printf("CO2 Value: %d",ppm);
		xQueueSend(sensorDataQueue,&ppm,portMAX_DELAY);
}
void createCO2Task(void *pvpParameter)
{
			initializeCO2Driver();
			xTaskCreate(
			CO2Task
			,  "CO2Task"  // A name just for humans
			,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
			,  NULL
			,  tskIDLE_PRIORITY + 1  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
			,  NULL );
			
}
