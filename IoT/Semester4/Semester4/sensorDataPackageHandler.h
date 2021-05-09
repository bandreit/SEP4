/*
 * sensorDataPackageHandler.h
 *
 *  Author: IoT
 */ 

#ifndef SENSORDATAPACKAGEHANDLER_H
#define SENSORDATAPACKAGEHANDLER_H

#include <stdint.h>

#include <ATMEGA_FreeRTOS.h>
#include <lora_driver.h>

void sensorDataPackageHandler_setPackage_lenght(uint8_t lenght);
void sensorDataPackageHandler_setCO2_value(uint16_t value);
void sensorDataPackageHandler_setTemp_value(uint16_t value);
void sensorDataPackageHandler_setHumidity_value(uint16_t value);
void sensorDataPackageHandler_setVentilator_servo(uint8_t ventilator_state_servo);
lora_driver_payload_t sensorDataPackageHandler_getLoRaPayload(uint8_t port_No);

#endif
