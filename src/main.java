import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by Jing Ao on 2016/4/17.
 */
public class main {
    public static void main(String args[]) throws InterruptedException {
        ActorSystem system = ActorSystem.create("system");
        ActorRef subscriber1 = system.actorOf(Props.create(Subscriber.class), "subscriber1");
//another node
        ActorRef subscriber2 = system.actorOf(Props.create(Subscriber.class), "subscriber2");
        ActorRef subscriber3 = system.actorOf(Props.create(Subscriber.class), "subscriber3");

        //somewhere else
        Thread.sleep(2000);
        ActorRef publisher = system.actorOf(Props.create(Publisher.class), "publisher");
// after a while the subscriptions are replicated
        publisher.tell("hello", null);
//        System.out.println(System.getProperty("java.library.path"));
    }
}
