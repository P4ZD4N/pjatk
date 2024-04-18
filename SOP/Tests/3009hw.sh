#!/bin/bash

print_polish() {
  
   case $ERROR_CODE in
  0) ;;
  1) echo "Nieprawidłowy argument źródłowy" ;;
  2) echo "Nieprawidłowy argument docelowy" ;;
  3) echo "Argument źródłowy nie znajduje się w bieżącym projekcie" ;;
  4) echo "Argument docelowy nie znajduje się w bieżącym projekcie" ;;
  5) echo "Nazwa pliku źródłowego nie jest prawidłowym plikiem java" ;;
  6) echo "Brak informacji o pakiecie w pliku źródłowym" ;;
  7) echo "Błąd narzędzia zewnętrznego: grep" ;;
  8) echo "Brak informacji o klasie publicznej w pliku źródłowym" ;;
  9) echo "Błąd narzędzia zewnętrznego: grep" ;;
  10) echo "Docelowa lokalizacja już zawiera coś o tej nazwie" ;;
  11) echo "Nie można usunąć pliku źródłowego" ;;
  *) echo "Nieznany kod błędu" ;;

  esac >&2

}

print_english() {

  case $ERROR_CODE in
  0) ;;
  1) echo "Invalid source argument" ;;
  2) echo "Invalid destination argument" ;;
  3) echo "Source argument is not in the current project" ;;
  4) echo "Destination argument is not in the current project" ;;
  5) echo "Source filename is not a valid java file" ;;
  6) echo "No package information in a source file" ;;
  7) echo "External tool error: grep" ;;
  8) echo "No public class information in a source file" ;;
  9) echo "External tool error: grep" ;;
  10) echo "Destination already contains sth with this name" ;;
  11) echo "Cannot remove source file" ;;
  *) echo "Unkown error code" ;;

  esac >&2

}

print_french() {

  case $ERROR_CODE in
  0) ;;
  1) echo "Argument source invalide" ;;
  2) echo "Argument de destination invalide" ;;
  3) echo "L'argument source n'est pas dans le projet actuel" ;;
  4) echo "L'argument de destination n'est pas dans le projet actuel" ;;
  5) echo "Le nom du fichier source n'est pas un fichier Java valide" ;;
  6) echo "Aucune information de package dans un fichier source" ;;
  7) echo "Erreur d'outil externe: grep" ;;
  8) echo "Aucune information de classe publique dans un fichier source" ;;
  9) echo "Erreur d'outil externe: grep" ;;
  10) echo "La destination contient déjà quelque chose avec ce nom" ;;
  11) echo "Impossible de supprimer le fichier source" ;;
  *) echo "Code d'erreur inconnu" ;;
  
  esac >&2
  
}

print_russian() {

  case $ERROR_CODE in
  0) ;;
  1) echo "Недопустимый исходный аргумент" ;;
  2) echo "Недопустимый целевой аргумент" ;;
  3) echo "Исходный аргумент не находится в текущем проекте" ;;
  4) echo "Целевой аргумент не находится в текущем проекте" ;;
  5) echo "Имя исходного файла не является допустимым java файлом" ;;
  6) echo "Нет информации о пакете в исходном файле" ;;
  7) echo "Ошибка внешнего инструмента: grep" ;;
  8) echo "Нет информации о публичном классе в исходном файле" ;;
  9) echo "Ошибка внешнего инструмента: grep" ;;
  10) echo "В папке назначения уже есть что-то с таким именем" ;;
  11) echo "Невозможно удалить исходный файл" ;;
  *) echo "Неизвестный код ошибки" ;;
  
  esac >&2
  
}
 
EXECUTABLE="$1"
shift
ARGUMENTS="$@"

[ -z "$EXECUTABLE" ] && exit 1
[ ! -x "$EXECUTABLE" ] && exit 2

"$EXECUTABLE" "$ARGUMENTS"
ERROR_CODE="$?"

read -p "Choose language (pl/eng/fr/ru): " LANG

if [[ "$LANG" = "pl" || "$LANG" = "PL" ]] ; then

  print_polish

elif [[ "$LANG" = "eng" || "$LANG" = "ENG" ]] ; then

  print_english

elif [[ "$LANG" = "fr" || "$LANG" = "FR" ]] ; then

  print_french

elif [[ "$LANG" = "ru" || "$LANG" = "RU" ]] ; then

  print_russian

else

  echo "Error"
  exit 1
  
fi

exit 0
