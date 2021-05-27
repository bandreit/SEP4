#pragma once
#include <stdint.h>

#define pdMS_TO_TICKS(ms) (ms)
#define portMAX_DELAY 0xFFFF
#define pdTRUE 1
#define pdFALSE 0

#define configSTACK_DEPTH_TYPE int16_t
typedef enum { running } eTaskState;

typedef size_t TickType_t;

typedef uint8_t UBaseType_t;
typedef int8_t  BaseType_t;

typedef size_t StackType_t;
typedef size_t StaticTask_t;

typedef struct lora_driver_payload {
	uint8_t portNo; /**< Port_no the data is received on, or to transmit to */
	uint8_t len; /**< Length of the payload (no of bytes) */
	uint8_t bytes[20]; /**< Array to hold the payload to be sent, or that has been received */
} lora_driver_payload_t;