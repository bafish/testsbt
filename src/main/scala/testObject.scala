import scalikejdbc._

object testObject {
  def main(args: Array[String]): Unit = {
    // initialize JDBC driver & connection pool
    val driverName = "com.mysql.cj.jdbc.Driver"
//    Class.forName(driverName)
//    ConnectionPool.singleton("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456")
    SetupJdbc(driverName, "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456")

    // ad-hoc session provider on the REPL
    implicit val session = AutoSession

//    val entities: List[Map[String, Any]] = sql"select * from user_action".map(_.toMap).list.apply()
//    println(">>>>>> haha: ")
//    println(entities)
    val res = MysqlUtil.getResult("1")
    res.map(r => {
      println(r.get("name").get)
    })
//    println(">>>>> hehehe")
//    println(res)
  }

}
