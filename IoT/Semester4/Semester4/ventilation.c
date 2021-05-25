/*
 * ventilation.c
 *
 * Created: 5/19/2021 12:53:01 PM
 *  Author: ioncr
 */ 


//#include <message_buffer.h>
//#include <task.h>
//#include <lora_driver.h>
//#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <stdio.h>
#include <task.h>
#include <rc_servo.h>
#include "configuration.h"
#include "ventilation.h"


void ventilationTask(void* pvpParameter)
{
	printf("in ventilaion----------------\n");
	for(;;)
	{
		vTaskDelay(pdMS_TO_TICKS(100));
		printf("inside loop of ventilaion----------------\n");
		//rc_servo_setPosition(0,getVentilationLevel());
	}
}

void createVentilationTask()
{
	//rc_servo_initialise();
	printf("SHTO ZA HUINNNEAAAAAAAAAAAAA\n");
		
	//xTaskCreate(
	//ventilationTask
	//,  "Ventilation"  // A name just for humans
	//,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
	//,  NULL
	//,  tskIDLE_PRIORITY + 1  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	//,  NULL );
		
}
