#!/bin/bash
if [[ `uname` == "Darwin" ]]; then
  THIS_SCRIPT=`python -c 'import os,sys;print os.path.realpath(sys.argv[1])' $0`
else
  THIS_SCRIPT=`readlink -f $0`
fi
THIS_DIR="${THIS_SCRIPT%/*}"
cd $THIS_DIR

. ../ingest/ingest-env.sh

if [[ -z ${LOCK_FILE_DIR} ]]; then
  echo "LOCK_FILE_DIR is not set, be sure to source bin/ingest/ingest-env.sh"
  exit -1
fi

# If the paused file exists, then prevent startup unless forcing
if [[ "$@" =~ ".*-force.*" || "$@" =~ "-force" ]]; then
    rm -f ${LOCK_FILE_DIR}/METRICS_INGEST_STARTUP.LCK
    $0 ${@/-force/}
    exit $?
fi
if [ -e ${LOCK_FILE_DIR}/METRICS_INGEST_STARTUP.LCK ]; then
    echo "Startup has been locked out.  Use -force to unlock."
    exit -1
fi


TYPE=$1

if [[ $TYPE == "flagmaker" ]]; then

    INPUT_FOLDER="${BASE_WORK_DIR}/FlagMakerMetrics"
    CLASS="datawave.metrics.mapreduce.FlagMakerMetricsIngester"
    TYPE="flagmaker"

elif [[ $TYPE == "ingest" ]]; then

    INPUT_FOLDER="${BASE_WORK_DIR}/IngestMetrics"
    CLASS="datawave.metrics.mapreduce.IngestMetricsIngester"
    TYPE="ingest"

elif [[ $TYPE == "loader" ]]; then

    INPUT_FOLDER="${BASE_WORK_DIR}/MapFileLoaderMetrics"
    CLASS="datawave.metrics.mapreduce.LoaderMetricsIngester"

else
    echo "Supported types are: ingest and loader"
    exit 1
fi 


if ((`pgrep -f "\-Dapp=${TYPE}MetricsIngest" | wc -l`==0))
then
        #nohup ./metrics.sh $CLASS -type $TYPE -input $INPUT_FOLDER -instance $INGEST_INSTANCE_NAME -zookeepers $INGEST_ZOOKEEPERS -user $USERNAME -password $PASSWORD >> $LOG_DIR/MetricsIngest-$TYPE.log 2>&1 &
    ./metrics.sh $CLASS -type $TYPE -input $INPUT_FOLDER -instance $INGEST_INSTANCE_NAME -zookeepers $INGEST_ZOOKEEPERS -user $USERNAME -password $PASSWORD >> $LOG_DIR/MetricsIngest-$TYPE.log 2>&1 
 else
    echo "$TYPE metrics already being ingested" >> $LOG_DIR/IngestMetricsIngest.log
fi

