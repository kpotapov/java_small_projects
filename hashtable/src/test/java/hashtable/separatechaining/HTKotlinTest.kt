package hashtable.separatechaining

import io.kotlintest.forAll
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

import io.kotlintest.specs.FunSpec

import io.kotlintest.properties.*

class PropertyExample: StringSpec() {
    init {

        "String size" {
            forAll({ a: String, b: String ->
                (a + b).length == a.length + b.length
            })
        }

    }
}
class MyTests : StringSpec() {
    init {
        "strings.length should return size of string" {
            "hello".length shouldBe 5
        }
    }
}