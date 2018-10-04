#!/usr/bin/env bash

folder="../resources/$(basename $(echo $0) | cut -d'-' -f1)"
file="$(basename $0 | cut -d'-' -f2)"
output="$(echo ${folder}/${file} | sed 's#sh#json#g')"

mkdir --parent ${folder}
touch ${output}

export RICH_TEXT_SPACE_ID="pzlh94jb0ghw"
export RICH_TEXT_DELIVERY_TOKEN="7118f4dc5e299a09c5429fb0726a142dbef31876fbed16bfef977c84aa9c29aa"

curl --verbose \
    -H 'Authorization: Bearer '${RICH_TEXT_DELIVERY_TOKEN}  \
    'https://cdn.contentful.com/spaces/'${RICH_TEXT_SPACE_ID}'/locales' \
    | sed 's/'${RICH_TEXT_SPACE_ID}'/<space_id>/g' \
    | sed 's/'${RICH_TEXT_DELIVERY_TOKEN}'/<access_token>/g' \
    | tee ${output}
