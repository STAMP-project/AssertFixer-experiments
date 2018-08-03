#!/usr/bin/env bash

source /opt/datawave/contrib/datawave-quickstart/bin/env.sh

echo "DataWave Source Home: $DW_DATAWAVE_SOURCE_DIR"
echo "DataWave Deploy Home: $DW_CLOUD_HOME"

/usr/bin/nohup /usr/sbin/sshd -D > /dev/null 2>&1 &

exec "$@"
