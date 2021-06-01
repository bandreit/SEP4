
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"
#include <stdint.h>


extern "C"
{
#include <CO2.h>
#include <Setup.h>
#include "FreeRTOS.h"
#include "task.h"
#include "semphr.h"
#include "event_groups.h"
#include "queue.h"
}



class CO2Test : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xEventGroupWaitBits);
		RESET_FAKE(xEventGroupSetBits);
		RESET_FAKE(xQueueSend);
		RESET_FAKE(vTaskDelay);
		FFF_RESET_HISTORY();
	}

	void TearDown() override
	{

	}
};

TEST_F(CO2Test, CO2_TempAndHumBitSet) {
	xEventGroupWaitBits_fake.return_val = BIT_HUMIDITY_TEMPERATURE;
	CO2Task_run();
	ASSERT_EQ(1, xEventGroupWaitBits_fake.call_count);
	ASSERT_EQ(1, xQueueSend_fake.call_count);
	ASSERT_EQ(1, xEventGroupSetBits_fake.call_count);
}


TEST_F(CO2Test, CO2_TempAndHumBitNotSet) {
	xEventGroupWaitBits_fake.return_val = 0;
	CO2Task_run();
	ASSERT_EQ(1, xEventGroupWaitBits_fake.call_count);
	ASSERT_EQ(0, xQueueSend_fake.call_count);
	ASSERT_EQ(0, xEventGroupSetBits_fake.call_count);
	ASSERT_EQ(pdMS_TO_TICKS(30), vTaskDelay_fake.arg0_val);
}
