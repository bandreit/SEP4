
#include <FreeRTOS.h>
#include <stdio.h>
#include <stdint.h>
#include <task.h>
#include <semphr.h>
#include <event_groups.h>
#include <queue.h>

#include "TempAndHum.h"
#include "Setup.h"



void tempAndHum_run()
{
	uint16_t Temp = 0;
	uint16_t Humidity = 0;

	if (xSemaphoreTake(tempHumSemaphore, portMAX_DELAY) == pdTRUE)
	{
		xQueueSend(sensorDataQueue, &Temp, portMAX_DELAY);
		xQueueSend(sensorDataQueue, &Humidity, portMAX_DELAY);
		xEventGroupSetBits(dataEventGroup, BIT_HUMIDITY_TEMPERATURE);
	}
	vTaskDelay(pdMS_TO_TICKS(10));
}
void TempAndHumTask(void* pvpParameter)
{

	while (1)
	{
		tempAndHum_run();

	}
}





