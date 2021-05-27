#pragma once

#include <stdint.h>

#include <ATMEGA_FreeRTOS.h>
#include <semphr.h>

extern SemaphoreHandle_t configSemaphore;
extern uint8_t ventilationLevel;

void initializeConfiguration();

void setVentilationLevel(uint8_t level);

uint8_t getVentilationLevel();