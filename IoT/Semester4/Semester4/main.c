/*
* main.c
* Author : IHA
*
* Example main file including LoRaWAN setup
* Just for inspiration :)
*/

#include <stdio.h>
#include <avr/io.h>

#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <semphr.h>

#include <stdio_driver.h>
#include <serial.h>
#include <event_groups.h>
#include "Setup.h"
#include "application.h"
#include "TempAndHum.h"
#include "CO2.h"

 // Needed for LoRaWAN
#include <lora_driver.h>
#include <status_leds.h>


void initializeUsedData()
{
	initializeEventGroup();
	initializeQueue();
	initializeTempAndHumiditySemaphore();
}
/*-----------------------------------------------------------*/
void create_tasks(void)
{		
		createTempAndHumTask();
		createCO2Task();
		createApplicationTask();	
}





/*-----------------------------------------------------------*/
void initialiseSystem()
{
	stdio_initialise(ser_USART0);
	initializeUsedData();
	create_tasks();
}

/*-----------------------------------------------------------*/
int main(void)
{
	initialiseSystem(); // Must be done as the very first thing!!
	printf("Program Stttttarted!!\n");
	vTaskStartScheduler(); // Initialise and run the freeRTOS scheduler. Execution should never return from here.
	while(1)
	{
		
	}
}

