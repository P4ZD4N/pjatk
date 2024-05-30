#!/bin/bash

JAVA_FILES=$(find / -type f -name "*.java" 2>/dev/null | wc -l)
CLASS_FILES=$(find / -type f -name "*.class" 2>/dev/null | wc -l)

if [ "$JAVA_FILES" -ge "$CLASS_FILES" ]; then
  DIFFERENCE=$(($JAVA_FILES - $CLASS_FILES))
else
  DIFFERENCE=$(($CLASS_FILES - $JAVA_FILES))
fi


echo "Java files: $JAVA_FILES"
echo "Class files: $CLASS_FILES"
echo "Difference: $DIFFERENCE"


exit 0
