
#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>

#include "configuration.h"

SemaphoreHandle_t configSemaphore;
int* ventilationLevel;


void initializeConfiguration()
{
	ventilationLevel = NULL;
	configSemaphore = xSemaphoreCreateBinary();
}

void setVentilationLevel(int level)
{
	if(xSemaphoreTake(configSemaphore,portMAX_DELAY)==pdTRUE)
	{
		ventilationLevel = &level;
		xSemaphoreGive(configSemaphore);
	}
}

int* getVentilationLevel()
{
		if(xSemaphoreTake(configSemaphore,portMAX_DELAY)==pdTRUE)
		{	
			xSemaphoreGive(configSemaphore);
			return ventilationLevel;
		}
}