package ca.seibelnet

import sbt._
import Keys._

/**
 * User: bseibel
 * Date: 12-04-25
 * Time: 12:02 PM
 */

object JUnitTestReporting extends Plugin {
	val testReportLocation = SettingKey[String]("./target/test-reports/")
	val reportingTask = TaskKey[Unit]("junit-xml-reporter")
  override def settings = Seq(
	  testReportLocation := "./target/test-reports/",
		testListeners <+= testReportLocation map {path => new JUnitTestListener(path)}
  )
}

class JUnitTestListener(val targetPath: String) extends TestReportListener {

  var currentOutput: Option[TestGroupXmlWriter] = None

  def testEvent(event: TestEvent) {
      currentOutput.foreach(_.addEvent(event))
  }

  def endGroup(name: String, result: TestResult.Value) {
    flushOutput()
  }

  def endGroup(name: String, t: Throwable) {
    flushOutput()
  }

  def startGroup(name: String) {
    currentOutput = Some(TestGroupXmlWriter(name))
  }

  private def flushOutput() {
    val file = new File(targetPath)
    file.mkdirs()

    currentOutput.foreach(_.write(targetPath))
  }

}
