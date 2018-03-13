package hashtable.separatechaining

import java.util

import org.scalacheck.Gen.Parameters
import org.scalacheck.Prop._
import org.scalacheck.util.Pretty.Params
import org.scalacheck.{Gen, Prop}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}
import org.scalacheck.Prop
import org.scalatest.prop.Checkers._

class HTTest extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {

  test("compare put of java hashtable and ht") {
    val i1 = Gen.choose(0, 10)
    val amount = 11
    val hashtable = new util.Hashtable[Int, Int](amount)
    val ht = new HT[Int, Int](amount)

    forAll(i1) {
      n =>
        hashtable.put(n, n);
        ht.put(n, n);
        hashtable.get(n) == ht.get(n) should be (true)
    }
  }

  test("compare size of java hashtable and ht") {
    val i1 = Gen.choose(1, 10)
    val amount = 11
    val hashtable = new util.Hashtable[Int, Int](amount)
    val ht = new HT[Int, Int](amount)

    forAll(i1) {
      n =>
        hashtable.put(n, n);
        ht.put(n, n);
        hashtable.size() == ht.size() should be (true)
    }
  }


  val smallInteger = Gen.choose(0,100)

  val propSmallInteger = Prop.forAll(smallInteger) { n =>
    n >= 0 && n <= 100
  }

  test("internal-check-propSmallInteger") {
    propSmallInteger.check
  }

}
