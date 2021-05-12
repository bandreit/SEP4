///*
 //* LoRaWANDownlinkHandler.c
 //*
 //* Created: 09.05.2021 15:09:54
 //*  Author: andy2
 //*/ 
//
 //#include "LoRaWANDownlinkHandler.h"
//
 //#include <stdio.h>
//
 //#include <ATMEGA_FreeRTOS.h>
 //#include <message_buffer.h>
 //#include <task.h>
//
 //#include <lora_driver.h>
 //#include <iled.h>
//
 //static lora_driver_payload_t _downlink_payload;
//
 //MessageBufferHandle_t downlinkMessageBuffer;
//
 //void lora_downlink_handler_task( void *pvParameters )
 //{
	 //size_t bytesReceivedLoriot;
	 //
	 //for(;;)
	 //{
		 //printf("Downlink waiting\n");
		 //bytesReceivedLoriot = xMessageBufferReceive(downlinkMessageBuffer, (void *)&_downlink_payload, sizeof(_downlink_payload), portMAX_DELAY);
		 //
		 //printf("Downlink message received on port: %d with %d bytes received.\n", _downlink_payload.portNo, _downlink_payload.len);
		 //
		 //if (6 == _downlink_payload.len)
		 //{
			 //uint16_t max_hum_setting = (_downlink_payload.bytes[0] << 8) + _downlink_payload.bytes[1];
			 //int16_t max_temp_setting = (_downlink_payload.bytes[2] << 8) + _downlink_payload.bytes[3];
			 //uint16_t max_co2_setting = (_downlink_payload.bytes[4] << 8) + _downlink_payload.bytes[5];
			 //
			 ////configuration_setConfigurationHumidity(max_hum_setting);
			 ////configuration_setConfigurationTemperature(max_temp_setting);
			 ////configuration_setConfigurationCo2(max_co2_setting);
			 //
			 //printf("T MAX: %d\nH MAX: %d\nC MAX: %d\n", max_temp_setting, max_hum_setting, max_co2_setting);
		 //}
		 //
	 //}
 //}
//
 //void lora_downlink_handler_create(UBaseType_t lora_handler_task_priority, MessageBufferHandle_t messageBufferDownlink)
 //{
	 //downlinkMessageBuffer = messageBufferDownlink;
	 //
	 //xTaskCreate(
	 //lora_downlink_handler_task,
	 //, "LRHandDownlink"  // A name just for humans
	 //, configMINIMAL_STACK_SIZE+200  // This stack size can be checked & adjusted by reading the Stack Highwater
	 //, NULL
	 //, lora_handler_task_priority  // Priority, with 3 (configMAX_PRIORITIES - 1) being the highest, and 0 being the lowest.
	 //, NULL );
 //}
 //