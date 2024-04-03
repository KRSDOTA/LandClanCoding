#!/bin/bash

curl -X PUT -v \
-d "@update_payload.json" \
-H "Content-type: application/json" \
'http://localhost:8080/land-parcel/1' | jq