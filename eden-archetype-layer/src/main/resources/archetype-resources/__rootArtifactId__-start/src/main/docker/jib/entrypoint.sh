#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/bin/bash

JAVA_OPTS="${symbol_dollar}{JAVA_OPTS} -XX:+UseG1GC"
JAVA_OPTS="${symbol_dollar}{JAVA_OPTS} -server -Xms${symbol_dollar}{JVM_XMS} -Xmx${symbol_dollar}{JVM_XMX} -Xmn${symbol_dollar}{JVM_XMN} -XX:MetaspaceSize=${symbol_dollar}{JVM_MS} -XX:MaxMetaspaceSize=${symbol_dollar}{JVM_MMS}"
JAVA_OPTS="${symbol_dollar}{JAVA_OPTS} -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${symbol_dollar}{WORKDIR}/logs/java_heapdump.hprof"
JAVA_OPTS="${symbol_dollar}{JAVA_OPTS} -XX:-UseLargePages"
if [[ "${symbol_dollar}{JVM_DEBUG}" == "y" ]]; then
	JAVA_OPTS="${symbol_dollar}{JAVA_OPTS} -Xdebug -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n"
fi

echo "The application will start in ${symbol_dollar}{START_DELAY_SECS}s..."
sleep ${symbol_dollar}{START_DELAY_SECS}
exec java ${symbol_dollar}{JAVA_OPTS} -noverify -XX:+AlwaysPreTouch -Djava.security.egd=file:/dev/./urandom -cp /app/resources/:/app/classes/:/app/libs/* "${project.groupId}.LayerApplication" "${symbol_dollar}@"
