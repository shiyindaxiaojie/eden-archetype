#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/bin/sh

echo "The application will start in ${RUN_SLEEP}s..." && sleep ${RUN_SLEEP}
exec java ${JAVA_OPTS} -noverify -XX:+AlwaysPreTouch -Djava.security.egd=file:/dev/./urandom -cp /app/resources/:/app/classes/:/app/libs/* "${package}.Application"  "$@"
