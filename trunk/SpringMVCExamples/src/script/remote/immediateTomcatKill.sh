#!/bin/sh
# -----------------------------------------------------------------------------
# Immediately kills the running tomcat process
#

ps -ef | grep java | grep catalina.home | grep -v 'apache-tomcat-5.5.23' | awk '{print $2}' | xargs kill -9 > /dev/null 2>&1
