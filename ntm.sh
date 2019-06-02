#!/bin/bash

mkdir -p tmp

N=6
date=$(date +%s)
members=("Aya BOUAKKAZ <ayabouakkaz43@gmail.com>" "Aya BOUAKKAZ <ayabouakkaz43@gmail.com>" "Aya BOUAKKAZ <ayabouakkaz43@gmail.com>" "Nadjib ATTIG <attignadjib@outlook.com>" "Ali SI-LARBI <ali.silarbi00@gmail.com>" )

echo "Generating fake contributions"
for i in $(seq $N -1 0)
    do
        rand=$(((RANDOM % 75) + 1))
        for j in $(seq 5 $rand)
            do
                filename="tmp/${i}_${j}"

                let "new_date = $date - ($i * 60*60*24)"

                touch $filename
                random=$$$(date +%s)
                author=${members[$random % ${#members[@]}]}
                msg="lorem"
                git add $filename
                git commit --date="$new_date" -m "$msg" --author "$author <$author@viacesi.fr>" >/dev/null 2>>../error.log
            done
    done

