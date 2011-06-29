#!/bin/bash

if [[ "${PROFILE_USER}" == "" ]]
then
  export PROFILE_USER=$USER
fi


# Common environment variables
export CATALINA_OPTS="-Duser.timezone=UTC -Dcom.sun.management.jmxremote"
export PATH=$PATH:$JAVA_HOME/bin
#export FAILURE_EMAIL_ADDRESS=${USER}@lunch.com
export PREVENT_LIBRARY_DOWNLOAD=-o
#export ACTIVEMQ_OPTS=-Djava.security.auth.login.config="/home/$USER/opt/activemq/webapps/admin/login.config -Djetty.home=/home/$USER/opt/activemq/conf/jetty"
#export PATH=$PATH:$HOME/opt/firefox
#export SELENIUM_GRID_HOME=$HOME/opt/selenium-grid
#export SELENIUM_TEMPLATE=$HOME/.mozilla/firefox/test.selenium

# Common aliases
alias tc='cd $TOMCAT_HOME'
alias tlc='tail -n 400 -f $TOMCAT_HOME/logs/catalina.out'
alias tll='tail -n 400 -f $TOMCAT_HOME/logs/localhost.`date +%Y-%m-%d`.log'

function killtom(){
	 ps -ef | grep java | grep catalina.home | grep -v 'apache-tomcat-5.5.23' | awk '{print $2}' | xargs kill -9
}

#function gridstart() {
#    echo "Starting Selenium-Grid"
#    	nohup ant -buildfile $SELENIUM_GRID_HOME/build.xml launch-hub 2>$SELENIUM_GRID_HOME/log/selenium-grid.log &
#}

#function gridserverstart() {
#    for REMOTE_PORT in ${*}
#    do	
#	echo "Starting Selenium Remote Server on port:$REMOTE_PORT"
#	nohup ant -buildfile $SELENIUM_GRID_HOME/build.xml -Denvironment='*chrome' -Dport=$REMOTE_PORT -DseleniumArgs='-firefoxProfileTemplate $SELENIUM_TEMPLATE -browserSessionReuse' launch-remote-control 2>$SELENIUM_GRID_HOME/log/selenium-grid.log &
#    done	
#}

#function seleniumgrid() {
#	gridstart
#	sleep 5
#	gridserverstart 5555 5556 5557
#}

#function killgrid() {
#  ps ax | grep selenium-grid | awk '{print $1}' | xargs kill -9
#}

function newmaven() {
  cd ~/opt
  rm maven
  ln -s apache-maven-2.2.1 maven
}

function oldmaven() {
  cd ~/opt
  rm maven
  ln -s apache-maven-2.0.9 maven
}

# Most used
# Run this when you've updated your code from svn, rebuilds lucene, apache, database, restarts tomcat
#alias mvnnewcode='mvn -U -cpu clean dependency:sources integration-test -Denv=local -Dmaven.test.skip=true -Ddatabase.update.skip=false -P${PROFILE_USER}'

# Run this to do a clean rebuild without all the downloading
#alias mvnfullrebuild='mvn ${PREVENT_LIBRARY_DOWNLOAD} integration-test -Denv=local -Dmaven.test.skip=true -Ddatabase.update.skip=false -P${PROFILE_USER}'


# Run this before committing a change, runs through all the stuff cruise will check to make sure you are good
#alias mvncruise='mvn ${PREVENT_LIBRARY_DOWNLOAD} clean integration-test checkstyle:check -Denv=local -Ddatabase.update.skip=false -P${PROFILE_USER}'

# Rebuilds the war file and restarts tomcat, then starts a copy loop to allow for automatic updates to jsps and apache files within the running server
#alias mvnrestartthenloop='sh src/script/mvnrestartthenloop.sh'

# Start a local remote control selenium server in interactive mode
#alias seleniumstart='export PATH=$PATH:$HOME/opt/firefox; java -jar ~/.m2/repository/org/seleniumhq/selenium/server/selenium-server/1.0.3/selenium-server-1.0.3.jar -interactive  -firefoxProfileTemplate ~/.mozilla/firefox/test.selenium/ -browserSessionReuse'

