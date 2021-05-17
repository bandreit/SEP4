#pragma once
#include <semphr.h>

extern SemaphoreHandle_t configSemaphore;
extern int* ventilationLevel;

void initializeConfiguration();

void setVentilationLevel();

int* getVentilationLevel();