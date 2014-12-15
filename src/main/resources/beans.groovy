

import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.listener.DefaultMessageListenerContainer
import org.springframework.jms.support.destination.BeanFactoryDestinationResolver
import org.apache.activemq.command.ActiveMQTopic
import org.apache.activemq.command.ActiveMQQueue


beans {
	topicDestination(ActiveMQTopic,'${broker.topic.name}')
	queueDestination(ActiveMQQueue,'${broker.queue.name}')

	xmlns context:"http://www.springframework.org/schema/context"
	context.'component-scan'('base-package': "ru.udm.jms")
	context.'property-placeholder'('location':'classpath:config.properties')
//	context.'annotation-config'

	xmlns jms:"http://www.springframework.org/schema/jms"
//	jms.'annotation-driven'


	connectionFactory(ActiveMQConnectionFactory){ brokerURL = 'tcp://localhost:61616' }

	destinationResolver(BeanFactoryDestinationResolver)

	jmsContainer(DefaultMessageListenerContainer){
		connectionFactory = ref('connectionFactory')
		destination = ref('queueDestination')
		messageListener = ref('helloMessageListner')
	}

	jmsTopicContainer(DefaultMessageListenerContainer){
		connectionFactory = ref('connectionFactory')
		destinationResolver = ref('destinationResolver')
		concurrentConsumers = 1
		destinationName = 'topicDestination'
		messageListener = ref('subscriber')
		sessionAcknowledgeModeName = 'AUTO_ACKNOWLEDGE'
		pubSubDomain = true
	}

	jmsTopicDurableContainer(DefaultMessageListenerContainer){
		connectionFactory = ref('connectionFactory')
		destinationResolver = ref('destinationResolver')
		concurrentConsumers = 1
		destinationName = 'topicDestination'
		messageListener = ref('durableSubscriber')
		sessionAcknowledgeModeName = 'AUTO_ACKNOWLEDGE'
		pubSubDomain = true
		subscriptionDurable = true
		clientId = '${broker.topic.durableId}'
		durableSubscriptionName = '${broker.topic.durableName}'
	}
}
