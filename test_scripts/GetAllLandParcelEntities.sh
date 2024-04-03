#!/bin/bash

curl -X GET -v \
'http://localhost:8080/land-parcel/get' | jq