
#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <message_buffer.h>
#include <task.h>
#include <lora_driver.h>
#include <stdio.h>
#include <stdint.h>
#include <rc_servo.h>
#include "LoRaWANDownlinkHandler.h"
#include "Setup.h"
#include "configuration.h"

lora_driver_payload_t lora_downlink_payload;


void lora_downLink_task()
{
	for(;;)
	{
		printf("Before message buffer downlink\n");
		xMessageBufferReceive(downlinkMessageBuffer, &lora_downlink_payload, sizeof(lora_driver_payload_t), portMAX_DELAY);
		printf("DOWN LINK<<<<<: from port: %d with %d bytes received!",lora_downlink_payload.portNo, lora_downlink_payload.len); // Just for Debug
		if (1 == lora_downlink_payload.len) // Check that we have got the expected 4 bytes
		{
			 uint8_t level =  (lora_downlink_payload.bytes[0]);
			 printf("%d dddd\n", lora_downlink_payload.bytes[0]);
			 printf("%d\n",xMessageBufferIsFull(downlinkMessageBuffer) == pdFALSE);
			 setVentilationLevel(level);
			 xSemaphoreGive(ventilationSemaphore);
		}

		vTaskDelay(100);
	}

}


 void lora_downlink_handler_create(UBaseType_t lora_handler_task_priority)
 {

 xTaskCreate(
 lora_downLink_task,
 "lora_downlink"  // A name just for humans
 , configMINIMAL_STACK_SIZE  // This stack size can be checked & adjusted by reading the Stack Highwater
 , NULL
 ,	tskIDLE_PRIORITY + lora_handler_task_priority  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
 , NULL );
	 
	 
 }
