# Sourced by env.sh

DW_HADOOP_SERVICE_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# You may override DW_HADOOP_DIST_URI in your env ahead of time, and set as file:///path/to/file.tar.gz for local tarball, if needed
DW_HADOOP_DIST_URI="${DW_HADOOP_DIST_URI:-http://archive-primary.cloudera.com/cdh5/cdh/5/hadoop-2.6.0-cdh5.9.1.tar.gz}"
DW_HADOOP_DIST="$( downloadTarball "${DW_HADOOP_DIST_URI}" "${DW_HADOOP_SERVICE_DIR}" && echo "${tarball}" )"
DW_HADOOP_BASEDIR="hadoop-install"
DW_HADOOP_SYMLINK="hadoop"

DW_HADOOP_DFS_URI="hdfs://localhost:9000"
DW_HADOOP_MR_INTER_DIR="${DW_CLOUD_DATA}/hadoop/jobhist/inter"
DW_HADOOP_MR_DONE_DIR="${DW_CLOUD_DATA}/hadoop/jobhist/done"
DW_HADOOP_RESOURCE_MANAGER_ADDRESS="localhost:8050"

# core-site.xml (Format: <property-name><space><property-value>{<newline>})
DW_HADOOP_CORE_SITE_CONF="fs.defaultFS ${DW_HADOOP_DFS_URI}
hadoop.tmp.dir file:/${DW_CLOUD_DATA}/hadoop/tmp
io.compression.codecs org.apache.hadoop.io.compress.GzipCodec"

# hdfs-site.xml (Format: <property-name><space><property-value>{<newline>})
DW_HADOOP_HDFS_SITE_CONF="dfs.namenode.name.dir file://${DW_CLOUD_DATA}/hadoop/nn
dfs.namenode.checkpoint.dir file://${DW_CLOUD_DATA}/hadoop/nnchk
dfs.datanode.data.dir file://${DW_CLOUD_DATA}/hadoop/dn
dfs.datanode.handler.count 10
dfs.datanode.synconclose true
dfs.replication 1"

# mapred-site.xml (Format: <property-name><space><property-value>{<newline>})
DW_HADOOP_MAPRED_SITE_CONF="mapreduce.jobhistory.address http://localhost:8020
mapreduce.jobhistory.webapp.address http://localhost:8021
mapreduce.jobhistory.intermediate-done-dir ${DW_HADOOP_MR_INTER_DIR}
mapreduce.jobhistory.done-dir ${DW_HADOOP_MR_DONE_DIR}
mapreduce.admin.map.child.java.opts -server -XX:NewRatio=8 -Djava.net.preferIPv4Stack=true
mapreduce.map.memory.mb 2048
mapreduce.reduce.memory.mb 3072
mapreduce.map.java.opts: -Xmx1024m
mapreduce.reduce.java.opts: -Xmx2048m
mapreduce.admin.reduce.child.java.opts -server -XX:NewRatio=8 -Djava.net.preferIPv4Stack=true
mapreduce.framework.name yarn"

# yarn-site.xml (Format: <property-name><space><property-value>{<newline>})
DW_HADOOP_YARN_SITE_CONF="yarn.resourcemanager.scheduler.address localhost:8030
yarn.resourcemanager.scheduler.class org.apache.hadoop.yarn.server.resourcemanager.scheduler.capacity.CapacityScheduler
yarn.resourcemanager.resource-tracker.address localhost:8025
yarn.resourcemanager.address ${DW_HADOOP_RESOURCE_MANAGER_ADDRESS}
yarn.resourcemanager.admin.address localhost:8033
yarn.resourcemanager.webapp.address localhost:8088
yarn.nodemanager.local-dirs ${DW_CLOUD_DATA}/hadoop/yarn/local
yarn.nodemanager.log-dirs ${DW_CLOUD_DATA}/hadoop/yarn/log
yarn.nodemanager.aux-services mapreduce_shuffle
yarn.nodemanager.pmem-check-enabled false
yarn.nodemanager.vmem-check-enabled false
yarn.nodemanager.resource.memory-mb 4096
yarn.app.mapreduce.am.resource.mb 1024
yarn.log.server.url http://localhost:8070/jobhistory/logs"

# capacity-scheduler.xml (Format: <property-name><space><property-value>{<newline>})
DW_HADOOP_CAPACITY_SCHEDULER_CONF="yarn.scheduler.capacity.maximum-applications 10000
yarn.scheduler.capacity.maximum-am-resource-percent 0.1
yarn.scheduler.capacity.resource-calculator org.apache.hadoop.yarn.util.resource.DefaultResourceCalculator
yarn.scheduler.capacity.root.queues default,bulkIngestQueue,liveIngestQueue
yarn.scheduler.capacity.root.default.capacity 20
yarn.scheduler.capacity.root.bulkIngestQueue.capacity 40
yarn.scheduler.capacity.root.liveIngestQueue.capacity 40
yarn.scheduler.capacity.root.default.user-limit-factor 0.2
yarn.scheduler.capacity.root.bulkIngestQueue.user-limit-factor 0.4
yarn.scheduler.capacity.root.liveIngestQueue.user-limit-factor 0.4
yarn.scheduler.capacity.root.default.maximum-capacity 100
yarn.scheduler.capacity.root.bulkIngestQueue.maximum-capacity 90
yarn.scheduler.capacity.root.liveIngestQueue.maximum-capacity 90
yarn.scheduler.capacity.root.default.state RUNNING
yarn.scheduler.capacity.root.bulkIngestQueue.state RUNNING
yarn.scheduler.capacity.root.liveIngestQueue.state RUNNING
yarn.scheduler.capacity.root.default.acl_submit_applications *
yarn.scheduler.capacity.root.default.acl_administer_queue *
yarn.scheduler.capacity.node-locality-delay 40"

