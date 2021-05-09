/*
 * LoRaWANDownlinkHandler.h
 *
 * Created: 09.05.2021 15:09:41
 *  Author: andy2
 */
  
 #include <ATMEGA_FreeRTOS.h>
 #include <message_buffer.h>

 void lora_downlink_handler_create(UBaseType_t lora_handler_task_priority, MessageBufferHandle_t messageBufferDownlink);

 #endif