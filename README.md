# activemq-mongo-spring

Project example using ActiveMQ, Mongo and Spring technologies.
It has two services that interact with a message queue.

- The first one (service-publisher) generates random data and publishes it in the broker.
- The second (service-consumer) consumes the messages from the queue, processes the information and, if applicable, inserts records in mongodb.

The information stored in the database can be consulted using the rest services:

- http://localhost:8092/tickets
- http://localhost:8092/tickets{id}