# Hadoop standard exports...
export HADOOP_HOME="${DW_CLOUD_HOME}/${DW_HADOOP_SYMLINK}"
export HADOOP_CONF_DIR="${HADOOP_HOME}/etc/hadoop"
export HADOOP_LOG_DIR="${HADOOP_HOME}/logs"
export HADOOP_PREFIX="${HADOOP_HOME}"
export HADOOP_YARN_HOME="${HADOOP_HOME}"
export HADOOP_MAPRED_HOME="${HADOOP_HOME}"
export HADOOP_PID_DIR="${DW_CLOUD_DATA}/hadoop/pids"
export HADOOP_MAPRED_PID_DIR="${HADOOP_PID_DIR}"

export PATH=${HADOOP_HOME}/bin:$PATH

# Service helpers...

DW_HADOOP_CMD_START="( cd ${HADOOP_HOME}/sbin && ./start-all.sh && ./mr-jobhistory-daemon.sh start historyserver )"
DW_HADOOP_CMD_STOP="( cd ${HADOOP_HOME}/sbin && ./mr-jobhistory-daemon.sh stop historyserver &&./stop-all.sh )"
DW_HADOOP_CMD_FIND_ALL_PIDS="pgrep -f 'datanode.DataNode|namenode.NameNode|namenode.SecondaryNameNode|nodemanager.NodeManager|resourcemanager.ResourceManager|mapreduce.v2.hs.JobHistoryServer'"

function hadoopIsRunning() {
    DW_HADOOP_PID_LIST="$(eval "${DW_HADOOP_CMD_FIND_ALL_PIDS} -d ' '")"
    [ -z "${DW_HADOOP_PID_LIST}" ] && return 1 || return 0
}

function hadoopStart() {
    hadoopIsRunning && echo "Hadoop is already running" || eval "${DW_HADOOP_CMD_START}"
    echo
    info "For detailed status visit 'http://localhost:50070/dfshealth.html#tab-overview' in your browser"
    # Wait for Hadoop to come out of safemode
    ${HADOOP_HOME}/bin/hdfs dfsadmin -safemode wait
}

function hadoopStop() {
    hadoopIsRunning && eval "${DW_HADOOP_CMD_STOP}" || echo "Hadoop is already stopped"
}

function hadoopStatus() {
    hadoopIsRunning && echo "Hadoop is running. PIDs: ${DW_HADOOP_PID_LIST}" || echo "Hadoop is not running"
}

function hadoopIsInstalled() {
    [ -L "${DW_CLOUD_HOME}/${DW_HADOOP_SYMLINK}" ] && return 0
    [ -d "${DW_HADOOP_SERVICE_DIR}/${DW_HADOOP_BASEDIR}" ] && return 0
    return 1
}

function hadoopUninstall() {
   if hadoopIsInstalled ; then
      if [ -L "${DW_CLOUD_HOME}/${DW_HADOOP_SYMLINK}" ] ; then
          ( cd "${DW_CLOUD_HOME}" && unlink "${DW_HADOOP_SYMLINK}" ) || error "Failed to remove Hadoop symlink"
      fi

      if [ -d "${DW_HADOOP_SERVICE_DIR}/${DW_HADOOP_BASEDIR}" ] ; then
          rm -rf "${DW_HADOOP_SERVICE_DIR}/${DW_HADOOP_BASEDIR}"
      fi

      ! hadoopIsInstalled && info "Hadoop uninstalled" || error "Failed to uninstall Hadoop"
   else
      info "Hadoop not installed. Nothing to do"
   fi

   [[ "${1}" == "${DW_UNINSTALL_RM_BINARIES_FLAG_LONG}" || "${1}" == "${DW_UNINSTALL_RM_BINARIES_FLAG_SHORT}" ]] && rm -f "${DW_HADOOP_SERVICE_DIR}"/*.tar.gz
}

function hadoopInstall() {
   "${DW_HADOOP_SERVICE_DIR}"/install.sh
}

function hadoopPrintenv() {
   echo
   echo "Hadoop Environment"
   echo
   ( set -o posix ; set ) | grep HADOOP_
   echo
}

function hadoopPidList() {

   hadoopIsRunning && echo "${DW_HADOOP_PID_LIST}"

}
