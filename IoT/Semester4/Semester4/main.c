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

 // Needed for LoRaWAN
 #include <lora_driver.h>
 #include <status_leds.h>

#include <stdio_driver.h>
#include <serial.h>
#include <event_groups.h>
#include "Setup.h"
#include "application.h"
#include "TempAndHum.h"
#include "CO2.h"
#include "LoRaWANUplinkHandler.h"
#include "LoRaWANDownlinkHandler.h"
#include "ventilation.h"
#include "configuration.h"


void initializeUsedData()
{
	initializeEventGroup();
	initializeQueue();
	initializeTempAndHumiditySemaphore();
	initializeVentilationSemaphore();
	initializeConfiguration();
	initializeDownlinkMessageBuffer();
	
	lora_driver_initialise(ser_USART1, downlinkMessageBuffer);
}
/*-----------------------------------------------------------*/
void create_tasks(void)
{		
		createTempAndHumTask(1);
		createCO2Task(1);
		createApplicationTask(2);	
		
		lora_uplink_handler_create(4);
		lora_downlink_handler_create(3);
		createVentilationTask(3);
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
	printf("Program Started!!\n");
	vTaskStartScheduler(); // Initialise and run the freeRTOS scheduler. Execution should never return from here.
	while(1)
	{
		
	}
}

