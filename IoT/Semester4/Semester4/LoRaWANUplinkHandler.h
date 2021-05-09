/*
 * LoRaWANUplinkHandler.h
 *
 * Created: 09.05.2021 12:54:28
 *  Author: andy2
 */ 

 #include <ATMEGA_FreeRTOS.h>
 #include <message_buffer.h>

 void lora_uplink_handler_create(UBaseType_t lora_handler_task_priority, MessageBufferHandle_t messageBufferFromApplication);

 #endif