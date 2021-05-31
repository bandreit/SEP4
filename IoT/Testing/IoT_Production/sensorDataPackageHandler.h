
#pragma once

#include <stdint.h>

#include <FreeRTOS.h>

void sensorDataPackageHandler_setPackage_lenght(uint8_t lenght);
void sensorDataPackageHandler_setCO2_value(uint16_t value);
void sensorDataPackageHandler_setTemp_value(uint16_t value);
void sensorDataPackageHandler_setHumidity_value(uint16_t value);
void sensorDataPackageHandler_setVentilator_servo(uint8_t ventilator_state_servo);

