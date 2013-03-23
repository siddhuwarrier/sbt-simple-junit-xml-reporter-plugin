package ca.seibelnet

import sbt._
import Keys._

/**
 * User: bseibel
 * Date: 12-04-25
 * Time: 12:02 PM
 */

object JUnitTestReportingPlugin extends Plugin {
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
