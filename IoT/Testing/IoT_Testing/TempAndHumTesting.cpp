
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"



extern "C"
{
#include <TempAndHum.h>
#include <Setup.h>
#include "FreeRTOS.h"
#include "task.h"
#include "semphr.h"
#include "event_groups.h"
#include "queue.h"
}


class TempAndHumTest : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xSemaphoreTake);
		RESET_FAKE(xEventGroupSetBits);
		RESET_FAKE(xQueueSend);
		RESET_FAKE(vTaskDelay);
		FFF_RESET_HISTORY();
	}

	void TearDown() override
	{

	}
};

TEST_F(TempAndHumTest, TempAndHumSemaphoreGiven) {
	initializeTempAndHumiditySemaphore();
	xSemaphoreTake_fake.return_val = pdTRUE;
	tempAndHum_run();
	ASSERT_EQ(1,xSemaphoreTake_fake.call_count);
	ASSERT_EQ(pdTRUE, xSemaphoreTake_fake.return_val);
	ASSERT_EQ(1, xEventGroupSetBits_fake.call_count);
	ASSERT_EQ(2, xQueueSend_fake.call_count);
}

TEST_F(TempAndHumTest, SemaphoreNotGiven) {
	initializeTempAndHumiditySemaphore();
	xSemaphoreTake_fake.return_val = pdFALSE;
	tempAndHum_run();
	ASSERT_EQ(1, xSemaphoreTake_fake.call_count);
	ASSERT_EQ(pdFALSE, xSemaphoreTake_fake.return_val);
	ASSERT_EQ(pdMS_TO_TICKS(10), vTaskDelay_fake.arg0_val);
}