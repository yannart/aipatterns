#!/bin/sh
#Ejecutar Reconocimiento de patrones.

#Opciones:
MIN_MEMORIA=180m #m por MegaBytes
MAX_MEMORIA=450m

#NO MODIFIQUE EL SIGUIENTE CODIGO
cd "`dirname "$0"`"

# try to discover java
MSG0="Cargando Reconocimiento de Patrones:"
MSG1="Arrancando Reconocimiento de Patrones..."
MSG2="Java exec encontrado en "
MSG3="ERROR, su version de java es antigua "
MSG4="Necesita actualizarse a JRE 1.6.x desde http://www.java.com"
MSG5="Versión de java adecuada encontrada "
MSG6="Configurando entorno..."
MSG7="ERROR, Usted parece no tener un JRE válido."
MSG8="ERROR, Incapaz para localizar a java exec "
MSG9=" organización"
MSG10="Java exec no encontrada en PATH, iniciando autobúsqueda..."
MSG11="Java exec encontrado en PATH. Verificando..."

look_for_java()
{
 JAVADIR=/usr/lib  
 if look_for_javaImpl ; then
    return 0
 fi 
 JAVADIR=/usr/java
 if look_for_javaImpl ; then
       return 0
 fi
 JAVADIR=/opt
 if look_for_javaImpl ; then
       return 0
 fi
 return 1
}

look_for_javaImpl()


check_version()
{
  # short-circuit gcj
  ISGCJ=`${JAVA_PROGRAM_DIR}java -version 2>&1 | grep -i gcj`
  if [ "$ISGCJ" != "" ] ; then
      echo $MSG7
      return 1
  fi

  JAVA_HEADER=`${JAVA_PROGRAM_DIR}java -version 2>&1 | head -n 1`
  JAVA_IMPL=`echo ${JAVA_HEADER} | cut -f1 -d' '`
  if [ "$JAVA_IMPL" = "java" ] ; then
    VERSION=`echo ${JAVA_HEADER} | sed "s/java version \"\(.*\)\"/\1/"`
    if echo $VERSION | grep "^1.[0-3]" ; then
      echo $MSG3 "[${JAVA_PROGRAM_DIR}java = ${VERSION}]" ; echo $MSG4
      return 1
    else
      echo $MSG5 "[${JAVA_PROGRAM_DIR}java = ${VERSION}]" ; echo $MSG6
      return 0	      
    fi
  else
    echo $MSG7 "[${JAVA_PROGRAM_DIR}java = ${JAVA_IMPL}]" ; echo $MSG4
    return 1
  fi
}

echo $MSG1

# locate and test the java executable
if [ `uname` = "Linux" ]; then
  if ! command -v java &>/dev/null; then
    echo $MSG10
    if ! look_for_java ; then
      exit 1
    fi
  else
    echo $MSG11
    if ! check_version ; then
      if ! look_for_java ; then
        exit 1
      fi
    fi
  fi
else
  JAVA_PROGRAM_DIR=""
fi

echo $MSG0

export J2SE_PREEMPTCLOSE=1

${JAVA_PROGRAM_DIR}java -jar -Xms$MIN_MEMORIA -Xmx$MAX_MEMORIA dist/aipatterns.jar
if [ $? -ne 0 ]; then
    echo 
    echo "******************************************************************"
    echo "No se puede ejecutar el programa."
    echo "¿Tal vez estas usando la versión equivocada de Java?"
    echo "(Necesita la Sun's JRE, Java 1.6+)"
    echo "La versión de Java en su PATH es:"
    java -version
    echo 
fi
