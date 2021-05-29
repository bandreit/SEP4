
 #pragma once
 
#include <stdint.h>
#include <stdio.h>

#include <ATMEGA_FreeRTOS.h>
#include <message_buffer.h>
#include <task.h>
#include <lora_driver.h>

#include "Setup.h"
#include "configuration.h"

void lora_downlink_handler_create(UBaseType_t lora_handler_task_priority);

