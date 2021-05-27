#include <stdio.h>

#include <FreeRTOS.h>
#include <message_buffer.h>
#include <task.h>
#include <stdio.h>
#include <stdint.h>
#include "LoRaWANDownlinkHandler.h"
#include "Setup.h"
#include "configuration.c"

lora_driver_payload_t lora_downlink_payload;


void LoRaWanDownlinkTask_run()
{
	xMessageBufferReceive(downlinkMessageBuffer, &lora_downlink_payload, sizeof(lora_driver_payload_t), portMAX_DELAY);
	if (1 == lora_downlink_payload.len) // Check that we have got the expected 4 bytes
	{
		uint8_t level = (lora_downlink_payload.bytes[0]);
		setVentilationLevel(level);
		xSemaphoreGive(ventilationSemaphore);
	}

	vTaskDelay(100);
}


void LoRaWanDownlinkTask()
{
	while (1)
	{
		LoRaWanDownlinkTask_run();
	}
}