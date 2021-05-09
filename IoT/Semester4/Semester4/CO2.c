/*
 * CO2.c
 *
 * Created: 5/9/2021 12:05:09 PM
 *  Author: ioncr
 */ 

#include "CO2.h"
#include <ATMEGA_FreeRTOS.h>
#include <mh_z19.h>
#include <stdio.h>

void myCo2CallBack(uint16_t ppm);

void initializeCO2Driver()
{
	// The parameter is the USART port the MH-Z19 sensor is connected to - in this case USART3
	mh_z19_initialise(ser_USART3);
	
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
		
		measureCO2();
		vTaskDelay(100);
	}
}
void myCo2CallBack(uint16_t ppm)
{
	printf("CO2 Value : %d",ppm);
}
void createCO2Task()
{
			printf("CO2 Task Initialized\n");
			initializeCO2Driver();
			mh_z19_injectCallBack(myCo2CallBack);
			xTaskCreate(
			CO2Task
			,  "CO2Task"  // A name just for humans
			,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
			,  NULL
			,  2  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
			,  NULL );
			printf("CO2 Task Created\n");
			
}
