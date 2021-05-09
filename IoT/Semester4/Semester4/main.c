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

/*-----------------------------------------------------------*/
void create_tasks_and_semaphores(void)
{
	// Semaphores are useful to stop a Task proceeding, where it should be paused to wait,
	// because it is sharing a resource, such as the Serial port.
	// Semaphores should only be used whilst the scheduler is running, but we can set it up here.
	printf("Task Initialized");
	initializeDriver();	
	xTaskCreate(
	task1
	,  "Task1"  // A name just for humans
	,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
	,  NULL
	,  2  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	,  NULL );
	
	xTaskCreate(
	task2
	,  "Task2"  // A name just for humans
	,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
	,  NULL
	,  2  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	,  NULL );
}

void initializeDriver()
{	
	//hih8120_destroy();
	hih8120_driverReturnCode_t code;
	
	code = hih8120_initialise();
	
	
	if ( HIH8120_OK == code )
	{
		printf("Temp and Humidity Driver initialized OK \n");
	}
	
	else if (code==HIH8120_OUT_OF_HEAP) {
		printf("Out Of Heap\n");
	}

	
	
	//vTaskDelay(1);
	printf("Driver Created \n");
	
	
}


/*-----------------------------------------------------------*/
void task1( void *pvParameters )
{
	//TickType_t xLastWakeTime;
	//const TickType_t xFrequency = 500/portTICK_PERIOD_MS; // 500 ms

	// Initialise the xLastWakeTime variable with the current time.
	//xLastWakeTime = xTaskGetTickCount();
	
				
	//initializeDriver();
	uint16_t temperature;
	//uint16_t humidity=0;
	//uint16_t lastSoundValue;
	for(;;)
	{
		
		//temperature = hih8120_getTemperature();
		//printf("ARRIVE HERE");
		if ( HIH8120_OK != hih8120_wakeup() )
		{
			// Something went wrong
			// Investigate the return code further
		}
		
		vTaskDelay(pdMS_TO_TICKS(50));
		
		if ( HIH8120_OK !=  hih8120_measure() )
		{
			// Something went wrong
			// Investigate the return code further
		}
		vTaskDelay(pdMS_TO_TICKS(1));
		
		//get measurements
		//
		temperature=hih8120_getTemperature_x10();
		//humidity=hih8120_getHumidity();
		//xSemaphoreTake(xPrintfSemaphore,portMAX_DELAY);
		printf("temperature : %d\n", temperature);
		//printf("PROD:Hum: %d\n", humidity);
		//xSemaphoreGive(xPrintfSemaphore);

		//xTaskDelayUntil( &xLastWakeTime, xFrequency );
		//puts("Task1"); // stdio functions are not reentrant - Should normally be protected by MUTEX
		//PORTA ^= _BV(PA0);
	}
}

/*-----------------------------------------------------------*/
void task2( void *pvParameters )
{
	TickType_t xLastWakeTime;
	const TickType_t xFrequency = 1000/portTICK_PERIOD_MS; // 1000 ms

	// Initialise the xLastWakeTime variable with the current time.
	xLastWakeTime = xTaskGetTickCount();

	for(;;)
	{
		xTaskDelayUntil( &xLastWakeTime, xFrequency );
		puts("Task2"); // stdio functions are not reentrant - Should normally be protected by MUTEX
		//PORTA ^= _BV(PA7);
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
//	initializeDriver();
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

	/* Replace with your application code */
	while (1)
	{
	}
}

