class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  private val gcdValue = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  def this(n: Int) = this(n, 1) 

  def neg: Rational = new Rational(-this.numer, this.denom) 

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //function for q2
  def sub(that: Rational): Rational = {
    new Rational(
      this.numer * that.denom - that.numer * this.denom,
      this.denom * that.denom
    )
  }
}

object RationalTest {
  def main(args: Array[String]): Unit = {
    //question 01
    println(".................Question 01....................\n")
    val r1 = new Rational(6, 8)
    println(s"Rational number r1: $r1") 

    val r2 = r1.neg
    println(s"Negation of r1: $r2\n") 

    //Question 02
    println(".................Question 02....................\n")
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)
    val result = x.sub(y.sub(z))
    println(s"Result: $result") 
  
  }
}