#alias seleniumstartbeta='export PATH=$PATH:$HOME/opt/firefox; java -jar ~/.m2/repository/org/seleniumhq/selenium/server/selenium-server/1.0.3/selenium-server-1.0.3.jar -interactive  -firefoxProfileTemplate ~/.mozilla/firefox/test.selenium/ -browserSessionReuse'

# Less used
# If you just want to push out apache changes
#alias mvnapache='mvn ${PREVENT_LIBRARY_DOWNLOAD} initialize -Ptarget-apache-deploy,local-apache,${PROFILE_USER}'

# Run this before committing a change, runs through all the stuff cruise will check to make sure you are good
#alias mvncheckstyle='mvn ${PREVENT_LIBRARY_DOWNLOAD} checkstyle:check -P${PROFILE_USER}'


# Rebuilds the war file and restarts tomcat.  Run mvn clean before if you want this to be completely clean
alias mvntomcatrebuild='mvn ${PREVENT_LIBRARY_DOWNLOAD} -npu integration-test -Dmaven.test.skip=true -Ptomcat-rebuild,${PROFILE_USER}'

# Rebuilds the lucene index
#alias mvnlucene='mvn ${PREVENT_LIBRARY_DOWNLOAD} process-test-resources -Plucene,${PROFILE_USER}'

# Rebuilds the autocomplete lucene index
#alias mvnautocomplete='mvn ${PREVENT_LIBRARY_DOWNLOAD} process-test-resources -Pautocomplete,${PROFILE_USER}'

# Rebuilds the sitemap index
#alias mvnsitemap='mvn ${PREVENT_LIBRARY_DOWNLOAD} process-test-resources -Psitemap,${PROFILE_USER}'

# Stops tomcat
#alias mvntomcatstop='mvn ${PREVENT_LIBRARY_DOWNLOAD} initialize -Ptomcat-rebuild,${PROFILE_USER}'

# Regenerates the database
#alias mvndatabase='mvn ${PREVENT_LIBRARY_DOWNLOAD} initialize -Ddatabase.update.skip=false -P${PROFILE_USER}'

# Regenerates the seed data for the database only
#alias mvndatabaseseed='mvn ${PREVENT_LIBRARY_DOWNLOAD} initialize -Ddatabase.seedData.skip=false'

# Regenerates the layout part of the database only
#alias mvndatabaselayout='mvn ${PREVENT_LIBRARY_DOWNLOAD} initialize -Ddatabase.regenerate.layout.skip=false'

# Starts the automatic copy loop of jsp and apache files
alias copyallloop='sh src/script/copyallloop.sh'

# Automatic copy loop just for apache
#alias copyapacheloop='sh src/script/copyapacheloop.sh'

# Automatic copy loop just for jsp
#alias copyjsploop='sh src/script/copyjsploop.sh'

#alias amqstart='~/opt/activemq/bin/activemq-admin start > ~/opt/activemq/logs/activemq.log 2>&1'

#alias vce='cat $INFOMUNITY_HOME/target/checkstyle-result.xml | grep -B1 -A1 error'

#alias apache_gg="sudo sed 's/\/im\//\/gg\//g' /etc/httpd/conf/httpd.conf | sed 's/\/im /\/gg /g' | sed 's|#ProxyPass\([ \/]\+\)favicon|ProxyPass\1favicon|g' > temp.txt; sudo cp temp.txt /etc/httpd/conf/httpd.conf; rm temp.txt; sudo service httpd restart"
#alias apache_im="sudo sed 's/\/gg\//\/im\//g' /etc/httpd/conf/httpd.conf | sed 's/\/gg /\/im /g' | sed 's|[^#]ProxyPass\([ \/]\+\)favicon| #ProxyPass\1favicon|g' > temp.txt; sudo cp temp.txt /etc/httpd/conf/httpd.conf; rm temp.txt; sudo service httpd restart"
