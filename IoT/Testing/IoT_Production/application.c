#include <stdio.h>

#include <FreeRTOS.h>
#include <task.h>
#include <event_groups.h>
#include <queue.h>


#include "Setup.h"
#include "application.h"
#include "sensorDataPackageHandler.h"



void setPackageHandler()
{
	uint16_t data[3];
	for (int i = 0; i < 3; i++)
	{
		xQueueReceive(sensorDataQueue, &data[i], portMAX_DELAY);

	}

	//sensorDataPackageHandler_setTemp_value(data[0]);
	//sensorDataPackageHandler_setHumidity_value(data[1]);
	//sensorDataPackageHandler_setCO2_value(data[2]);
	xQueueReset(sensorDataQueue);

}

void ApplicationTask(void* pvParameters)
{
	for (;;)
	{

		ApplicationTask_run();

	}
}
void ApplicationTask_run()
{
	EventBits_t eventBits = xEventGroupWaitBits(dataEventGroup, BIT_HUMIDITY_TEMPERATURE | BIT_CO2, pdTRUE, pdTRUE, portMAX_DELAY);

	if ((eventBits & (BIT_CO2 | BIT_HUMIDITY_TEMPERATURE)) == (BIT_CO2 | BIT_HUMIDITY_TEMPERATURE))
	{
		setPackageHandler();
		vTaskDelay(pdMS_TO_TICKS(120000));
		xSemaphoreGive(tempHumSemaphore);

	}
	vTaskDelay(pdMS_TO_TICKS(50));
}

