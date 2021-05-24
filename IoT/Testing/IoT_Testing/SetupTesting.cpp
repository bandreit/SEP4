
#include "gtest/gtest.h"

#include "FreeRTOS_MOCK_FFF.h"



extern "C"
{
#include <Setup.h>
#include "FreeRTOS.h"
#include "task.h"
#include "semphr.h"
#include "event_groups.h"
#include "queue.h"
}


class SetupTesting : public::testing::Test
{
protected:
	void SetUp() override
	{
		RESET_FAKE(xMessageBufferCreate);
		RESET_FAKE(xSemaphoreCreateBinary);
		RESET_FAKE(xQueueCreate);
		RESET_FAKE(xEventGroupCreate);
		FFF_RESET_HISTORY();

	}

	void TearDown() override
	{

	}
};

TEST_F(SetupTesting, Initialise_Semaphore) {
	initializeTempAndHumiditySemaphore();

	ASSERT_EQ(1, xSemaphoreCreateBinary_fake.call_count);
	ASSERT_EQ(1, xSemaphoreGive_fake.call_count);

}

TEST_F(SetupTesting, Initialise_Queue) {
	initializeQueue();

	ASSERT_EQ(1, xQueueCreate_fake.call_count);
	ASSERT_EQ(3,xQueueCreate_fake.arg0_val);
	ASSERT_EQ(2, xQueueCreate_fake.arg1_val);
}

TEST_F(SetupTesting, Initialise_DownLinkMessageBuffer) {
	initializeDownlinkMessageBuffer();

	ASSERT_EQ(1, xMessageBufferCreate_fake.call_count);
	ASSERT_EQ(100, xMessageBufferCreate_fake.arg0_val);
}

TEST_F(SetupTesting, Initialise_UpLinkMessageBuffer) {
	initializeUplinkMessageBuffer();

	ASSERT_EQ(1, xMessageBufferCreate_fake.call_count);
	ASSERT_EQ(100, xMessageBufferCreate_fake.arg0_val);
}

TEST_F(SetupTesting, Initialise_EventGroup) {
	initializeEventGroup();

	ASSERT_EQ(1, xEventGroupCreate_fake.call_count);
}