#!/bin/bash

pip install --user awscli
export PATH=$PATH:$HOME/.local/bin
docker login -u AWS -p $(aws ecr get-login-password --region us-west-2) 449094484520.dkr.ecr.us-west-2.amazonaws.com
docker tag insurance-portal/member-details:latest 449094484520.dkr.ecr.us-west-2.amazonaws.com/insurance-portal/member-details:latest
docker push 449094484520.dkr.ecr.us-west-2.amazonaws.com/insurance-portal/member-details:latest