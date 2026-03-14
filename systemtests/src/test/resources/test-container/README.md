# Full flow
./run-tests.sh

# Just run a specific test
COMMAND=test TEST_CASE=KafkaST ./run-tests.sh

# With profile, skip rebuilds
COMMAND=test TEST_CASE=KafkaST TEST_PROFILE=operators SKIP_IMAGE_BUILD=true SKIP_BUILD=true ./run-tests.sh

# Custom cluster domain
COMMAND=test CONSOLE_CLUSTER_DOMAIN=myhost.example.com TEST_CASE=ConnectST ./run-tests.sh