
#include "LoRaWANDownlinkHandler.h"

lora_driver_payload_t lora_downlink_payload;


void lora_downLink_task()
{
	for(;;)
	{
		xMessageBufferReceive(downlinkMessageBuffer, &lora_downlink_payload, sizeof(lora_driver_payload_t), portMAX_DELAY);
		printf("DOWN LINK<<<<<: from port: %d with %d bytes received!",lora_downlink_payload.portNo, lora_downlink_payload.len);
		if (1 == lora_downlink_payload.len)
		{
			 uint8_t level =  (lora_downlink_payload.bytes[0]);
			 setVentilationLevel(level);
			 xSemaphoreGive(ventilationSemaphore);
		}

		vTaskDelay(pdMS_TO_TICKS(100));
	}

}


 void lora_downlink_handler_create(UBaseType_t lora_handler_task_priority)
 {

 xTaskCreate(
 lora_downLink_task,
 "lora_downlink"  
 , configMINIMAL_STACK_SIZE 
 , NULL
 ,	tskIDLE_PRIORITY + lora_handler_task_priority  
 , NULL );
 }
