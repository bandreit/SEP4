/*
 * ventilation.c
 *
 * Created: 5/19/2021 12:53:01 PM
 *  Author: ioncr
 */ 
#include <ATMEGA_FreeRTOS.h>
#include <task.h>
#include <rc_servo.h>
#include "configuration.h"
#include <stdio.h>
#include "ventilation.h"


void ventilationTask(void* pvpParameter)
{
	for(;;)
	{
	vTaskDelay(pdMS_TO_TICKS(1000));
		rc_servo_setPosition(0,getVentilationLevel());
	}
}

void createVentilationTask()
{
	rc_servo_initialise();
	xTaskCreate
	(
	ventilationTask,
	"Ventilation"
	, configMINIMAL_STACK_SIZE,
	NULL,
	tskIDLE_PRIORITY + 3,
	NULL
	);
}
