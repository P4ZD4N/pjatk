#!/bin/bash

i=1
while IFS= read -r line; do
  echo "$i. Line: $line"
  read n1 n2 <<< "$line"

  if [[ $n1 =~ ^[0-9]+$ && $n2 =~ ^[0-9]+$ ]]; then
    printf "Sum: %d\n" $((n1 + n2))
    printf "Difference: %d\n" $((n1 - n2))
    printf "Product: %d\n" $((n1 * n2))

    if [ $n2 -eq 0 ]; then
      echo "Quotient: Cannot divide by 0"
    else
      printf "Quotient: %d\n" $((n1 / n2))
    fi

    echo
  else
    echo "Invalid number"
    echo
  fi
    ((i++))
done < file1.txt

exit 0
