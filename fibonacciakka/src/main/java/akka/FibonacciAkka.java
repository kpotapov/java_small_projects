package akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static akka.pattern.PatternsCS.ask;

public class FibonacciAkka {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final int         FIB_INDEX = 20;
		final ActorSystem system    = ActorSystem.create("workbench");
		try {

			final ActorRef            fibonacciActor  = system.actorOf(Props.create(FibonacciActor.class), "main");
			CompletableFuture<Object> fibonacciFuture = ask(fibonacciActor, new Integer(FIB_INDEX), 20000).toCompletableFuture();

			System.out.println("------------- Fibonaccy number #"+FIB_INDEX+ "=" + ((Integer) fibonacciFuture.get()).intValue());

			System.out.println(">>> Press ENTER to exit <<<");
			System.in.read();
		} catch (IOException ioe) {
		} finally {
			system.terminate();
		}
	}
}
