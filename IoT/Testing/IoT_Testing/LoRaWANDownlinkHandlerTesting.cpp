
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"
#include <stdint.h>

extern "C"
{
#include <FreeRTOS.h>
#include <message_buffer.h>
#include <task.h>
#include <stdio.h>
#include <stdint.h>
#include "LoRaWANDownlinkHandler.h"
#include "Setup.h"
}

class LoRaWANDownlinkHandlerTesting : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xMessageBufferCreate);
		RESET_FAKE(xSemaphoreGive);
		RESET_FAKE(vTaskDelay);
		FFF_RESET_HISTORY();
	}

	void TearDown() override
	{

	}
};

TEST_F(LoRaWANDownlinkHandlerTesting, DownLinkMessageBufferIsEmpty) {
	LoRaWanDownlinkTask_run();
	ASSERT_EQ(1, xMessageBufferReceive_fake.call_count);
	xMessageBufferIsEmpty_fake.return_val = pdFALSE;
	ASSERT_EQ(0, xSemaphoreGive_fake.call_count);
}
