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
#include <hih8120.h>
#include <sen14262.h>
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
//void lora_handler_initialise(UBaseType_t lora_handler_task_priority);

void initializeDrivers()
{
	initializeCO2Driver();
	initializeTempAndHumDriver();
}
/*-----------------------------------------------------------*/
void create_tasks_and_semaphores(void)
{
		initializeEventGroup();
		initializeQueue();
		initializeTempAndHumiditySemaphore();
		createTempAndHumTask();
		createCO2Task();
					xTaskCreate(
					ApplicationTask()
					,  "Application TAsk"  // A name just for humans
					,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
					,  NULL
					,  3  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
					,  NULL );

		
		
}

void ApplicationTask()
{
	for (;;)
	{
		xSemaphoreGive(tempHumSemaphore);
		//vTaskDelay(10);
		//printf("Application Task\n");
		//vTaskDelay(30);
		EventBits_t dataEventBits = xEventGroupWaitBits
		(dataEventGroup,BIT_HUMIDITY_TEMPERATURE|BIT_CO2,pdTRUE,pdTRUE,portMAX_DELAY);
		printf("Data Event Bit\n");
		if(dataEventBits == 3)
		{
			printf("All Data Colected;");
			vTaskDelay(3000);
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
	initializeDrivers();
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
	//printf("Program Stttttarted!!\n");
	vTaskStartScheduler(); // Initialise and run the freeRTOS scheduler. Execution should never return from here.

}

