echo "Enter a Number:"
read a
 
rev=0
rem=0
temp=$a
 
while [ $a -gt 0 ]
do
        rem=` expr $a % 10 `
        temp=` expr $rev \* 10 `
        rev=` expr $temp + $rem `
        a=` expr $a / 10`
done
 
echo "Reverse of the number is $rev"
