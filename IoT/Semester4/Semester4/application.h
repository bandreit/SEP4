/*
 * application.h
 *
 *  Author: IoT
 */ 

#ifndef APPLICATION_H
#define APPLICATION_H

#include <ATMEGA_FreeRTOS.h>
#include <message_buffer.h>
#include <event_groups.h>
#include <semphr.h>

void createApplicationTask();
void ApplicationTask(void *pvParameters);
void setPackageHandler();
						
#endif
