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

 // Needed for LoRaWAN
#include <lora_driver.h>
#include <status_leds.h>

// define two Tasks
void task1( void *pvParameters );
void task2( void *pvParameters );
void initializeDriver();

// define semaphore handle
//SemaphoreHandle_t xTestSemaphore;

// Prototype for LoRaWAN handler
void ApplicationTask();
//void lora_handler_initialise(UBaseType_t lora_handler_task_priority);

void initializeUsedData()
{
	printf("DATA");
	initializeEventGroup();
	initializeQueue();
	initializeTempAndHumiditySemaphore();
}
/*-----------------------------------------------------------*/
void create_tasks_and_semaphores(void)
{		
	createApplicationTask();
		createTempAndHumTask();
		createCO2Task();	
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
void ApplicationTask()
{
	const TickType_t xTicksToWait = 500 / portTICK_PERIOD_MS;
	for (;;)
	{
		
		EventBits_t eventBits = xEventGroupWaitBits(dataEventGroup,BIT_HUMIDITY_TEMPERATURE|BIT_CO2,pdTRUE,pdTRUE,xTicksToWait);
		if((eventBits &(BIT_CO2 | BIT_HUMIDITY_TEMPERATURE))==(BIT_CO2|BIT_HUMIDITY_TEMPERATURE))
		{
			printf("All Data Colected;");
			xEventGroupClearBits(dataEventGroup,BIT_HUMIDITY_TEMPERATURE|BIT_CO2);
			vTaskDelay(pdMS_TO_TICKS(300000UL));
			
		}
		else{
			
			xSemaphoreGive(tempHumSemaphore);
			
		}
		
	}
}



/*-----------------------------------------------------------*/
void initialiseSystem()
{
	// Set output ports for leds used in the example
	//DDRA |= _BV(DDA0) | _BV(DDA7);

	// Make it possible to use stdio on COM port 0 (USB) on Arduino board - Setting 57600,8,N,1
	stdio_initialise(ser_USART0);
	// Let's create some tasks
//	initializeDriver()
printf("Data Initialized");
	initializeUsedData();
	create_tasks_and_semaphores();
	// vvvvvvvvvvvvvvvvv BELOW IS LoRaWAN initialisation vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	// Status Leds driver
	//status_leds_initialise(5); // Priority 5 for internal task
	// Initialise the LoRaWAN driver without down-link buffer
//	lora_driver_initialise(1, NULL);
	// Create LoRaWAN task and start it up with priority 3
	//lora_handler_initialise(3);
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

