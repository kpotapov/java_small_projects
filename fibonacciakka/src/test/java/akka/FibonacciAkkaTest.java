package akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static akka.pattern.PatternsCS.ask;
import static org.junit.Assert.assertEquals;

public class FibonacciAkkaTest {
	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		TestKit.shutdownActorSystem(system);
		system = null;
	}

	/**
	 * A test that a fibonacciNumber calculation should be done with akka
	 */
	@Test
	public void testGreeterActorSendingOfGreeting() throws ExecutionException, InterruptedException {
		final ActorRef            fibonacciActor  = system.actorOf(Props.create(FibonacciActor.class), "main");
		CompletableFuture<Object> fibonacciFuture = ask(fibonacciActor, new Integer(20), 20000).toCompletableFuture();

		int actualResult = ((Integer) fibonacciFuture.get()).intValue();
		assertEquals(6765, actualResult);
	}
}
