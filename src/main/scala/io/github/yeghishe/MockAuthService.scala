package io.github.yeghishe

import java.lang.management.ManagementFactory

import akka.http.scaladsl.server.Directives.pathPrefix
import akka.http.scaladsl.server.{ Directives, Route }
import io.circe.Json

import scala.concurrent.duration._
import de.heikoseeberger.akkahttpcirce.CirceSupport

trait MockAuthService extends BaseService {
  import Directives._
  import CirceSupport._
  import io.circe.generic.auto._

  protected case class OwnerShip(owner_type: String)
  private final case class Foo(owner_type: String)

  override protected def routes: Route =
    get {
      complete {
        Foo("admin")
      }
    }
}

