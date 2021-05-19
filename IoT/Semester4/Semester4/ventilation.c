/*
 * ventilation.c
 *
 * Created: 5/19/2021 12:53:01 PM
 *  Author: ioncr
 */ 
#include <ATMEGA_FreeRTOS.h>
#include <rc_servo.h>
#include "configuration.h"


void ventilationTask()
{
	for(;;)
	{
		rc_servo_setPosition(0,getVentilationLevel());
	}
}

void createVentilationTask()
{
	rc_servo_initialise();
	xTaskCreate(
	ventilationTask,
	"Ventilation Task",
	configMINIMAL_STACK_SIZE,
	NULL,
	tskIDLE_PRIORITY+2,
	NULL
	);
	
}
