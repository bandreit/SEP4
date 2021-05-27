#include <FreeRTOS.h>
#include <semphr.h>
#include <stdint.h>

#include "configuration.h"

SemaphoreHandle_t configSemaphore;
uint8_t ventilationLevel;


void initializeConfiguration()
{
	ventilationLevel = -100;
	configSemaphore = xSemaphoreCreateBinary();
	xSemaphoreGive(configSemaphore);
}

void setVentilationLevel(uint8_t level)
{
	if (xSemaphoreTake(configSemaphore, portMAX_DELAY) == pdTRUE)
	{
		ventilationLevel = level;
		xSemaphoreGive(configSemaphore);
	}
}

uint8_t getVentilationLevel()
{
	if (xSemaphoreTake(configSemaphore, portMAX_DELAY) == pdTRUE)
	{
		xSemaphoreGive(configSemaphore);
		return ventilationLevel;
	}
}