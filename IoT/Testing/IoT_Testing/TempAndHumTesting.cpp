
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

}