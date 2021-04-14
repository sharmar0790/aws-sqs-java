#!/bin/bash
set -eo pipefail
#ARTIFACT_BUCKET=$(cat bucket-name.txt)

TEMPLATE=template-cf.yml

#aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file out.yml
aws cloudformation deploy --template-file $TEMPLATE --stack-name aws-sqs --capabilities CAPABILITY_NAMED_IAM