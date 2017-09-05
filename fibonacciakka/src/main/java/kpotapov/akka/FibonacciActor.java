package kpotapov.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.pattern.PatternsCS;
import scala.Option;

import java.util.concurrent.CompletableFuture;


public class FibonacciActor extends AbstractActor {

	private Integer value;
	private Integer index;

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Integer.class, idx -> {
					if (value != null && index.equals(idx)) {
						this.sender().tell(value, this.getSender());
					} else if (idx.equals(1)) {
						value = 1;
						index = 1;
						this.sender().tell(new Integer(1), this.getSender());
					} else if (idx.equals(2)) {
						value = 1;
						index = 2;
						this.sender().tell(new Integer(1), this.getSender());
					} else {
						int    ind1  = idx - 1;
						String name1 = String.valueOf(new Integer(ind1));

						Option<ActorRef> child = getContext().child(name1);
						ActorRef         fibonacciActorOne1;
						if (child.isDefined())
							fibonacciActorOne1 = child.get();
						else {
							fibonacciActorOne1 = this.getContext().actorOf(Props.create(FibonacciActor.class), name1);
						}
						CompletableFuture<Object> f1Future = PatternsCS.ask(fibonacciActorOne1, new Integer(ind1), 10000).toCompletableFuture();

						int    ind2  = idx - 2;
						String name2 = String.valueOf(new Integer(ind2));

						Option<ActorRef> child2 = getContext().child(name1);
						final ActorRef   fibonacciActorTwo2;
						if (child2.isDefined())
							fibonacciActorTwo2 = child2.get();
						else {
							fibonacciActorTwo2 = this.getContext().actorOf(Props.create(FibonacciActor.class), name2);
						}


						CompletableFuture<Object> f2Future = PatternsCS.ask(fibonacciActorTwo2, new Integer(ind2), 10000).toCompletableFuture();

						int i1 = ((Integer) f1Future.get()).intValue();
						System.out.println("-------------1 " + i1);

						int i2 = ((Integer) f2Future.get()).intValue();
						System.out.println("-------------2 " + i2);

						value = i1 + i2;
						index = idx;
						Integer msg = new Integer(value);
						this.sender().tell(msg, this.getSender());
					}
				})
				.matchAny(x -> {
					System.out.println("Unknown input value");
				})
				.build();
	}
}
