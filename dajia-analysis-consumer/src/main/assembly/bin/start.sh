#!/bin/bash

source setenv.sh

PIDS=`ps -ef | grep java | grep "$CONF_DIR" | grep -v grep |awk '{print $2}'`
if [ "" != "$PIDS" ]; then
    echo "ERROR: The spring boot application already started!"
    echo "PID: $PIDS"
    exit 1
fi


APP_JAR=`ls ${LIB_DIR}|grep .jar|awk '{print "'${LIB_DIR}'/"$0}'`


echo "Starting the spring boot application ...\c"
START=$(date +%s)
nohup java ${JVM_OPTS} -jar ${APP_JAR} -classpath ${CONF_DIR} > ${STDOUT_FILE} 2>&1 &

FLAG=0
while (( FLAG != 1 )); do
    echo .'.\c'
    FLAG=`ps -ef | grep java | grep "${CONF_DIR}" | grep -v grep | wc -l`
    END=$(date +%s)

    if (( FLAG == 1 )); then
        break
    fi
done

echo "OK!"
PIDS=`ps -ef | grep java | grep "$CONF_DIR" | grep -v grep | awk '{print $2}'`
echo "spring boot application started in $(( $END - $START )) ms with PID: $PIDS"

