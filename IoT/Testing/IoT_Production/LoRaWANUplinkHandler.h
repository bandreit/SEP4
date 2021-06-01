#pragma once
#include <FreeRTOS.h>
#include <message_buffer.h>

void lora_uplink_handler_create(UBaseType_t lora_handler_task_priority);

