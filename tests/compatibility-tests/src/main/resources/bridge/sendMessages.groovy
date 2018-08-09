package bridge

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory
import org.apache.activemq.artemis.tests.compatibility.GroovyRun

import javax.jms.*

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

queueName = "sourceQueue";

int LARGE_MESSAGE_SIZE = 10 * 1024;

BYTES_BODY = new byte[3];
BYTES_BODY[0] = (byte) 0x77;
BYTES_BODY[1] = (byte) 0x77;
BYTES_BODY[2] = (byte) 0x77;

String textBody = "a rapadura e doce mas nao e mole nao";

cf = new ActiveMQConnectionFactory("tcp://localhost:61616?confirmationWindowSize=1048576&blockOnDurableSend=false");

String propertyLargeMessage = "JMS_AMQ_InputStream";

Connection connection = cf.createConnection();
Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
Queue queue = null;
try {
    queue = session.createQueue(queueName);
    if (queue == null) {
        throw new Exception("force other")
    }
} catch (Exception e) {
    e.printStackTrace()
    queue = session.createQueue("jms.queue." + queueNameue);
}


MessageProducer producer = session.createProducer(queue);
producer.setDeliveryMode(DeliveryMode.PERSISTENT);

TextMessage message = session.createTextMessage(textBody);
message.setStringProperty("prop", "test");
message.setIntProperty("order", 0)
producer.send(message);

BytesMessage bytesMessage = session.createBytesMessage();
bytesMessage.writeBytes(BYTES_BODY);
bytesMessage.setIntProperty("order", 1)
producer.send(bytesMessage);


for (int i = 0; i < 10; i++) {
    BytesMessage m = session.createBytesMessage();
    m.setIntProperty("count", i);
    m.setIntProperty("order", 2 + i)

    m.setObjectProperty(propertyLargeMessage, createFakeLargeStream(LARGE_MESSAGE_SIZE));

    producer.send(m);
}

ObjectMessage objMessage = session.createObjectMessage("rapadura");
objMessage.setIntProperty("count", 13)
producer.send(objMessage);

MapMessage mapMessage = session.createMapMessage();
mapMessage.setString("prop", "rapadura")
mapMessage.setIntProperty("order", 14)
producer.send(mapMessage);

StreamMessage streamMessage = session.createStreamMessage();
streamMessage.setIntProperty("order", 15);
streamMessage.writeString("rapadura");
streamMessage.writeString("doce");
streamMessage.writeInt(33);
producer.send(streamMessage);

Message plain = session.createMessage();
plain.setStringProperty("plain", "doce");
plain.setIntProperty("order", 15)
producer.send(plain);

session.commit();

connection.close();

// Creates a Fake LargeStream without using a real file
InputStream createFakeLargeStream(final long size) throws Exception {
    return new InputStream() {
        private long count;

        private boolean closed = false;

        @Override
        void close() throws IOException {
            super.close();
            closed = true;
        }

        @Override
        int read() throws IOException {
            if (closed) {
                throw new IOException("Stream was closed");
            }
            if (count++ < size) {
                return GroovyRun.getSamplebyte(count - 1);
            } else {
                return -1;
            }
        }

    };

}



