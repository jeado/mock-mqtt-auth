package io.github.yeghishe

import akka.http.scaladsl.model.StatusCodes

class MockAuthServiceTest extends ServiceTestBase with MockAuthService {
  import io.circe.generic.auto._

  "AuthService" when {
    "GET /users/1/devices/1/ownership" should {
      "return ownership json" in {
        Get("/users/1/devices/1/ownership") ~> routes ~> check {
          status should be(StatusCodes.OK)
          responseAs[String] should include("admin")
        }
      }
    }
  }
}
