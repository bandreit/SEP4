/*
 * sensorDataPackageHandler.c
 *
 *  Author: IoT
 */
#include "sensorDataPackageHandler.h"

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

uint16_t co2_value;
uint16_t hum_value;
uint16_t temp_value;
uint8_t package_lenght;
uint8_t ventilator_servo;


void sensorDataPackageHandler_setPackage_lenght(uint8_t lenght)
{
	package_lenght = lenght;
}

void sensorDataPackageHandler_setCO2_value(uint16_t value)
{
	co2_value = value;
}

void sensorDataPackageHandler_setTemp_value(uint16_t value)
{
	temp_value = value;
}

void sensorDataPackageHandler_setHumidity_value(uint16_t value)
{
	hum_value = value;
}

void sensorDataPackageHandler_setVentilator_servo(uint8_t ventilator_state_servo)
{
	ventilator_servo = ventilator_state_servo;
}


