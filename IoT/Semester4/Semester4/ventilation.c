
#include "ventilation.h"


void ventilationTask(void* pvpParameter)
{
	for(;;)
	{
		if(xSemaphoreTake(ventilationSemaphore,portMAX_DELAY)==pdTRUE)
		{
			printf("setting the ventilation level.....\n");
			rc_servo_setPosition(1, getVentilationLevel());
		}
		vTaskDelay(pdMS_TO_TICKS(100));
	}
}

void createVentilationTask()
{
	rc_servo_initialise();
		
	xTaskCreate(
	ventilationTask
	,  "Ventilation"  // A name just for humans
	,  configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
	,  NULL
	,  tskIDLE_PRIORITY + 3  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	,  NULL );
		
}
