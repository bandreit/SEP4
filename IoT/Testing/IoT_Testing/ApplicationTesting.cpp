
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"
#include <stdint.h>


extern "C"
{
#include <Setup.h>
#include <application.h>
#include "FreeRTOS.h"
#include "semphr.h"
#include "event_groups.h"
#include "queue.h"
}



class ApplicationTest : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xEventGroupWaitBits);
		RESET_FAKE(xQueueReceive);
		RESET_FAKE(xSemaphoreGive);
		RESET_FAKE(vTaskDelay);
		FFF_RESET_HISTORY();
	}

	void TearDown() override
	{

	}
};

TEST_F(ApplicationTest, ApplicationBothBitsNotSet)
{
	ApplicationTask_run();
	ASSERT_EQ(1, xEventGroupWaitBits_fake.call_count);
	ASSERT_EQ(pdMS_TO_TICKS(50), vTaskDelay_fake.arg0_val);
}


TEST_F(ApplicationTest, ApplicationTaskBitsSet)
{
	xEventGroupWaitBits_fake.return_val = (BIT_CO2 | BIT_HUMIDITY_TEMPERATURE);
	ApplicationTask_run();
	ASSERT_EQ(1, xEventGroupWaitBits_fake.call_count);
	ASSERT_EQ(2, vTaskDelay_fake.call_count);
	ASSERT_EQ(3, xQueueReceive_fake.call_count);
	ASSERT_EQ(1, xSemaphoreGive_fake.call_count);
}