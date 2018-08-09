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

MessageConsumer consumer;

consumer = session.createConsumer(queue);
connection.start();


TextMessage message = (TextMessage) consumer.receive(5000);
GroovyRun.assertNotNull(message);
GroovyRun.assertEquals(textBody, message.getText());
GroovyRun.assertEquals("test", message.getStringProperty("prop"));

BytesMessage bm = (BytesMessage) consumer.receive(5000);
GroovyRun.assertNotNull(bm);

GroovyRun.assertEquals(3L, bm.getBodyLength());

byte[] body = new byte[3];
bm.readBytes(body);

GroovyRun.assertEquals(BYTES_BODY, body);

for (int m = 0; m < 10; m++) {
    BytesMessage rm = (BytesMessage) consumer.receive(10000);
    GroovyRun.assertNotNull(rm);
    GroovyRun.assertEquals(m, rm.getIntProperty("count"));

    byte[] data = new byte[1024];

    for (int i = 0; i < LARGE_MESSAGE_SIZE; i += 1024) {
        int numberOfBytes = rm.readBytes(data);
        GroovyRun.assertEquals(1024, numberOfBytes);
        for (int j = 0; j < 1024; j++) {
            GroovyRun.assertEquals(GroovyRun.getSamplebyte(i + j), data[j]);
        }
    }
}


ObjectMessage obj = consumer.receive(5000);
GroovyRun.assertNotNull(obj);
GroovyRun.assertEquals("rapadura", obj.getObject().toString());

MapMessage mapMessage = consumer.receive(5000);
GroovyRun.assertNotNull(mapMessage);
GroovyRun.assertEquals("rapadura", mapMessage.getString("prop"));

StreamMessage streamMessage = consumer.receive(5000);
GroovyRun.assertNotNull(streamMessage);
GroovyRun.assertEquals("rapadura", streamMessage.readString());
GroovyRun.assertEquals("doce", streamMessage.readString());
GroovyRun.assertTrue(streamMessage.readInt() == 33);

Message plain = consumer.receive(5000);
GroovyRun.assertNotNull(plain);
GroovyRun.assertEquals("doce", plain.getStringProperty("plain"));

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



