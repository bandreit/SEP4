#pragma once
#include <semphr.h>
#include <stdint.h>

extern SemaphoreHandle_t configSemaphore;
extern uint8_t ventilationLevel;

void initializeConfiguration();

void setVentilationLevel(uint8_t level);

uint8_t getVentilationLevel();