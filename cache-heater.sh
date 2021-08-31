for i in {1..40}
do
   http get localhost:8080/customers/$i
done
