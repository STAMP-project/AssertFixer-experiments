#!/bin/sh
DIRNAME=`dirname $0`

JAVAARGS="-Xmx2524M"

if [ $MINERVA_CLI_MEMORY ]
then
  JAVAARGS="-Xmx$MINERVA_CLI_MEMORY"
fi
java $JAVAARGS -jar $DIRNAME/minerva-cli.jar  "$@"


