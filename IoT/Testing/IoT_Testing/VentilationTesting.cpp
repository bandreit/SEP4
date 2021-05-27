
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"



extern "C"
{
#include <FreeRTOS.h>
#include <stdio.h>
#include <stdint.h>
#include <task.h>
#include <semphr.h>
#include "ventilation.h"
#include "configuration.h"
#include "Setup.h"
}


class VentilationTesting : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xSemaphoreTake);
		RESET_FAKE(vTaskDelay);
		FFF_RESET_HISTORY();
	}

	void TearDown() override
	{

	}
};

TEST_F(VentilationTesting, VentilationSemaphoreGiven) {
	initializeVentilationSemaphore();
	xSemaphoreTake_fake.return_val = pdTRUE;
	VentilationTask_run();
	ASSERT_EQ(2, xSemaphoreTake_fake.call_count);
}

TEST_F(VentilationTesting, VentilationSemaphoreNotGiven) {
	initializeVentilationSemaphore();
	xSemaphoreTake_fake.return_val = pdFALSE;
	VentilationTask_run();
	ASSERT_EQ(1, xSemaphoreTake_fake.call_count);
}