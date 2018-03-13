package hashtable.openaddressing

import java.util

import org.scalacheck.{Gen, Prop}
import org.scalacheck.Prop._
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class HTATestProp extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {

  test("compare put of java hashtable and ht") {
    val i1 = Gen.choose(1, 10)
    val amount = 11
    val hashtable = new util.Hashtable[Int, Int](amount)
    val ht = new HTA[Int, Int](amount)

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
    val ht = new HTA[Int, Int](amount)

    forAll(i1) {
      n =>
        hashtable.put(n, n);
        ht.put(n, n);
        val bool = hashtable.size() == ht.size()
        if (!bool){
          println()
          println( "hashtable"+hashtable )
          println( "ht"+ht )
        }
        bool should be (true)
    }
  }


}
