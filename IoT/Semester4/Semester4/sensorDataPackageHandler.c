/*
 * sensorDataPackageHandler.c
 *
 *  Author: IoT
 */ 
#include "sensorDataPackageHandler.h"

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

#include <lora_driver.h>

uint16_t co2_value;
uint16_t hum_value;
uint16_t temp_value;
uint8_t package_lenght;
uint8_t ventilator_servo;


void sensorDataPackageHandler_setPackage_lenght(uint8_t lenght)
{
	package_lenght=lenght;
}

void sensorDataPackageHandler_setCO2_value(uint16_t value)
{
	co2_value=value;
}

void sensorDataPackageHandler_setTemp_value(uint16_t value)
{
	temp_value=value;
}

void sensorDataPackageHandler_setHumidity_value(uint16_t value)
{
	hum_value=value;
}

void sensorDataPackageHandler_setVentilator_servo(uint8_t ventilator_state_servo)
{
	ventilator_servo=ventilator_state_servo;
}

lora_driver_payload_t sensorDataPackageHandler_getLoRaPayload(uint8_t port_No)
{
	lora_driver_payload_t *uplink_payload;
	
	uplink_payload=pvPortMalloc(sizeof(lora_driver_payload_t));
	
	if(uplink_payload != NULL){
		uplink_payload->portNo=port_No;
		uplink_payload->len=package_lenght;
		uplink_payload->bytes[0]=co2_value >> 8;
		uplink_payload->bytes[1]=co2_value & 0xFF;
		uplink_payload->bytes[2]=hum_value >> 8;
		uplink_payload->bytes[3]=hum_value & 0xFF;
		uplink_payload->bytes[4]=temp_value >> 8;
		uplink_payload->bytes[5]=temp_value & 0xFF;
		uplink_payload->bytes[6]=ventilator_servo & 0xFF;
	}
	
	return *uplink_payload;
}
