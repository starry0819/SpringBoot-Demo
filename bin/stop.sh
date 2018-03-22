#!/bin/bash

cd `dirname $0`
BIN_DIR=`pwd -P`
SERVER_PATH=`echo $BIN_DIR | sed 's/bin//g'`

if [ -z "$SERVER_PATH" ]; then
	SERVER_PATH=`hostname`
fi

PIDS=`ps  --no-heading -C java -f --width 1000 | grep "$SERVER_PATH" |awk '{print $2}'`
if [ -z "$PIDS" ]; then
    echo "ERROR: The $SERVER_PATH does not started!"
    exit 1
fi

if [ "$1" != "skip" ]; then
	if [ "$1" != "fullheap" ]; then
		$BIN_DIR/dump.sh
	else
		$BIN_DIR/dump.sh fullheap
	fi
fi

echo -e "Stopping the $SERVER_PATH ...\c"
for PID in $PIDS ; do
	echo "try kill pid:$PID"
	kill $PID > /dev/null 2>&1

	killWaitCount=0
	ps $PID | grep java > /dev/null 2>&1
   while [ $? -eq 0 -a $killWaitCount -lt 60 ]
   do
   		killWaitCount=$((killWaitCount+1))
   		sleep 1
   		echo "still running. ${killWaitCount}"
   		ps $PID | grep java > /dev/null 2>&1
   	done

	ps $PID | grep java
	if [ $? -eq 0 ]
	then
		echo "try kill -9 pid:$PID"
		kill -9 $PID > /dev/null 2>&1
	fi

	sleep 1
done

COUNT=0
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
    COUNT=1
    for PID in $PIDS ; do
		PID_EXIST=`ps --no-heading -p $PID`
		if [ -n "$PID_EXIST" ]; then
			COUNT=0
			break
		fi
	done
done
echo "OK!"
echo "PID: $PIDS"

rm ../run.pid
