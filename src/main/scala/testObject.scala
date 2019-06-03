import scalikejdbc._

object testObject {
  def main(args: Array[String]): Unit = {
    // initialize JDBC driver & connection pool
    Class.forName("com.mysql.cj.jdbc.Driver")
    ConnectionPool.singleton("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456")

    // ad-hoc session provider on the REPL
    implicit val session = AutoSession

    val entities: List[Map[String, Any]] = sql"select * from user_action".map(_.toMap).list.apply()
    println(">>>>>> haha: ")
    println(entities)
  }

}
