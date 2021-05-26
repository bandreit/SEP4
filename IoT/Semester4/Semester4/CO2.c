
#include "CO2.h"

void myCo2CallBack(uint16_t ppm);

mh_z19_returnCode_t rc;

void initializeCO2Driver()
{
	mh_z19_initialise(ser_USART3);
	
	mh_z19_injectCallBack(myCo2CallBack);
}
void measureCO2()
{
	rc = mh_z19_takeMeassuring();
	if (rc != MHZ19_OK)
	{
		printf("CO2 Measure went wrong\n");
	}
}
void CO2Task()
{
	while(1)
	{

		EventBits_t dataEventBits = xEventGroupWaitBits
		(dataEventGroup,BIT_HUMIDITY_TEMPERATURE,pdFALSE,pdTRUE,portMAX_DELAY);

		if((dataEventBits & BIT_HUMIDITY_TEMPERATURE)==BIT_HUMIDITY_TEMPERATURE)
			measureCO2();
			
		vTaskDelay(pdMS_TO_TICKS(50));
			
	}
}
void myCo2CallBack(uint16_t ppm)
{
		//printf("CO2 Value: %d\n",ppm);
		xQueueSend(sensorDataQueue,&ppm,portMAX_DELAY);
		xEventGroupSetBits(dataEventGroup,BIT_CO2);
}
void createCO2Task( UBaseType_t Taskpriority)
{
			initializeCO2Driver();
			xTaskCreate(
			CO2Task
			,  "CO2Task" 
			,  configMINIMAL_STACK_SIZE 
			,  NULL
			,  tskIDLE_PRIORITY + Taskpriority 
			,  NULL );
			
}
