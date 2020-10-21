#!/bin/bash

$(aws ecr get-login --no-include-email --region us-west-2)
docker tag insurance-portal/member-details:latest 449094484520.dkr.ecr.us-west-2.amazonaws.com/insurance-portal/member-details:latest
docker push 449094484520.dkr.ecr.us-west-2.amazonaws.com/insurance-portal/member-details:latest