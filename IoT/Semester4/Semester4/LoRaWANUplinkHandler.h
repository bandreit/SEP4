#pragma once

 #include <stddef.h>
 #include <stdio.h>

 #include <ATMEGA_FreeRTOS.h>
 #include <message_buffer.h>
 #include <task.h>
 #include <lora_driver.h>
 #include <status_leds.h>
 
  #include "Setup.h"
  #include "sensorDataPackageHandler.h"

 void lora_uplink_handler_create(UBaseType_t lora_handler_task_priority);

