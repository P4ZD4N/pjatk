#!/bin/bash

read -p "Package name: " PCKG_NAME

read -p "Class name: " CLASS_NAME

if [[ -e "$PCKG_NAME/$CLASS_NAME" ]] ; then
  echo "Class $CLASS_NAME already exists"
  exit 1
fi

if [[ ! -d "$PCKG_NAME" ]] ; then
  mkdir "$PCKG_NAME"
fi

touch "$PCKG_NAME/$CLASS_NAME.java"

echo "package $PCKG_NAME" > "$PCKG_NAME/$CLASS_NAME.java"
echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
echo "public class $CLASS_NAME {" >> "$PCKG_NAME/$CLASS_NAME.java"

while true ; do

read -p "Do you want to add field to this class? (y/n): " CHOICE

  if [[ $CHOICE == "n" || $CHOICE == "N" ]] ; then

    echo "..."
    break

  elif [[ $CHOICE == "y" || $CHOICE == "Y" ]] ; then

    read -p "Type of field (only int, double, String): " TYPE
    read -p "Field name: " FIELD_NAME
    read -p "Add getter/setter/getter and setter (g/s/gs): " ADD_GS
  
    if [[ "$TYPE" == 'int' && -n "$FIELD_NAME" ]] ; then
    
      echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
      echo "	int $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      if [[ $ADD_GS = 'g' || $AGG_GS = 'G' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public int get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 's' || $AGG_GS = 'S' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 'gs' || $AGG_GS = 'GS' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public int get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      else
        
        echo "Incorrect choice"
        
      fi
      
    elif [[ "$TYPE" == 'double' && -n "$FIELD_NAME" ]] ; then
    
      echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
      echo "	double $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      if [[ $ADD_GS = 'g' || $AGG_GS = 'G' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public double get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 's' || $AGG_GS = 'S' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 'gs' || $AGG_GS = 'GS' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public double get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      else
        
        echo "Incorrect choice"
        
      fi
      
    elif [[ "$TYPE" == 'String' && -n "$FIELD_NAME" ]] ; then
    
      echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
      echo "	String $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      if [[ $ADD_GS = 'g' || $AGG_GS = 'G' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public String get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 's' || $AGG_GS = 'S' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      elif [[ $ADD_GS = 'gs' || $AGG_GS = 'GS' ]] ; then
      
        echo "" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	public String get${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		return $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo
        echo "	public void set${FIELD_NAME^}() {" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "		this.$FIELD_NAME = $FIELD_NAME;" >> "$PCKG_NAME/$CLASS_NAME.java"
        echo "	}" >> "$PCKG_NAME/$CLASS_NAME.java"
      
      else
        
        echo "Incorrect choice"
        
      fi
      
    else
    
      echo "Incorrect type or field name"
      
    fi
 
  else 
  
    echo "Incorrect choice"
  
  fi

done

echo "}" >> "$PCKG_NAME/$CLASS_NAME.java"

exit 0
