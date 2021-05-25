#include "CO2.h"
#include <FreeRTOS.h>
#include <task.h>
#include <stdio.h>
#include "Setup.h"
#include <event_groups.h>
void myCo2CallBack(uint16_t ppm);




void CO2Task_run()
{
	EventBits_t dataEventBits = xEventGroupWaitBits(dataEventGroup, BIT_HUMIDITY_TEMPERATURE, pdFALSE, pdTRUE, portMAX_DELAY);
	if ((dataEventBits & BIT_HUMIDITY_TEMPERATURE) == BIT_HUMIDITY_TEMPERATURE)
	{
		myCo2CallBack(20);
	}
	vTaskDelay(pdMS_TO_TICKS(30));
}
void CO2Task()
{
	while (1)
	{
		CO2Task_run();
	}
}
void myCo2CallBack(uint16_t ppm)
{
	xQueueSend(sensorDataQueue, &ppm, portMAX_DELAY);
	xEventGroupSetBits(dataEventGroup, BIT_CO2);
}
