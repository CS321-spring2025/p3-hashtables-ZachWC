#!/bin/sh

function header(){
	output=$1
	for i in {1..80} 
	do
		echo -n "-" >> $output
	done
	echo >> $output
}

echo
echo "Compiling the source code"
echo
javac *.java

if ! test -f HashtableExperiment.class
then
	echo
	echo "HashtableExperiment.class not found! Not able to test!! "
	echo
	exit 1
fi

echo
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo "Running test for word-list for varying load factors"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
echo


dos2unix test-cases/* >& /dev/null

debugLevel=1
loadFactors="0.5 0.6 0.7 0.8 0.9 0.95 0.99"
dataSources="1 2 3"

for load in $loadFactors; do
    for dataSource in $dataSources; do
        echo "Running java HashtableExperiment dataSource = $dataSource loadFactor = $load"
        java HashtableExperiment "$dataSource" "$load" "$debugLevel" >> /dev/null
        dos2unix linear-dump.txt double-dump.txt >& /dev/null

        if [ "$dataSource" = "3" ]; then  # Only compare dumps for word-list data source
            echo
            diff -w -B linear-dump.txt "test-cases/word-list-$load-linear-dump.txt" > "diff-linear-$load.out"
            if [ "$?" = "0" ]; then
                echo "Test PASSED for linear probing, word-list, and load = $load"
                /bin/rm -f "diff-linear-$load.out"
            else
                echo "==> Test FAILED for linear probing, word-list, load = $load!!"
                echo "    Check the file diff-linear-$load.out for differences"
            fi

            diff -w -B double-dump.txt "test-cases/word-list-$load-double-dump.txt" > "diff-double-$load.out"
            if [ "$?" = "0" ]; then
                echo "Test PASSED for double probing, word-list, and load = $load"
                /bin/rm -f "diff-double-$load.out"
            else
                echo "==> Test FAILED for double probing, word-list, load = $load!!"
                echo "    Check the file diff-double-$load.out for differences"
            fi
        else
            echo "Dump file tests skipped for data source $dataSource"
        fi
        echo
    done
done

echo "Tests Completed!"

