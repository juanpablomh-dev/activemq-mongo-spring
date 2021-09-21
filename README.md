# activemq-mongo-spring

Project example using ActiveMQ, Mongo and Spring technologies.
It has two services that interact with a message queue.

- El primero de ellos (service-publisher) genera datos aleatorios y los publica en el broker.
- El segundo (service-consumer) consume los mensajes de la cola, procesa la información y si corresponde, inserta registros en mongodb.

The information stored in the database can be consulted using the rest services:

- http://localhost:8092/tickets
- http://localhost:8092/tickets{id}
