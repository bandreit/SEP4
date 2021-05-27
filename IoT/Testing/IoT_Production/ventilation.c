#include <FreeRTOS.h>
#include <stdio.h>
#include <stdint.h>
#include <task.h>
#include <semphr.h>
#include "ventilation.h"
#include "configuration.h"
#include "Setup.h"

void VentilationTask_run()
{
	if (xSemaphoreTake(ventilationSemaphore, portMAX_DELAY) == pdTRUE)
	{
		getVentilationLevel();
	}
	vTaskDelay(pdMS_TO_TICKS(10));
}

void VentilationTask()
{
	while (1)
	{
		VentilationTask_run();
	}
}