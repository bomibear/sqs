package sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Send {
    private static final String QUEUE_NAME = "QueueA";

    public static void main(String[] args){
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody("hello everybody")
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }
}
