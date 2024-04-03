#!/bin/bash

curl -X POST -v \
-d "@create_payload.json" \
-H "Content-type: application/json" \
'http://localhost:8080/land-parcel' | jq