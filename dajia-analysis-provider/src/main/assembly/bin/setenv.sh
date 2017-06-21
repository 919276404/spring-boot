#!/bin/bash
BASE_DIR=`cd .. && pwd`
TEMP_DIR=${BASE_DIR}/temp
if [ ! -d ${TEMP_DIR} ]; then
    mkdir ${TEMP_DIR}
fi
LOG_DIR=${BASE_DIR}/logs
if [ ! -d ${LOG_DIR} ]; then
    mkdir ${LOG_DIR}
fi
STDOUT_FILE=${LOG_DIR}/stdout.log
if [ ! -f ${STDOUT_FILE} ]; then
    touch ${STDOUT_FILE}
fi
LIB_DIR=${BASE_DIR}/lib
PID=${BASE_DIR}/bin/PID
CONF_DIR=${BASE_DIR}/conf
PORT_HTTP="20030"
TOMCAT_OPTS=" -Dserver.port=${PORT_HTTP} -Dserver.tomcat.max-threads=2048 -Dserver.tomcat.uri-encoding=UTF-8 -Dserver.tomcat.basedir=${TEMP_DIR} -Dlogging.path=${LOG_DIR}"

JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "

JAVA_MEM_OPTS=" -server -Xms512m -Xmx1g -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -Xmn128m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "

HTTP_PROXY_SET=false
HTTP_PROXY_HOST=172.16.1.12
HTTP_PROXY_PORT=8888
HTTP_NON_PROXY_HOSTS="172.16.*.*|192.168.*.*|10.3.3.*"
PROXY_OPTS=""
if [ $HTTP_PROXY_SET == true ]; then
        PROXY_OPTS=" -Dhttp.proxySet=$HTTP_PROXY_SET -Dhttp.proxyHost=$HTTP_PROXY_HOST -Dhttp.proxyPort=$HTTP_PROXY_PORT -Dhttps.proxyHost=$HTTP_PROXY_HOST -Dhttps.proxyPort=$HTTP_PROXY_PORT -Dhttp.nonProxyHosts=$HTTP_NON_PROXY_HOSTS"
fi

JVM_OPTS=" $JAVA_OPTS $JAVA_MEM_OPTS $TOMCAT_OPTS $PROXY_OPTS"