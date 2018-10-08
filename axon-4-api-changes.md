Major API Changes
=================

## Serialization
Instead of throwing an `UnknownSerializedTypeException`, serializers now return an `UnknownSerializedType` object, 
which provides access to the raw data in any supported intermediate representation, such as `JsonNode` or Dom4J 
`Document`.

Other changes
=============

* TrackingToken removed from `AnnotatedSaga` and `SagaStore` implementations

### Moved classes

|                                 Axon 3                                        |                                  Axon 4                                    |
|-------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| org.axonframework.messaging.MessageStream                                     | org.axonframework.common.stream.BlockingStream                             |
| org.axonframework.messaging.StreamUtils                                       | org.axonframework.common.stream.StreamUtils                                |
| org.axonframework.queryhandling.responsetypes.AbstractResponseType            | org.axonframework.messaging.responsetypes.AbstractResponseType             |
| org.axonframework.queryhandling.responsetypes.InstanceResponseType            | org.axonframework.messaging.responsetypes.InstanceResponseType             |
| org.axonframework.queryhandling.responsetypes.MultipleInstancesResponseType   | org.axonframework.messaging.responsetypes.MultipleInstancesResponseType    |
| org.axonframework.queryhandling.responsetypes.ResponseType                    | org.axonframework.messaging.responsetypes.ResponseType                     |
| org.axonframework.queryhandling.responsetypes.ResponseTypes                   | org.axonframework.messaging.responsetypes.ResponseTypes                    |

### Removed classes
|                           Class                                    |             Why                              |
|--------------------------------------------------------------------|----------------------------------------------|
| org.axonframework.serialization.MessageSerializer                  | All messages are serializable now.           |
| org.axonframework.serialization.SerializationAware                 | All messages are serializable now.           |
| org.axonframework.serialization.UnknownSerializedTypeException     | Serializers now return UnknownSerializedType |
| org.axonframework.commandhandling.disruptor.DisruptorConfiguration | Removed in favor DisruptorCommandBus.Builder |

### Classes for which the Constructor has been replaced for a Builder

- org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter
- org.axonframework.jgroups.commandhandling.JGroupsConnector
- org.axonframework.springcloud.commandhandling.SpringCloudCommandRouter
- org.axonframework.springcloud.commandhandling.SpringCloudHttpBackupCommandRouter
- org.axonframework.springcloud.commandhandling.SpringHttpCommandBusConnector
- org.axonframework.commandhandling.AsynchronousCommandBus
- org.axonframework.commandhandling.SimpleCommandBus
- org.axonframework.commandhandling.disruptor.DisruptorCommandBus
- org.axonframework.commandhandling.distributed.DistributedCommandBus
- org.axonframework.commandhandling.gateway.AbstractCommandGateway
- org.axonframework.commandhandling.gatewayCommandGatewayFactory.GatewayInvocationHandler
- org.axonframework.commandhandling.gatewayCommandGatewayFactory.DispatchOnInvocationHandler
- org.axonframework.commandhandling.gateway.DefaultCommandGateway
- org.axonframework.commandhandling.model.AbstractRepository
- org.axonframework.commandhandling.model.LockingRepository
- org.axonframework.commandhandling.model.GenericJpaRepository
- org.axonframework.eventsourcing.EventSourcingRepository
- org.axonframework.eventsourcing.CachingEventSourcingRepository
- org.axonframework.commandhandling.AggregateAnnotationCommandHandler
- org.axonframework.deadline.quartz.QuartzDeadlineManager
- org.axonframework.deadline.SimpleDeadlineManager
- org.axonframework.eventhandling.scheduling.java.SimpleEventScheduler
- org.axonframework.eventhandling.scheduling.quartz.QuartzEventScheduler
- org.axonframework.eventhandling.tokenstore.jdbc.JdbcTokenStore
- org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore
- org.axonframework.eventhandling.saga.repository.jdbc.JdbcSagaStore
- org.axonframework.eventhandling.saga.repository.jpa.JpaSagaStore
- org.axonframework.eventhandling.saga.repository.AnnotatedSagaRepository
- org.axonframework.eventhandling.saga.repository.CachingSagaStore
- org.axonframework.eventhandling.saga.repository.LockingSagaRepository
- org.axonframework.eventhandling.saga.AbstractSagaManager
- org.axonframework.eventhandling.saga.AnnotatedSagaManager
