### spring-cloud-function-aws-sample

**create**<br />
aws lambda create-function --function-name cloudfunction-aws --role arn:aws:iam::xxx:role/lambda_basic_execution --zip-file fileb://target/cloudfunction-aws-0.0.1-SNAPSHOT-aws.jar --handler paq.functions.GreeterFunctionHandler  --runtime java8 --region eu-west-1 --timeout 30 --memory-size 1024 --publish

**update**<br />
aws lambda update-function-code  --function-name cloudfunction-aws   --zip-file fileb://target/cloudfunction-aws-0.0.1-SNAPSHOT-aws.jar

**execute**<br />
aws lambda  invoke --invocation-type Event --function-name cloudfunction-aws --region eu-west-1  --payload file://input.txt  --profile default outputfile.txt
