#!/bin/bash
source setenv.sh

PIDS=`ps -ef | grep java | grep "$CONF_DIR" | grep -v grep |awk '{print $2}'`
if [ "" == "$PIDS" ]; then
    echo "ERROR: The spring boot application does not started!"
    exit 1
fi


echo "Stopping the spring boot application ...\c"
START=$(date +%s)

for PID in $PIDS ; do
    kill -9 $PID > /dev/null 2>&1
done

COUNT=0
while [ $COUNT -lt 1 ]; do
    echo "..\c"
    sleep 1
    COUNT=1
    PID_EXIST=`ps -ef | grep java | grep "$CONF_DIR" | grep -v grep |awk '{print $2}'`
    if [ -n "$PID_EXIST" ]; then
        COUNT=0
    fi
done

END=$(date +%s)
echo "OK!"
echo "spring boot application stopped in $(( $END - $START )) ms with PID: $PIDS"
