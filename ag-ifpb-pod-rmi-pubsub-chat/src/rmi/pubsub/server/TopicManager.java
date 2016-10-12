package rmi.pubsub.server;

import java.rmi.RemoteException;

import rmi.pubsub.share.Publisher;
import rmi.pubsub.share.Topic;

public interface TopicManager extends Publisher, Topic {
  void notifySubscribers() throws RemoteException;
}
